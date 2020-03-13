package gameGraphics;

import map.HandlerAdapters;
import map.Storage;
import models.Hero;
import models.Minion;
import models.SmallTower;
import models.StatusUnit;
import other.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGraphics extends JPanel implements ActionListener {
    Timer timer;
    Hero                hero;
    Config              cfg;
    Storage             storage;
    Minion              m;
    SmallTower          st;
    HandlerAdapters     ha;
    GeneratorMinions    genMinions;
    Image               background;
    int                 time;

    public GameGraphics(Config cfg, Storage storage) {
        this.cfg = cfg;
        this.storage = storage;
        this.st = new SmallTower();
        ha = new HandlerAdapters(storage);
        genMinions = new GeneratorMinions(storage);
        hero = new Hero();
        background = new ImageIcon("./src/GameGraphics/image/background.png").getImage();
        timer = new Timer(20, this);
        timer.start();
        addMouseListener(ha);
        setFocusable(true);
    }

    private void drawHero(Graphics g) {
        g.drawImage(hero.getCurrentImage(), hero.getCoord().getX(), hero.getCoord().getY(), 80, 110, null);
    }

    private void drawTowers(Graphics g) {
        int length;

        for (SmallTower tower : storage.getTowers()) {
            for (Minion iterMinion : storage.getListOfMinions()) {
                length = tower.getLength(iterMinion);
                if (length <= tower.getRadiusAttack()) {
                    tower.shoot(iterMinion);
                }
                else {
                    tower.setStatusUnit(StatusUnit.DEFAULT);
                    iterMinion.setStatusUnit(StatusUnit.DEFAULT);
                }
            }
        }
        for (SmallTower tower : storage.getTowers()) {
            g.drawImage(tower.getCurrentImage(), tower.getCoord().getX(), tower.getCoord().getY(), 80, 120, null);
            genMinions.paint(g);
        }
    }

    private void drawBackground(Graphics g) {
        g.drawImage(background, 0, 0, 900,700, null);
    }

    public void paint(Graphics g) {
        genMinions.update();

        drawBackground(g);
        drawHero(g);
        drawTowers(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++this.time;
        repaint();
    }
}
