package no.personal.baseversion.controller;

import java.util.Scanner;

public class CurrentAgeThread implements Runnable {
    //Input



    private PrinterThread printerThread;
    private String input;

    public CurrentAgeThread(PrinterThread printerThread) {
        this.printerThread = printerThread;
    }


        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            while ((input = scanner.nextLine()) != null
                    && !input.equalsIgnoreCase("quit")) {


//                String a = new CalculateAge().printAge(input);
//                printerThread.setAge(a);

                printerThread.setAge(new CalculateAge().printAge(input));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Shutting down ...");
            printerThread.quit();
        }
}