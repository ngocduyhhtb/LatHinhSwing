package Controller;

import Config.Config;

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


}
