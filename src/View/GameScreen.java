package View;

import Config.Config;
import Controller.GameController;
import Controller.TimeThread;
import Component.Button;
import Component.ScoreButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    private GameController gameController;
    ArrayList<Button> openButtons = new ArrayList<>();


    public GameScreen(JFrame frame, TimeThread timeThread, ScoreButton scoreButton) {
        gameController = new GameController(openButtons, frame, timeThread, scoreButton);

        this.setLayout(new GridLayout(Config.m, Config.n));
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                Button button = new Button(false, 80, 100, Config.a[i][j]);
                button.setMargin(new Insets(0, 0, 0, 0));
                this.add(button);
                button.addActionListener(e -> {
                    gameController.flipCard(button);
                });
            }
        }
    }

}

