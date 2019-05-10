package com.example.demo.repository;

import com.example.demo.model.AircraftMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftMovementRepository extends JpaRepository<AircraftMovement, Long> {
    String queryOnlyone = "SELECT A.COL_IDX, " +
            "A.COL_CARRIER_CODE, A.COL_FLIGHT_NUMBER, " +
            "A.COL_PLAN_DEPARTURE_DATE, A.COL_AIRCRAFT_REGISTRATION," +
            "A.COL_DEPARTURE_STATION, A.COL_ARR_STATION," +
            "A.COL_EST_DEP_DATE, A.COL_EST_DEP_TIME," +
            "A.COL_CHOX_OFF_DATE, A.COL_CHOX_OFF_TIME," +
            "A.COL_CHOX_ON_DATE, A.COL_CHOX_ON_TIME," +
            "A.COL_FLIGHT_TYPE " +
            "FROM TBL_AC_MOVEMENT_PROD1 A " +
            "JOIN " +
            "(SELECT " +
            "COL_CARRIER_CODE, COL_FLIGHT_NUMBER, COL_DEPARTURE_NUMBER, COL_PLAN_DEPARTURE_DATE, COL_DEPARTURE_STATION, COL_ARR_STATION, MAX(COL_IDX) AS max_idx " +
            "FROM TBL_AC_MOVEMENT_PROD1 " +
            "GROUP BY COL_CARRIER_CODE, COL_FLIGHT_NUMBER, COL_DEPARTURE_NUMBER, COL_PLAN_DEPARTURE_DATE, COL_DEPARTURE_STATION, COL_ARR_STATION" +
            ") B " +
            "ON " +
            "A.COL_CARRIER_CODE = B.COL_CARRIER_CODE AND A.COL_FLIGHT_NUMBER = B.COL_FLIGHT_NUMBER AND " +
            "A.COL_DEPARTURE_NUMBER = B.COL_DEPARTURE_NUMBER AND " +
            "A.COL_PLAN_DEPARTURE_DATE = B.COL_PLAN_DEPARTURE_DATE AND " +
            "A.COL_DEPARTURE_STATION = B.COL_DEPARTURE_STATION AND A.COL_ARR_STATION = B.COL_ARR_STATION AND A.COL_IDX = B.max_idx " +
            "WHERE " +
            "A.TIMESTAMP BETWEEN ?1 AND ?2 AND " +
            "(A.COL_DEPARTURE_STATION = 'CGK' OR A.COL_ARR_STATION = 'CGK')";

    @Query(value = queryOnlyone, nativeQuery = true)
    List<AircraftMovement> getAllCgkMovement(String start, String end);

}
