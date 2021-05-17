package Model;

import java.awt.Color;
import javax.swing.*;

public class ProgressBar extends JProgressBar {
    public ProgressBar(int minTime, int maxTime) {
        super(minTime, maxTime);
        this.setValue(maxTime);
        this.setBackground(Color.decode("#0693e3"));
    }
}
