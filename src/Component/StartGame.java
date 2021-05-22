package Component;

import Controller.DatabaseController;
import Model.NewGame;
import View.HallOfFame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StartGame extends JFrame {
    public StartGame() {
        JFrame frame = this;
        this.setTitle("Valorant V2");
        this.setLayout(new FlowLayout());
        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> new NewGame(1, 0, false, frame));
        JButton playerHistory = new JButton("History");
        playerHistory.addActionListener(new ActionListener() {
            DatabaseController databaseController;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    databaseController = new DatabaseController();
                    System.out.println("DB connected");
                    HallOfFame hallOfFame = databaseController.getHistory();
                    hallOfFame.display();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        databaseController.closeConnection();
                        System.out.println("DB disconnected");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        StartGameMenu startGameMenu = new StartGameMenu();
        startGameMenu.add(startGameButton);
        startGameMenu.add(playerHistory);
        startGameButton.setMaximumSize(new Dimension(300, 30));
        startGameButton.setMargin(new Insets(10, 10, 10, 10));
        playerHistory.setMaximumSize(new Dimension(300, 30));
        JLabel gameImage = new JLabel();
        gameImage.setIcon(setIconImage(600, 300));
        this.add(gameImage);
        this.add(startGameMenu);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new StartGame();
    }

    public Icon setIconImage(int width, int height) {
        return new ImageIcon(_getIconButton(width, height));
    }

    private Image _getIconButton(int width, int height) {
        String directory = "src/Icon/logo.jpg";
        ImageIcon icon = new ImageIcon(directory);
        Image img = null;
        img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return img;
    }
}

