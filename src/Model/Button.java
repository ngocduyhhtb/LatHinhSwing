package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class Button extends JButton {

    private int baseIndex = 0;
    private int closeIndex = -1;
    private int value;
    private boolean isOpen = true;

    public Button(boolean border, int width, int height, int value) {
        super();
        this.value = value;
        _draw(baseIndex, border, width, height);
    }

    public void goBack() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                setIconImage(baseIndex, getWidth(), getHeight());
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask, 1000L);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void _draw(int index, boolean border, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        if (border) {
            this.setBorder(BorderFactory.createLineBorder(Color.white, 3, false));
        }
        setIconImage(index, width, height);
    }

    public void setIconImage(int index, int width, int height) {
        Icon icon = new ImageIcon(_getIconButton(index, width, height));
        setIcon(icon);
    }

    private Image _getIconButton(int index, int width, int height) {
        String directory = "src/Icon/icon" + index + ".jpg";
        Image img = null;

        try {
            img = ImageIO.read(new File(directory));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert img != null;
        img = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        return img;
    }
}
