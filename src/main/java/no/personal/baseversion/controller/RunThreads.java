package no.personal.baseversion.controller;

public class RunThreads {
    //final AtomicInteger threadCounter = new AtomicInteger(2);

    public static void runThreads() {


        // Printer
        CurrentAgeOutputThread currentAgeOutPutThread = new CurrentAgeOutputThread();
        // Dialog
        CurrentAgeInputThread currentAgeInputThread = new CurrentAgeInputThread(currentAgeOutPutThread);

        new Thread(currentAgeOutPutThread).start();
        new Thread(currentAgeInputThread).start();
    }
}
