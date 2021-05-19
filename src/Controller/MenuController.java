package Controller;

public class MenuController {
    private final TimeThread timeThread;

    public MenuController(TimeThread timeThread) {
        this.timeThread = timeThread;
    }

    public void start()
    {
        timeThread.start();
    }
}
