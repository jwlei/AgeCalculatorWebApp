package no.personal.baseversion.controller;

public class RunThreads {
    //final AtomicInteger threadCounter = new AtomicInteger(2);

    public static void runThreads() throws InterruptedException {


        // Printer
        CurrentAgeOutputThread currentAgeOutPutThread = new CurrentAgeOutputThread();
        // Setting what to print
        CurrentAgeInputThread currentAgeInputThread = new CurrentAgeInputThread(currentAgeOutPutThread);

        Thread x = new Thread(currentAgeOutPutThread);
        Thread y = new Thread(currentAgeInputThread);

        x.start();
        y.start();
        y.join();





    }
}
