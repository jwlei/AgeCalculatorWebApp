package no.personal.baseversion.controller;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public class ClockThread implements Runnable{
    private PrinterThread printerThread;
    private volatile boolean isRunning = true;
    private volatile LocalDateTime time;

    public ClockThread(PrinterThread printerThread) {
        this.printerThread = printerThread;
    }


    public void currentTime() {
        time = LocalDateTime.now();
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
                    printerThread.setRunningClock(time.toString());
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        quit();
        System.out.println("Shutting down Clock ...");
    }
}
