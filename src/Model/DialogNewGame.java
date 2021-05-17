package Model;

import javax.swing.*;

public class DialogNewGame extends JOptionPane {
    public DialogNewGame(String message, String title) {
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (select == 0) {
            new NewGame(0, 100);
        } else {
            System.exit(0);
        }
    }
}
