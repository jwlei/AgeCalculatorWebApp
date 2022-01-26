package no.personal.baseversion.controller;

import no.personal.baseversion.Utility.ParseDateTime;


import java.time.*;
import java.time.temporal.ChronoUnit;


public class CalculateAge {
    private static boolean bte = false;

    public LocalDateTime getCurrentTime() {
        Clock systemClock = Clock.systemDefaultZone();
        Instant instant = systemClock.instant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static boolean isBte() {
        return bte;
    }

    public static void setBte(boolean bte) {
        CalculateAge.bte = bte;
    }

    public LocalDateTime convertTimeDateToLdt(String s, String t) {
        LocalDateTime age = null;

        // Parse date and time
        LocalDate a = new ParseDateTime().parseDate(s);
        LocalTime b;

        if (t != null) {
            setBte(true);
            b = new ParseDateTime().parseTime(t);
        } else {
            b = LocalTime.now();
        }

        // Convert to LocalDateTime
        age = a.atTime(b);

        return age;
    }


    public String calculateAge(LocalDateTime age){
        // Calculate duration from past localDateTime to PresentLocalDateTime
        LocalDateTime present = new CalculateAge().getCurrentTime();

        long years = age.until(present, ChronoUnit.YEARS);
        age = age.plusYears(years);

        long months = age.until(present, ChronoUnit.MONTHS);
        age = age.plusMonths(months);

        long days = age.until(present, ChronoUnit.DAYS);
        age = age.plusDays(days);

        long hours = age.until(present, ChronoUnit.HOURS);
        age = age.plusHours(hours);

        long minutes = age.until(present, ChronoUnit.MINUTES);
        age = age.plusMinutes(minutes);

        long seconds = age.until(present, ChronoUnit.SECONDS);


        //Building the return string
        StringBuilder ageString = new StringBuilder();

        if (years > 0) ageString.append(years + " years ");
        if (months > 0) ageString.append(months + " months ");
        // If LocalTime is empty, append an "and" here
        if (!bte) ageString.append("and ");
        if (days > 0) ageString.append(days + " days ");

        // If LocalTime exists for the person

        if (bte) {
            if (hours > 0) ageString.append(hours + " hours ");
            if (minutes > 0) ageString.append(minutes + " minutes ");
            ageString.append("and ");
            if (seconds > 0) ageString.append(seconds + " seconds ");
            setBte(false);
        }
        ageString.append("old.");

        // return age to String
        System.out.println(ageString);
        return ageString.toString();
    }
}
