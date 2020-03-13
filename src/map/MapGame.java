package map;

import gameGraphics.GameGraphics;

import javax.swing.*;

public class MapGame {
    private Storage storage;

    public MapGame() {
        storage = new Storage();
    }

    public void startGame() {
        JFrame frame = new JFrame(/* название нашей игры */);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Storage.WIDTH_WINDOW,Storage.HEIGHT_WINDOW);
        frame.setResizable(false);
        frame.add(new GameGraphics(this.storage));
        frame.setVisible(true);
    }
}
