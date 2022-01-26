package no.personal.baseversion.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calendar {
    public static LocalDate currentDate(){
        LocalDate currentDate = LocalDate.now();

        return currentDate;
    }

    public LocalDate parseDate(String s) {
        DateTimeFormatter parseCalendar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  LocalDate.parse(s, parseCalendar);
    }
}
