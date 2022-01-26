package no.personal.baseversion.controller;

import no.personal.baseversion.model.Person;
import no.personal.baseversion.model.PersonList;

import java.util.Scanner;



public class CurrentAgeInputThread implements Runnable {
    //Input
    private final CurrentAgeOutputThread currentAgeOutPutThread;
    private static volatile Person subject;
    private static volatile String input;
    private static volatile String output;

    public Person FindSubject(String input){
        subject = PersonList.getPerson(input);
        return subject;
    }

    public String UpdateSubjectAge (Person subject){
        output = CalculateAge.calculateAge(subject.getDateOfBirth(), subject.getTimeOfBirth());
        return output;
    }

    // TODO: Maybe delete.
    public String printAge(String s){
       String o = UpdateSubjectAge(FindSubject(s));
       return o;
    }


    public CurrentAgeInputThread(CurrentAgeOutputThread currentAgeOutPutThread) {
        this.currentAgeOutPutThread = currentAgeOutPutThread;
    }
    // TODO: Fix method not updating the object
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while ((input = scanner.nextLine()) != null
            && !input.equalsIgnoreCase("quit")) {

//            FindSubject(input);
//            UpdateSubjectAge(subject);

//            currentAgeOutPutThread.setAge(output);
              currentAgeOutPutThread.setAge(printAge(input));

        }
        System.out.println("Shutting down ...");
        currentAgeOutPutThread.quit();
    }
}
