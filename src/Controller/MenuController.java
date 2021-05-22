package Controller;

import Component.Button;
import Component.ScoreButton;
import Config.Config;
import Model.NewGame;

import javax.swing.*;
import java.util.ArrayList;

public class MenuController {
    private final TimeThread timeThread;
    private final ArrayList<Button> buttons;
    private final JFrame frame;
    private final ScoreButton scoreButton;

    public MenuController(TimeThread timeThread, ArrayList<Button> buttons, JFrame frame, ScoreButton scoreButton) {
        this.timeThread = timeThread;
        this.buttons = buttons;
        this.frame = frame;
        this.scoreButton = scoreButton;
    }

    public void start() {
        if (!timeThread.isForceStop() && Config.time == 0) {
            timeThread.start();
        } else {
            int select = JOptionPane.showOptionDialog(null, "Trò chơi đã bắt đầu, bạn có muốn chơi mới",
                    "Chơi mới",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (select == 0) {
                timeThread.setForceStop(true);
                timeThread.setForcePause(false);
                timeThread.wake();
                new NewGame(1, 0, false, this.frame);
            }
        }
    }

    public void pause() {
        timeThread.setForcePause(true);
        for (Button button : buttons) {
            if (button.isEnabled()) {
                button.goBack();
            }
            button.setPause(true);
        }
    }

    public void resume() {
        for (Button button : buttons) {
            button.setPause(false);
        }
        timeThread.setForcePause(false);
        timeThread.wake();
    }

    public String getScore() {
        return scoreButton.getText();
    }
}
