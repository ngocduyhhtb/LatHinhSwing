package Controller;

public class ThreadController extends Thread{
    public synchronized void hold() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void wake() {
        notify();
    }
}
