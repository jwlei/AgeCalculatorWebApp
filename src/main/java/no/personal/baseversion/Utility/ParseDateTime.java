package no.personal.baseversion.Utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ParseDateTime {

    public LocalDate parseDate(String s) {
        DateTimeFormatter parseCalendar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  LocalDate.parse(s, parseCalendar);
    }

    public LocalTime parseTime(String s){
        DateTimeFormatter parseClock = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(s, parseClock);
    }
}
