package Component;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
public class ScoreButton extends JButton {
    public ScoreButton(int score){
        super();
        this.setText(String.valueOf(score));
        this.setBackground(Color.decode("#db3e00"));
        this.setFont(new Font("Arial", Font.PLAIN, 20));
    }
}
