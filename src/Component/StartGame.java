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
        this.setTitle("Game Lat Hinh");
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
                } catch (SQLException | ClassNotFoundException throwables) {
                    new GameErrorHandle("Cannot get game history!", "Server error");
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
        playerHistory.setMaximumSize(new Dimension(300, 30));
        JLabel gameImage = new JLabel();
        gameImage.setIcon(setIconImage(600, 300));
        this.add(gameImage);
        this.add(startGameMenu);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        int posX = (width - 1000) / 2;
        int posY = (height - 600) / 2;
        setLocation(posX, posY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }


    public Icon setIconImage(int width, int height) {
        return new ImageIcon(_getIconButton(width, height));
    }

    private Image _getIconButton(int width, int height) {
        String directory = "src/Icon/logo.jpg";
        ImageIcon icon = new ImageIcon(directory);
        return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}

