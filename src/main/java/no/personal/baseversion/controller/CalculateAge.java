package no.personal.baseversion.controller;

import no.personal.baseversion.model.Calendar;
import no.personal.baseversion.model.Clock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CalculateAge {

    public static String calculateAge(String s, String t) {
        // Get present LocalDateTime
        LocalDateTime present = LocalDateTime.now();
        LocalDateTime age = null;

        // Parse date and time
        LocalDate a = new Calendar().parseDate(s);
        LocalTime b = null;

        if (t != null) {
            b = new Clock().parseTime(t);
        } else {
            b = LocalTime.now();
        }

        // Convert to LocalDateTime
        age = a.atTime(b);

        // Calculate duration from past localDateTime to PresentLocalDateTime
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
                if (t == null) ageString.append("and ");
                if (days > 0) ageString.append(days + " days ");

                // If LocalTime exists for the person
                if (t != null) {
                    if (hours > 0) ageString.append(hours + " hours ");
                    if (minutes > 0) ageString.append(minutes + " minutes ");
                    ageString.append("and ");
                    if (seconds > 0) ageString.append(seconds + " seconds ");
                }
                ageString.append("old.");

            // return age to String
            System.out.println(ageString);
            return ageString.toString();
        }
    }
