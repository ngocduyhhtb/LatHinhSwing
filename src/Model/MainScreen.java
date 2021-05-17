package Model;

import Config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainScreen extends JPanel implements ActionListener {
    ArrayList<Button> buttons = new ArrayList<>();
    int[] state = new int[2];
    int count = 0;

    public MainScreen() {
        Timer timer;
        this.setLayout(new GridLayout(Config.m, Config.n));
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                Button button = new Button(false, 110, 150, Config.a[i][j]);
                this.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setIconImage(button.getValue(), button.getWidth(), button.getHeight());
                        if (buttons.size() != 0 && buttons.get(0) == button) {
                            return;
                        }
                        state[count++] = button.getValue();
                        buttons.add(button);
                        if (count == 2) {
                            if (state[0] == state[1]) {
                                for (Button bt : buttons) {
                                    bt.setEnabled(false);
                                }
                            } else {
                                for (Button bt : buttons) {
                                    bt.goBack();
                                }
                            }
                            count = 0;
                            buttons.clear();
                        }
                    }
                });
            }
        }
    }

    //    ChuBEDan con cua PhamTienHai
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

