package gameGraphics;

import map.Background;
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
    HandlerAdapters     ha;
    GeneratorMinions    genMinions;
    Background          bg;
    int                 time;

    public GameGraphics(Config cfg, Storage storage) {
        this.cfg = cfg;
        this.storage = storage;
        ha = new HandlerAdapters(storage);
        genMinions = new GeneratorMinions(storage);
        bg = new Background();
        hero = new Hero();

        timer = new Timer(20, this);
        timer.start();
        addMouseListener(ha);
        setFocusable(true);
    }

    private void drawHero(Graphics g) {
        g.drawImage(hero.getCurrentImage(), hero.getCoord().getX(), hero.getCoord().getY(), 80, 110, null);
    }

    private void towersToShootMinion(Graphics g) {
        int length;

        for (SmallTower tower : storage.getTowers()) {
            tower.unitCanShoot();
            for (Minion minion : storage.getListOfMinions()) {
                length = tower.getLength(minion);
                if (length <= tower.getRadiusAttack()) {
                    tower.shoot(minion);
                }
                else {
                    tower.setStatusUnit(StatusUnit.DEFAULT);
                    minion.setMinionImg();
                }
            }
        }
    }

    private void drawTowers(Graphics g) {
        for (SmallTower tower : storage.getTowers()) {
            g.drawImage(tower.getCurrentImage(), tower.getCoord().getX(), tower.getCoord().getY(), 80, 120, null);
        }
    }
    private void drawBackground(Graphics g) {
        g.drawImage(bg.getBackground(), bg.getCoord().getX(), bg.getCoord().getY(), bg.getWidth(),bg.getHeight(), null);
    }

    public void paint(Graphics g) {
        if (genMinions.OneMinionHasGoneToHero()) {
            drawBackground(g);
            bg.setBackgroundLooseGame();
        }
        else if (genMinions.isAllDie()) {
            bg.setBackgroundWinGame();
            drawBackground(g);
        }
        else {
            genMinions.update();
            towersToShootMinion(g);
            drawBackground(g);
            genMinions.paint(g);
            drawTowers(g);
            drawHero(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++this.time;
        repaint();
    }
}
