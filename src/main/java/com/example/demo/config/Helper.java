package com.example.demo.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Helper {
    //private String startDate = "2019-03-15 02:00:00";
    //private String endDate = "2019-03-15 09:00:00";

    private String startDate;
    private String endDate;
    private String localTimeStart;
    private String localTimeEnd;

    private static final long ONE_MINUTE_IN_MILLIS = 60000;

    private void constructorLocalTime() {
        Calendar date = Calendar.getInstance();
        Long t = date.getTimeInMillis();
        Date minus5Minutes = new Date(t - (5 * ONE_MINUTE_IN_MILLIS));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        setLocalTimeStart(dateFormat.format(minus5Minutes));
        setLocalTimeEnd(dateFormat.format(t));

        /**
         * for test data purpose
         */
        //setLocalTimeStart("2019-04-26 01:04:52");
        //setLocalTimeEnd("2019-04-26 01:10:54");
    }

    public Helper() {
        Calendar date = Calendar.getInstance();
        Long t = date.getTimeInMillis();
        Date minus5Minutes = new Date(t - (5 * ONE_MINUTE_IN_MILLIS));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        setStartDate(dateFormat.format(minus5Minutes));
        setEndDate(dateFormat.format(t));

        /**
         * set local time
         */

        constructorLocalTime();
    }

    public String removeSpace(String param) {
        return param.replaceAll("\\s+","");
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocalTimeStart() {
        return localTimeStart;
    }

    public void setLocalTimeStart(String localTimeStart) {
        this.localTimeStart = localTimeStart;
    }

    public String getLocalTimeEnd() {
        return localTimeEnd;
    }

    public void setLocalTimeEnd(String localTimeEnd) {
        this.localTimeEnd = localTimeEnd;
    }

    /**
     * change utc to local time
     */

    public String setLocalTime(String utcTime) throws ParseException {
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date =  utcFormat.parse(utcTime);

        DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        pstFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        return pstFormat.format(date);
    }
}
