package no.personal.baseversion.controller;

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
                            // TODO Fix threading

                            wait(5000);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                        }

                        if (runningClock != null){
                            System.out.println("PRINTER " + runningClock);
                        }

                        if (age != null){
                            System.out.println(age);
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
