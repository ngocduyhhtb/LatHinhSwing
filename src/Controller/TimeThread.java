package Controller;

import Config.Config;
import Component.ProgressBar;
import View.DialogNewGame;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TimeThread extends Thread {

    private final ProgressBar progressBar = new ProgressBar(0, Config.maxTime);
    private JFrame frame;
    private volatile boolean isForceStop = false;

    public TimeThread(JFrame frame) {
        this.frame = frame;

    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setForceStop(boolean forceStop) {
        isForceStop = forceStop;
    }

    @Override
    public synchronized void run() {
        do {
            progressBar.setValue(++Config.time);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (Config.time <= Config.maxTime && !isForceStop);
        _newGame();
    }

    private void _newGame()
    {

        if (!isForceStop)
        {
            DialogNewGame dialogNewGame = new DialogNewGame("XuanBach con cua bo PhamTienHai", "1234", frame);
            dialogNewGame.newDialog(false, 1);
        }
    }
}