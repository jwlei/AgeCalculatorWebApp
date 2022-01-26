package no.personal.baseversion.controller;

import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;

import java.time.LocalDateTime;
import java.util.Scanner;



public class currentAgeInputThread implements Runnable {
    //Input
    private final CurrentAgeOutputThread currentAgeOutPutThread;
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
       String o = updateSubjectAge(findSubject(s));
       return o;
    }


    public currentAgeInputThread(CurrentAgeOutputThread currentAgeOutPutThread) {
        this.currentAgeOutPutThread = currentAgeOutPutThread;
    }
    // TODO: Fix method not updating the object
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while ((input = scanner.nextLine()) != null
            && !input.equalsIgnoreCase("quit")) {

            //currentAgeOutPutThread.setAge(printAge(updateSubjectAge(findSubject(input))));


            currentAgeOutPutThread.setAge(printAge(input));

        }
        System.out.println("Shutting down ...");
        currentAgeOutPutThread.quit();
    }
}
