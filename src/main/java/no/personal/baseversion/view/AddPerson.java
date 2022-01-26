package no.personal.baseversion.view;

import no.personal.baseversion.model.PersonList;

import java.util.Scanner;

public class AddPerson {
    public static void addPerson(){
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String birthDate;
        String birthTime = null;

        System.out.println("We are now going to add you as a new person in the list.");
        System.out.println("\nPlease enter your first name:");
        firstName = scanner.nextLine();

        System.out.println("\nPlease enter your lastname:");
        lastName = scanner.nextLine();

        System.out.println("\nPlease enter your birth date\n Format: dd-mm-yyyy");
        birthDate = scanner.nextLine();


        System.out.println("\nDo you know the time of birth on the day? yes/no");
        String knows = scanner.nextLine().toLowerCase();
        boolean bool = false;

        if (knows.equals("yes")){
            bool = true;
        }

        if (bool == true){
            System.out.println("Please enter your time of birth\n HH:MM:SS");
            birthTime = scanner.nextLine();
        }

        PersonList.addToList(firstName, lastName, birthDate, birthTime);

        MainMenu.mainMenu();
    }
}
