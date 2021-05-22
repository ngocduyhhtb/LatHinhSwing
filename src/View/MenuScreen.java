package View;

import Component.ProgressBar;
import Component.ScoreButton;
import Component.*;
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
    private final JButton saveGameButton;
    private final JButton menuButton;
    private final MainScreen mainScreen;
    public MenuScreen(MenuController menuController, ScoreButton scoreButton, ProgressBar progressBar, JButton startGameButton, JButton saveGameButton, JButton menuButton, MainScreen mainScreen) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.menuController = menuController;
        this.scoreButton = scoreButton;
        this.progressBar = progressBar;
        this.startGameButton = startGameButton;
        this.saveGameButton = saveGameButton;
        this.menuButton = menuButton;
        this.mainScreen = mainScreen;
        level = new JButton(String.valueOf(Config.lv));
        controlButton = new JButton("Pause");
        _initGUI();
        _addEvent();
    }

    private void _initGUI() {
        JPanel jPanelScoreLevel = new JPanel();
        jPanelScoreLevel.setLayout(new FlowLayout());
        jPanelScoreLevel.add(scoreButton);
        jPanelScoreLevel.add(level);
        this.add(genarateProgress(progressBar));
        this.add(jPanelScoreLevel);
        this.add(genarateButton(startGameButton));
        this.add(genarateButton(controlButton));
        this.add(genarateButton(saveGameButton));
        this.add(genarateButton(menuButton));
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
        saveGameButton.addActionListener(e -> {
            new SaveGame(menuController, false);
        });
        menuButton.addActionListener(e -> {
            new StartGame();
            mainScreen.dispose();
        });
    }

    private JPanel genarateButton(JButton button) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        button.setPreferredSize(new Dimension(140, 30));
        jPanel.add(button);
        return jPanel;
    }

    private JPanel genarateProgress(JProgressBar jProgressBar) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jProgressBar);
        return jPanel;
    }
}
