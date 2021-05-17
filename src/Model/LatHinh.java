package Model;

import Config.Config;
import Controller.Logic;
import Controller.TimeThread;
import Controller.TimeThreadController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LatHinh extends JFrame {
    private int level = 0, hit = 0, h;
    private JFrame cnt;
    private Timer timer1, timer2;
    private int m, n;
    private TimeThread timeThread;
    private TimeThreadController timeThreadController;
    public LatHinh(int k, int score) {
        timeThreadController = new TimeThreadController();
        timeThread = new TimeThread(timeThreadController);
        timeThread.start();
        setTitle("Game Lat Hinh");
        this.setLevel(k);
        cnt = init(k, score);
        timer1 = new Timer(400, e -> timer1.stop());
        timer2 = new Timer(100, e -> {
            System.out.println("Started");
//            Config.time++;
//            progressBar.setValue(Config.maxTime - Config.time);
//            if (Config.maxTime == Config.time) {
//                timer2.stop();
//                new DialogNewGame("Hết thời gian.\n" +
//                        "Điểm: " + scoreButton.getText() + "\n" +
//                        "Bạn có muốn chơi lại không?", "Thông báo");
//            }
        });
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Container getCnt() {
        return cnt;
    }

    public void setCnt(JFrame cnt) {
        this.cnt = cnt;
    }

    public Timer getTimer1() {
        return timer1;
    }

    public void setTimer1(Timer timer1) {
        this.timer1 = timer1;
    }

    public Timer getTimer2() {
        return timer2;
    }

    public void setTimer2(Timer timer2) {
        this.timer2 = timer2;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }


    public JFrame init(int k, int score) {
        Logic.createMatrix();
        Logic.showMatrix();
        this.setM(2);
        this.setN(3);
        this.setM(Config.sizeX[k]);
        this.setN(Config.sizeY[k]);
        ScoreButton scoreButton = new ScoreButton(score);
        ProgressBar progressBar = new ProgressBar(0, Config.maxTime);
        Config.time = 0;
        JFrame jFrame = new JFrame();
        JPanel Main = new JPanel();
        Main.setLayout(new FlowLayout());
        Main.add(scoreButton);
        Main.add(progressBar);
        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(e -> {
            timeThread.setForceStop(false);
            timeThread.wakeup();
        });
        Main.add(startGame);
        jFrame.add(new MainScreen(), BorderLayout.CENTER);
        jFrame.add(Main, BorderLayout.SOUTH);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        return jFrame;
    }
}

