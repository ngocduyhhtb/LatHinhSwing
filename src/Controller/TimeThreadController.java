package Controller;

public class TimeThreadController extends Thread{
    public synchronized void hold() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public synchronized void wakeup() {
        notify();
    }
}
