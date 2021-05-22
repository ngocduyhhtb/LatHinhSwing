package Component;

import Controller.DatabaseController;
import Controller.GameController;
import Controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import Config.*;

public class SaveGame extends JFrame {
    private final JButton saveButton;
    private final MenuController menuController;
    private final JTextField userTextField;

    public SaveGame(MenuController menuController) {
        this.menuController = menuController;
        JPanel saveGamePanel = new JPanel();
        saveGamePanel.setLayout(new FlowLayout());
        JLabel userLabel = new JLabel("Player name: ");
        userTextField = new JTextField("Enter player name..");
        saveButton = new JButton("Save");
        saveGamePanel.add(userLabel);
        saveGamePanel.add(userTextField);
        saveGamePanel.add(saveButton);
        AddEvent();
        this.add(saveGamePanel);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public void AddEvent() {
        saveButton.addActionListener(new ActionListener() {
            DatabaseController databaseController;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    databaseController = new DatabaseController();
                    System.out.println("Database connected");
                    String score = menuController.getScore();
                    String userName = userTextField.getText();
                    databaseController.SaveGame(userName, score, Config.lv);
                    System.out.println("Game saved");
                    close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        userTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    private void close() {
        this.dispose();
    }
}
