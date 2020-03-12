package map;

import gameGraphics.GameGraphics;
import other.Config;

import javax.swing.*;

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
