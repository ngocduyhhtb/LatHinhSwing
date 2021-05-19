package View;

import Controller.MainController;
import Controller.MenuController;
import Controller.TimeThread;
import Component.*;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {
    private TimeThread timeThread;
    private final MainController mainController;

    public MainScreen(int k, int score) {
        setTitle("Game Lat Hinh");
        this.mainController = new MainController();
        this.timeThread = new TimeThread(this);
        init(k, score);
    }

    public void init(int k, int score) {
        mainController.setUp(k);
        ScoreButton scoreButton = new ScoreButton(score);
        JButton startGame = new JButton("Start Game");

        MenuController menuController = new MenuController(timeThread);
        MenuScreen menuScreen = new MenuScreen(menuController, scoreButton, timeThread.getProgressBar(), startGame);

        this.add(new GameScreen(this, timeThread, scoreButton), BorderLayout.CENTER);
        this.add(menuScreen, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
    }
}

