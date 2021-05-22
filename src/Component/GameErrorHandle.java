package Component;

import javax.swing.*;

public class GameErrorHandle extends JPanel {
    public GameErrorHandle(String message, String title) {
        JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);
        this.setVisible(true);
    }
}
