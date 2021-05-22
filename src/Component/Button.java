package Component;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Button extends JButton {

    private final int baseIndex = 0;
    private final int closeIndex = -1;
    private int value;
    private boolean isPause = false;

    public Button(boolean border, int width, int height, int value) {
        super();
        this.value = value;
        _draw(border, width, height);
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean isPause) {
        this.isPause = isPause;
    }

    public void goBack() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                setIconImage(baseIndex, getWidth(), getHeight());
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask, 200L);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void _draw(boolean border, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        if (border) {
            this.setBorder(BorderFactory.createLineBorder(Color.white, 3, false));
        }
        setIconImage(0, width, height);
    }

    public void setIconImage(int index, int width, int height) {
        Icon icon = new ImageIcon(_getIconButton(index, width, height));
        setIcon(icon);
    }

    private Image _getIconButton(int index, int width, int height) {
        String directory = "src/Icon/icon" + index + ".jpg";
        ImageIcon icon = new ImageIcon(directory);
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
