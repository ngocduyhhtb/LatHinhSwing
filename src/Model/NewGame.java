package Model;

import Config.Config;
import Controller.MenuController;
import View.MainScreen;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewGame {
    public NewGame(int k, int score, boolean isContinue, JFrame frame) {
        if (isContinue) {
            if (Config.m < Config.n) {
                Config.m++;
                if ((Config.m * Config.n) % 2 != 0) {
                    Config.m++;
                }
            } else {
                Config.n++;
            }
        }else {
            Config.m = 2;
            Config.n = 3;
        }
        MainScreen mainScreen = new MainScreen(k, score);
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
