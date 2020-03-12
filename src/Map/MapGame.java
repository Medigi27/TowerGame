package Map;

import gameGraphics.GameGraphics;
import models.Hero;
import models.Minion;
import models.SmallTower;
import models.Tower;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapGame {
    private Config cfg;
    private Storage storage;

    public MapGame() {
        cfg = new Config();
        storage = new Storage();
    }

    public void startGame() {
        JFrame frame = new JFrame(/* название нашей игры */);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setResizable(false);
        frame.add(new GameGraphics(this.cfg, storage));
        frame.setVisible(true);
    }
}
