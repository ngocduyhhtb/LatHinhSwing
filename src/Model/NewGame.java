package Model;

import Config.Config;
import View.MainScreen;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewGame {
    public NewGame(int level, int score, boolean isContinue, JFrame frame) {
        if (isContinue) {
            if (Config.lv < 5) {
                Config.maxTime += 15;
            }
            if (Config.lv >= 5 && Config.lv < 9) {
                Config.maxTime += 25;
            }
            if (Config.lv >= 9) {
                Config.maxTime += 30;
            }
            Config.n++;
            if ((Config.m * Config.n) % 2 != 0) {
                Config.n++;
            } else if ((Config.n / Config.m) == 3) {
                Config.m++;
            }
        } else {
            Config.m = 2;
            Config.n = 3;
        }
        MainScreen mainScreen = new MainScreen(level, score);
        mainScreen.addWindowListener(new Event(frame));
    }

    static class Event implements WindowListener {
        private final JFrame frame;

        public Event(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void windowOpened(WindowEvent e) {
            frame.dispose();
        }

        @Override
        public void windowClosing(WindowEvent e) {
            frame.dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
