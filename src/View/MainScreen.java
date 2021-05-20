package View;

import Controller.GameController;
import Controller.MainController;
import Controller.MenuController;
import Controller.TimeThread;
import Component.*;
import Component.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        ArrayList<Button> buttons = new ArrayList<>();
        ArrayList<Button> openButtons = new ArrayList<>();

        MenuController menuController = new MenuController(timeThread, buttons, this);
        MenuScreen menuScreen = new MenuScreen(menuController, scoreButton, timeThread.getProgressBar(), startGame);

        GameController gameController = new GameController(openButtons, buttons, this, timeThread, scoreButton);
        GameScreen gameScreen = new GameScreen(gameController, buttons);

        this.add(gameScreen, BorderLayout.CENTER);
        this.add(menuScreen, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
    }
}

