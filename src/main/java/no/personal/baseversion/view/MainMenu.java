package no.personal.baseversion.view;

import no.personal.baseversion.controller.RunThreads;
import no.personal.baseversion.model.PersonList;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n MAIN MENU ----------------------------------------------------");
        System.out.println("1. Print the available list of persons to calculate the age on");
        System.out.println("2. Find age of someone in the list.");
        System.out.println("3. Add yourself to the list.");
        System.out.println("4. Get a continously updating age of a person.");
        System.out.println("5. Exit");
        System.out.println("\n Input number for the desired choice.");
        System.out.println("--------------------------------------------------------------");

        int pick = scanner.nextInt();

        switch (pick) {
            case 1: // Print the list
                System.out.println("Printing the list");;
                PersonList.printList();
                MainMenu.mainMenu();
                break;

            case 2: // Choose someone to find the age of
                FindAgeOfPerson.findPerson();
                break;

            case 3: // Add a new person to the list
                AddPerson.addPerson();
                break;

            case 4: // Continously update age
                System.out.println("Write the name of the person you want to\ncontinously update the age of:");
                PersonList.printNames();
                RunThreads.runThreads();




                break;

            case 5: // Exit the program
                System.out.println("Exiting program.");
                scanner.close();
                break;

            default:
                System.out.println("Something went wrong, try again.");
                MainMenu.mainMenu();
        }
    }
}
