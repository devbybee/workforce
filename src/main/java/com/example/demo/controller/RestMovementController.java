package com.example.demo.controller;

import com.example.demo.config.Config;
import com.example.demo.config.Helper;
import com.example.demo.model.AircraftMovement;
import com.example.demo.payload.*;
import com.example.demo.repository.AircraftMovementRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rest")
public class RestMovementController {
    private static final Logger logger = LoggerFactory.getLogger(RestMovementController.class);

    @Autowired
    private AircraftMovementRepository movementRepository;

    private FlightData flightData;
    private FlightTime flightTime;
    private FlightDelay flightDelay;

    private String route = "";
    private String bound = "";
    private String station = "";

    private Helper helper;
    private RestResponse restResponse;
    private RestFailed restFailed;

    private Config config = new Config();

    private String isNullDate(String date) throws ParseException {
        if (date.equals("1900-01-01T00:00:00")) {
            return null;
        } else {
            helper = new Helper();
            return helper.setLocalTime(date);
        }

    }

    private ApiResponse sendPostEntity(MovementResponse request) {

        //String url = "http://ws-wfm.asyst.co.id/flightData/create";
        String url = config.getWfmHost() + "flightData/create";
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();

        ApiResponse response = new ApiResponse();

        try {
            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(request);
            System.out.println(jsonInString);
            response = restTemplate.postForObject(url, request, ApiResponse.class);
            System.out.println(response.getMessage());
            //return response;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping("/sendWfm")
    public ResponseEntity<?> getDataMovement() throws ParseException {
        helper = new Helper();
        List<AircraftMovement> aircraftMovements = movementRepository.getAllCgkMovement(helper.getStartDate(), helper.getEndDate());

        restResponse = new RestResponse();
        restResponse.setTotal(aircraftMovements.size());

        /**
         * create list for all transaction recorded
         */
        List<String> success =  new ArrayList<>();
        //response failed must be equal with RestFailed class
        List<RestFailed> failed =  new ArrayList<>();

        for (int i = 0; i < aircraftMovements.size(); i++) {
            /**
             * set flightData
             */
            flightData = new FlightData();

            /**
             * get flight date from est chox off
             */
            String estChoxOff = isNullDate(aircraftMovements.get(i).getEstChoxOff().toString() + "T" + aircraftMovements.get(i).getEstChoxOffTime().toString());
            String flightDate = aircraftMovements.get(i).getPlanDate().toString();

            if (estChoxOff != null) {
                flightDate = estChoxOff.substring(0, 10);
            }

            flightData.setFlight_date(flightDate);
            //end

            flightData.setAirline(helper.removeSpace(aircraftMovements.get(i).getCarrierCode()));
            flightData.setTrip(aircraftMovements.get(i).getFlightNumber());;
            flightData.setBlockTime(isNullDate(aircraftMovements.get(i).getChoxOff().toString() + "T" + aircraftMovements.get(i).getChoxOffTime().toString()));
            flightData.setHandling_type(aircraftMovements.get(i).getFlightType());
            flightData.setReg(aircraftMovements.get(i).getAircraftRegistration());
            flightData.setLeg(aircraftMovements.get(i).getDepartureStation() + " " + aircraftMovements.get(i).getArrivalStation());

            if (aircraftMovements.get(i).getDepartureStation().equals("CGK")) {
                route = aircraftMovements.get(i).getArrivalStation();
                bound =  "D";
                station = aircraftMovements.get(i).getDepartureStation();
            } else if (aircraftMovements.get(i).getArrivalStation().equals("CGK")) {
                route = aircraftMovements.get(i).getDepartureStation();
                bound =  "A";
                station = aircraftMovements.get(i).getArrivalStation();
            }

            flightData.setRou(helper.removeSpace(route));
            flightData.setBound(bound);

            /**
             * set flightTime
             */
            flightTime =  new FlightTime(
                    estChoxOff,
                    estChoxOff,
                    isNullDate(aircraftMovements.get(i).getChoxOn().toString() + "T" + aircraftMovements.get(i).getChoxOnTime().toString())
            );

            flightData.setFlight_time(flightTime);

            /**
             * set flight delay
             */
            flightDelay =  new FlightDelay();
            flightData.setDelay(flightDelay);

            /**
             * set station resource
             */
            StationResource stationResource = new StationResource();
            stationResource.setStation(station);
            /**
             * set pax Data
             */
            Pax pax =  new Pax();

            MovementData movementData = new MovementData(flightData);
            movementData.setStation_resource(stationResource);
            movementData.setPax(pax);

            Object data = movementData;

            MovementResponse response =  new MovementResponse("flightinfo", data);
            ApiResponse request = sendPostEntity(response);

            String idx = aircraftMovements.get(i).getIdx().toString();
            String responseMessage = request.getMessage();

            if (responseMessage.equals("Success")) {
                success.add(idx);
                //String status = "success";
            } else {
                /**
                 * declare new to reiniziate value of restfailed
                 */
                restFailed = new RestFailed();
                //failed.add(idx);
                restFailed.setIdx(idx);
                restFailed.setMessage(responseMessage);

                failed.add(restFailed);
            }

            //return ResponseEntity.ok(new ApiResponse(msg));
        }

        restResponse.setFailed(failed);
        restResponse.setSuccess(success);

        return ResponseEntity.ok(restResponse);
    }
}
