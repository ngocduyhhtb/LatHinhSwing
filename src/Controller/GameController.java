package Controller;

import Component.Button;
import Component.ScoreButton;
import View.DialogNewGame;
import Config.Config;

import javax.swing.*;
import java.util.ArrayList;

public class GameController {
    private final DialogNewGame dialogNewGame;
    private final ScoreButton scoreButton;
    private final TimeThread timeThread;
    private final ArrayList<Button> openButtons;
    int totalButtons;
    int[] state = new int[2];
    int count = 0;

    public GameController(ArrayList<Button> openButtons, JFrame frame, TimeThread timeThread, ScoreButton scoreButton) {
        this.timeThread = timeThread;
        this.scoreButton = scoreButton;
        this.dialogNewGame = new DialogNewGame("Chubedan con cua bo PhamTienHai", "1234", frame);
        this.openButtons = openButtons;

        totalButtons = Config.n * Config.m;
    }

    public void flipCard(Button button) {
        if (Config.time > 30) {
            return;
        }
        if (Config.time == 0) {
            timeThread.start();
        }
        button.setIconImage(button.getValue(), button.getWidth(), button.getHeight());
        if (openButtons.size() != 0 && openButtons.get(0) == button) {
            return;
        }
        state[count++] = button.getValue();
        openButtons.add(button);
        if (count == 2) {
            if (state[0] == state[1]) {
                for (Button bt : openButtons) {
                    bt.setEnabled(false);
                }
                scoreButton.setText(String.valueOf(Integer.parseInt(scoreButton.getText()) + 100));
                totalButtons -= 2;
            } else {
                for (Button bt : openButtons) {
                    bt.goBack();
                }
            }
            count = 0;
            openButtons.clear();
        }
        if (totalButtons == 0) {
            timeThread.setForceStop(true);
            dialogNewGame.newDialog(true, ++Config.lv);
        }
    }
}
