package View;

import Controller.MenuController;
import Model.NewGame;

import javax.swing.*;

public class DialogNewGame extends JOptionPane {
    private final String message, title;
    private final JFrame frame;

    public DialogNewGame(String message, String title, JFrame frame) {
        this.message = message;
        this.title = title;
        this.frame = frame;
    }

    public void newDialog(boolean isContinue, int k, int score) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (select == 0) {
            new NewGame(k, score, isContinue, frame);
        } else {
            System.exit(0);
        }
    }
}
