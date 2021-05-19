package Controller;

import Config.Config;

public class MainController {
    public void setUp(int lv)
    {
        Logic.createMatrix();
        Logic.showMatrix();

        Config.time = 0;
        Config.lv = lv;
    }
}
