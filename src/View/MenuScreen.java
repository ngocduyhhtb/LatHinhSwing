package View;

import Component.ProgressBar;
import Component.ScoreButton;
import Config.Config;
import Controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JPanel{
    private final MenuController menuController;
    private final ScoreButton scoreButton;
    private final ProgressBar progressBar;
    private final JButton startGame;

    public MenuScreen(MenuController menuController, ScoreButton scoreButton, ProgressBar progressBar, JButton startGame) {
        this.menuController = menuController;
        this.scoreButton = scoreButton;
        this.progressBar = progressBar;
        this.startGame = startGame;
        _initGUI();
        _addEvent();
    }

    private void _initGUI() {
        scoreButton.setPreferredSize(new Dimension(70, 30));
        this.add(scoreButton);
        this.add(progressBar);
        this.add(startGame);
        this.add(new JButton(String.valueOf(Config.lv)));
    }

    private void _addEvent()
    {
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.start();
            }
        });
    }
}
