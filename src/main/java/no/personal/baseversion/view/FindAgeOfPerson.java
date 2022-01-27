package no.personal.baseversion.view;

import no.personal.baseversion.controller.CalculateAge;
import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FindAgeOfPerson {
    public static void findPerson() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String pick;

        System.out.println("AVAILABLE PERSONS -------------------------------");
        PersonList.printNames();
        System.out.println("\nWhich person would you like to print the age of?");
        pick = scanner.nextLine();

        Person subject = new PersonList().getPerson(pick);

        if (subject != null){
            LocalDateTime x = new CalculateAge().convertTimeDateToLdt(subject.getDateOfBirth(), subject.getTimeOfBirth());
            new CalculateAge().calculateAge(x);
        } else {
            System.out.println("Person not found, returning to main menu.");
        }

        try {
            MainMenu.mainMenu();
        } catch (InterruptedException e){
            throw e;
        }
    }
}
