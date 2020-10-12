package com.example.tronicles.fitnesshelper;

/**
 * Created by Andrzej on 4/25/2018.
 */

public class Utils {


    public static String formatTime(String hour, String minute, String ampm){

        StringBuilder builder = new StringBuilder();

        if(Integer.parseInt(hour) < 10){
            hour = "0" + hour;
        }

        if(Integer.parseInt(minute) < 10){
            minute = "0" + minute;
        }

        builder.append(hour).append(":").append(minute).append(ampm);

        return builder.toString();


    }



}
