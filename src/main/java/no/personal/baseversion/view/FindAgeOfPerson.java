package no.personal.baseversion.view;

import no.personal.baseversion.controller.CalculateAge;
import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;

import java.util.Scanner;

public class FindAgeOfPerson {
    public static void findPerson(){
        Scanner scanner = new Scanner(System.in);
        String pick;

        System.out.println("AVAILABLE PERSONS -------------------------------");
        PersonList.printNames();
        System.out.println("\nWhich person would you like to print the age of?");
        pick = scanner.nextLine();

        Person subject = PersonList.getPerson(pick);

        if (subject != null){
            CalculateAge.calculateAge(subject.getDateOfBirth(), subject.getTimeOfBirth());
        } else {
            System.out.println("Person not found, returning to main menu.");
        }

        MainMenu.mainMenu();
    }
}
