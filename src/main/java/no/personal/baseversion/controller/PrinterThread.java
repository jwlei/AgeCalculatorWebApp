package no.personal.baseversion.controller;

import no.personal.baseversion.Utility.ParseDateTime;

import java.time.LocalDateTime;

public class PrinterThread implements Runnable {
    // Printer

    private boolean isRunning = true;
    private String age;
    private String runningClock;


    @Override
    public void run() {
        printAge();
    }

    private void printAge() {
        System.out.println("Thread: Printer is starting");
        while (isRunning){
            synchronized (this){
                        try {
                            if (runningClock != null){
                                System.out.println("PRINTER " + runningClock);
                            }

                            if (age != null){
                                System.out.println(age);
                            }
                            wait(5000);

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

    public void setRunningClock(String s){
        this.runningClock = s;
    }

    public void setAge(String string){

        this.age = string;
    }
}
