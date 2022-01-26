package no.personal.baseversion.controller;

import no.personal.baseversion.model.PersonList;
import no.personal.baseversion.view.MainMenu;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Run the method addPersons to initialize and populate the list.
        PersonList.addPersons();
        MainMenu.mainMenu();
    }
}


