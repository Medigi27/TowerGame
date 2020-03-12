package gameGraphics;

import Map.HandlerAdapters;
import Map.MapGame;
import Map.Storage;
import models.Minion;
import models.SmallTower;
import models.Tower;
import other.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer = new Timer(20, this);
    Config cfg;
    Storage storage;
    Minion m;
    SmallTower st;
    HandlerAdapters ha;

    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Image heroImage = new ImageIcon("./src/GameGraphics/image/despicableMe.png").getImage();
    Image tower = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
    ArrayList<Image> towerList = new ArrayList<>();


    public GameGraphics(Config cfg, Storage storage) {
        this.cfg = cfg;
        this.storage = storage;
        this.st = new SmallTower();
        m = new Minion();
        ha = new HandlerAdapters(storage);
        timer.start();
        addMouseListener(ha);
        setFocusable(true);
    }


    public void paint(Graphics g) {

        g.drawImage(background, 0, 0, 900,700, null);
        g.drawImage(heroImage, 820, 300, 80, 110, null);
        for (SmallTower iter : storage.getTowers()) {
            g.drawImage(iter.getImage(), iter.getCoord().getX(), iter.getCoord().getY(), 80, 120, null);
        }
        g.drawImage(m.getImgMinion(), m.getCoord().getX(), 350, 60,60, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.move();
        repaint();
    }
}
