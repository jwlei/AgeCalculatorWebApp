package no.personal.baseversion.controller;

import no.personal.baseversion.model.Person;

public class CurrentAgeOutputThread implements Runnable {
    // Printer

    private boolean isRunning = true;
    private String string;


    @Override
    public void run() {
        printAge();
//        new CurrentAgeOutputThread().printAges();

    }

    private void printAge() {
        while (isRunning){
            synchronized (this){
                        try {

                            System.out.println(string);
                            wait(3000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
        }
        System.out.println("Threads has been shut down.");
    }

    public synchronized void quit() {
        isRunning = false;
        notify();
    }

    public void setAge(String string){

        this.string = string;
    }
}
