package gameGraphics;

import map.HandlerAdapters;
import map.Storage;
import models.Minion;
import models.SmallTower;
import models.StatusUnit;
import other.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer = new Timer(3, this);
    Config          cfg;
    Storage         storage;
    Minion          m;
    SmallTower      st;
    HandlerAdapters ha;
    GeneratorMinions genMinions;

    Image background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
    Image heroImage = new ImageIcon("./src/GameGraphics/image/despicableMe.png").getImage();
    Image tower = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
    ArrayList<Image> towerList = new ArrayList<>();

    public GameGraphics(Config cfg, Storage storage) {
        this.cfg = cfg;
        this.storage = storage;
        this.st = new SmallTower();
        ha = new HandlerAdapters(storage);
        genMinions = new GeneratorMinions(storage);
        timer.start();
        addMouseListener(ha);
        setFocusable(true);
    }

    private void drawHero(Graphics g) {
        g.drawImage(heroImage, 820, 300, 80, 110, null);
    }

    private void drawTowers(Graphics g) {
        int length;

        for (SmallTower iter : storage.getTowers()) {
            for (Minion iterMinion : storage.getListOfMinions()) {
                length = iter.getLength(iterMinion);
                if (length <= iter.getRadiusAttack())
                    iter.shoot(iterMinion);
                else {
                    iter.setStatusUnit(StatusUnit.DEFAULT);
                    iterMinion.setStatusUnit(StatusUnit.DEFAULT);
                }
            }
        }
        for (SmallTower iter : storage.getTowers()) {
            g.drawImage(iter.getCurrentImageTower(), iter.getCoord().getX(), iter.getCoord().getY(), 80, 120, null);
            iter.setStatusUnit(StatusUnit.DEFAULT);
        }
        genMinions.paint(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(background, 0, 0, 900,700, null);
    }

    public void paint(Graphics g) {
        genMinions.update();

        drawBackground(g);
        drawHero(g);
        drawTowers(g);
        //todo: tmp fields
//        genMinions.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        m.move();
        repaint();
    }
}
