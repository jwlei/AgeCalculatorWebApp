package no.personal.baseversion.controller;

import no.personal.baseversion.model.Person;

public class CurrentAgeOutputThread implements Runnable {
    // Printer

    private boolean isRunning = true;
    private String string;


    @Override
    public void run() {
        printAge();
    }

    private void printAge() {
        while (isRunning){
            System.out.println(string);
            synchronized (this){
                try {
                    wait(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Exitted");
    }

    public synchronized void quit() {
        isRunning = false;
        notify();
    }

    public void setAge(String string){
        this.string = string;
    }
}
