package no.personal.baseversion.controller;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public class ClockThread implements Runnable{
    private final PrinterThread printerThread;
    private CalculateAge calculateAge;
    private volatile boolean isRunning = true;
    private volatile LocalDateTime time = LocalDateTime.now();

    public ClockThread(PrinterThread printerThread) {
        this.printerThread = printerThread;
    }

    public void CalculateAge(CalculateAge calculateAge) {
        this.calculateAge = calculateAge;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void quit() {
        isRunning = false;
    }


    @Override
    public void run() {
        System.out.println("Thread: Clock thread is starting");
        while(isRunning) {
            synchronized (this) {
                try {
                    time = LocalDateTime.now();
                    // TODO: Doesnt update the time for calculateAge method
                    CalculateAge.setCurrentTimeFromThread(time);
                    printerThread.setRunningClock(time.toString());

                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        quit();
        System.out.println("Shutting down Clock ...");
    }
}
