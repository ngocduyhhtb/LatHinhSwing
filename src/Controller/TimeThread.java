package Controller;

import Config.Config;

import java.util.concurrent.TimeUnit;

public class TimeThread extends Thread {
    private final TimeThreadController timeThreadController;
    private volatile boolean forceStop = true;

    public TimeThreadController getTimeThreadController() {
        return timeThreadController;
    }

    public boolean isForceStop() {
        return forceStop;
    }

    public void setForceStop(boolean forceStop) {
        this.forceStop = forceStop;
    }

    public TimeThread(TimeThreadController timeThreadController) {
        this.timeThreadController = timeThreadController;
    }
    public void wakeup(){
        timeThreadController.wakeup();
    }
    @Override
    public synchronized void run() {
        do {
            if (forceStop) {
                timeThreadController.hold();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Config.time++;
            System.out.println(Config.time);
        } while (Config.time != Config.maxTime);
    }
}