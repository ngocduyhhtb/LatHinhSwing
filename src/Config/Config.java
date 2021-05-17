package Config;

import javax.swing.*;

public class Config {
    public static final int maxXY = 100;
    public static final int[] sizeX = {2, 2, 2, 3, 4, 4, 4, 4, 5, 5};
    public static final int[] sizeY = {3, 4, 6, 6, 6, 7, 8, 10, 10, 12};
    public static final int[] TIME = {10, 20, 30, 50, 65, 80, 100, 120, 140, 150};
    public static final int maxTime = 30;
    public static final JButton[][] bt = new JButton[maxXY][maxXY];
    public static final int[][] a = new int[maxXY][maxXY];
    public static final boolean loss = false;
    public static final int BOM = 0, dem = 0;
    public static final int m = 2, n = 3;
    public static int time = 0;
}
