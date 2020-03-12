package map;

import gameGraphics.GameGraphics;
import other.Config;

import javax.swing.*;

public class MapGame {
    private Config cfg;
    private Storage storage;

    public MapGame() {
        cfg = Config.getInstance();
        storage = new Storage();
    }

    public void startGame() {
        JFrame frame = new JFrame(/* название нашей игры */);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Storage.WIDTH_WINDOW,Storage.HEIGHT_WINDOW);
        frame.setResizable(false);
        frame.add(new GameGraphics(this.cfg, this.storage));
        frame.setVisible(true);
    }
}
