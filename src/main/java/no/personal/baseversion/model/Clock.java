package no.personal.baseversion.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static LocalTime currentTime(){
        LocalTime currentTime = LocalTime.now();

        return currentTime;
    }

    public LocalTime parseTime(String s){
        DateTimeFormatter parseClock = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(s, parseClock);
    }
}