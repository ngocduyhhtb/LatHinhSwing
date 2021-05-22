package View;

import Component.SaveGame;
import Controller.MenuController;
import Model.NewGame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DialogNewGame extends JOptionPane {
    private final String message, title;
    private final JFrame frame;
    private final MenuController menuController;
    public DialogNewGame(String message, String title, JFrame frame, MenuController menuController) {
        this.message = message;
        this.title = title;
        this.frame = frame;
        this.menuController = menuController;
    }

    public void newDialog(boolean isContinue, int level, int score) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (select == 0) {
            new NewGame(level, score, isContinue, frame);
        } else {
            System.exit(0);
        }
    }
    public void timeOut(boolean isContinue, int level, int score){
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (select == 0) {
            SaveGame saveGame = new SaveGame(menuController, true);
            saveGame.addWindowListener(new Event());
        } else {
            SaveGame saveGame = new SaveGame(menuController, false);
            saveGame.addWindowListener(new Event());
        }
    }

    class Event implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            frame.dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            frame.dispose();
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
