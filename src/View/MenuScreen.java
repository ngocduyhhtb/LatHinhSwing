package View;

import Component.ProgressBar;
import Component.ScoreButton;
import Config.Config;
import Controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JPanel {
    private final MenuController menuController;
    private final ScoreButton scoreButton;
    private final ProgressBar progressBar;
    private final JButton startGameButton;
    private final JButton level;
    private final JButton controlButton;

    public MenuScreen(MenuController menuController, ScoreButton scoreButton, ProgressBar progressBar, JButton startGameButton) {
        this.menuController = menuController;
        this.scoreButton = scoreButton;
        this.progressBar = progressBar;
        this.startGameButton = startGameButton;

        level = new JButton(String.valueOf(Config.lv));
        controlButton = new JButton("Pause");

        _initGUI();
        _addEvent();
    }

    private void _initGUI() {
        scoreButton.setPreferredSize(new Dimension(70, 30));
        this.add(scoreButton);
        this.add(progressBar);
        this.add(startGameButton);
        this.add(controlButton);
        this.add(level);
    }

    private void _addEvent() {
        startGameButton.addActionListener(e -> {
            menuController.start();
        });

        controlButton.addActionListener(e -> {
            if (controlButton.getText().equals("Pause")) {
                menuController.pause();
                controlButton.setText("Resume");
            } else {
                menuController.resume();
                controlButton.setText("Pause");
            }
        });
    }
}
