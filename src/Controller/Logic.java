package Controller;

import Config.Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Logic {
    public static void createMatrix() {
        int N = Config.m * Config.n;
        int[] b = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = i + 1;
            if (b[i] > N / 2) {
                b[i] -= (N / 2);
            }
            c[i] = (int) (Math.random() * 100000);
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (c[i] > c[j]) {
                    int temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        N = 0;
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                Config.a[i][j] = b[N++];
            }
        }
    }

    public static void showMatrix() {
        for (int i = 0; i < Config.m; i++) {
            for (int j = 0; j < Config.n; j++) {
                System.out.print(Config.a[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public Icon getIcon(int index) {
        int width = 120, height = 170;
        String dictionary = "/Icon/icon" + index + ".jpg";
        Image image = new ImageIcon(Objects.requireNonNull(getClass().getResource(dictionary))).getImage();
        return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
