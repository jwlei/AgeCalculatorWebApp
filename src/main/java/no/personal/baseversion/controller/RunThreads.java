package no.personal.baseversion.controller;

public class RunThreads {
    //final AtomicInteger threadCounter = new AtomicInteger(2);

    public static void runThreads() throws InterruptedException {


        // Printer
        PrinterThread printerThread = new PrinterThread();
        // Setting what to print
        CurrentAgeThread currentAgeThread = new CurrentAgeThread(printerThread);
        // Starting a ticking clock
        ClockThread clock = new ClockThread(printerThread);


        Thread x = new Thread(printerThread);
        Thread y = new Thread(currentAgeThread);
        Thread z = new Thread(clock);

        x.start();
        y.start();
        z.start();






    }
}
