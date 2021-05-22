package View;

import Config.Config;
import Controller.GameController;
import Component.Button;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    private GameController gameController;
    private final ArrayList<Button> buttons;

    public GameScreen(GameController gameController, ArrayList<Button> buttons) {
        this.gameController = gameController;
        this.buttons = buttons;

        this.setLayout(new GridLayout(Config.m, Config.n));
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                Button button = new Button(false, 80, 140, Config.a[i][j]);
                button.setMargin(new Insets(0, 0, 0, 0));
                this.add(button);
                buttons.add(button);
                button.addActionListener(e -> {
                    gameController.flipCard(button);
                });
            }
        }
    }

}

