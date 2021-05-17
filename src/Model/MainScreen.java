package Model;

import Config.Config;
import Controller.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JPanel implements ActionListener {
    public MainScreen() {
        this.setLayout(new GridLayout(Config.m, Config.n));
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                Config.bt[i][j] = new JButton(String.valueOf(Config.a[i][j]));
                Config.bt[i][j].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                Config.bt[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                Config.bt[i][j].setPreferredSize(new Dimension(120, 170));
                Config.bt[i][j].setIcon(new Logic().getIcon(0));
                Config.bt[i][j].addActionListener(this);
                Config.bt[i][j].setBackground(Color.BLACK);
                this.add(Config.bt[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new MainScreen(), BorderLayout.CENTER);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(200, 300));

        jFrame.add(jPanel, BorderLayout.NORTH);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

