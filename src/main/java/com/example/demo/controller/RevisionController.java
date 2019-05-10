package com.example.demo.controller;

import com.example.demo.config.Config;
import com.example.demo.config.Helper;
import com.example.demo.model.AircraftMovement;
import com.example.demo.model.Revision;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.MovementResponse;
import com.example.demo.payload.RestFailed;
import com.example.demo.payload.RestResponse;
import com.example.demo.payload.revision.*;
import com.example.demo.repository.RevisionRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rest")
public class RevisionController {
    private static final Logger logger = LoggerFactory.getLogger(RevisionController.class);

    @Autowired
    RevisionRepository revisionRepository;

    private Helper helper;

    private RestResponse restResponse;
    private TaskData taskData;
    private MovementResponse movementResponse;
    private RevisionData revisionData;
    private QualInfo qualInfo;
    private RescInfo rescInfo = new RescInfo();
    private RefInfo refInfo;
    private Config config = new Config();
    private RestFailed restFailed;

    private String changeFormatDate(String date, Boolean isDate) {
        String format;

        if (isDate) {
            format = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        } else {
            format = date.substring(0, 2) + ":" + date.substring(2, 4) + ":" + date.substring(4, 6);
        }

        return format;
    }

    private ApiResponse sendPostEntity(MovementResponse request) {
        String url = config.getWfmHost() + "taskData/create";
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();

        ApiResponse response = new ApiResponse();

        try {
            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(request);
            System.out.println(jsonInString);
            response = restTemplate.postForObject(url, request, ApiResponse.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping("/sendWfmRevision")
    public ResponseEntity<?> getDataRevision() {
        helper = new Helper();
        List<Revision> revisions = revisionRepository.getLatestRevision(helper.getLocalTimeStart(), helper.getLocalTimeEnd());

        restResponse = new RestResponse();
        restResponse.setTotal(revisions.size());


        /**
         * create list for all transaction recorded
         */
        List<String> success =  new ArrayList<>();
        List<RestFailed> failed =  new ArrayList<>();

        for (int i = 0; i < revisions.size(); i++) {
            /**
             * set task data
             */
            taskData =  new TaskData();
            taskData.setTask_desc(revisions.get(i).getDescription());
            taskData.setStart_date(changeFormatDate(revisions.get(i).getPlanDate(), true));
            taskData.setStart_time(changeFormatDate(revisions.get(i).getPlanTime(), false));
            taskData.setEnd_date(changeFormatDate(revisions.get(i).getSchedServiceDate(), true));
            taskData.setEnd_time(changeFormatDate(revisions.get(i).getSchedSerViceTime(), false));
            taskData.setLocation(revisions.get(i).getWorkCtrCode());

            qualInfo = new QualInfo(revisions.get(i).getRevisionType());

            taskData.setQual_info(qualInfo);

            refInfo = new RefInfo(revisions.get(i).getRevisionNumber(), revisions.get(i).getRegistration(),
                    changeFormatDate(revisions.get(i).getPlanDate(), true));

            revisionData = new RevisionData();
            revisionData.setTaskdata(taskData);
            revisionData.setResc_info(rescInfo);
            revisionData.setRef_info(refInfo);
            revisionData.setBase_loc(revisions.get(i).getAssignedAirportCode());

            movementResponse = new MovementResponse("taskdata", revisionData);

            ApiResponse request = sendPostEntity(movementResponse);

            String idx = revisions.get(i).getRevisionNumber().toString();
            String responseMessage = request.getMessage();

            if (responseMessage.equals("Success")) {
                success.add(idx);
                //String status = "success";
            } else {
                /**
                 * declare new to reiniziate value of restfailed
                 */
                restFailed = new RestFailed();
                restFailed.setIdx(idx);
                restFailed.setMessage(responseMessage);

                failed.add(restFailed);
            }
        }

        restResponse.setFailed(failed);
        restResponse.setSuccess(success);

        return ResponseEntity.ok(restResponse);
    }
}
