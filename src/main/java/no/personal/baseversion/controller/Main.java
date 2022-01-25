package no.personal.baseversion.controller;


import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;
import no.personal.baseversion.view.MainMenu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Person> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        //Run the method addPersons to initialize and populate the list.
        PersonList.addPersons(list);

        MainMenu.mainMenu();
    }
}


