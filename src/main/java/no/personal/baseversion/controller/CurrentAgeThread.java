package no.personal.baseversion.controller;

import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class CurrentAgeThread implements Runnable {
    //Input
    private PrinterThread printerThread;
    private Person subject;
    private String input;


    // Find the person to calculate age from
    public Person findSubject(String input){
        subject = new PersonList().getPerson(input);
        return subject;
    }


    public String updateSubjectAge(Person subject){
        LocalDateTime x = new CalculateAge().convertTimeDateToLdt(subject.getDateOfBirth(), subject.getTimeOfBirth());
        String output = new CalculateAge().calculateAge(x);
        return output;
    }

    // TODO: Maybe delete.
    public String printAge(String s){
       return updateSubjectAge(findSubject(s));
    }


    public CurrentAgeThread(PrinterThread printerThread) {
        this.printerThread = printerThread;
    }


    // TODO: Fix method not updating the object
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while ((input = scanner.nextLine()) != null
            && !input.equalsIgnoreCase("quit")) {

            try {
                printerThread.setAge(printAge(input));
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Shutting down ...");
        printerThread.quit();
    }
}
