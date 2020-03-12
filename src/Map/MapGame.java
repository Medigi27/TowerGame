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
    private int healthMinion;
    private int healthHero;
    private int healthTower;
    private int speedMinion;
    public static final String PATH_IMG_HERO = "./src/GameGraphics/image/despicableMe.png";
    public static final String PATH_IMG_MINION = "./src/GameGraphics/image/minion.png";
    public static final String PATH_IMG_TOWER = "./src/GameGraphics/image/tower.png";

    private List<Minion> listOfMinions;
    public List<Tower> towers;
    private Hero hero;
    private Minion minion;
    private SmallTower smallTower;
    //TMP

    public MapGame() {
        Config cfg = new Config();
        this.healthMinion = cfg.getCfgValue(Config.HEALTH_MINION);
        this.healthHero = cfg.getCfgValue(Config.HEALTH_HERO);
        this.healthTower = cfg.getCfgValue(Config.HEALTH_TOWER); //todo: переделать под тип башни
        this.speedMinion = cfg.getCfgValue(Config.SPEED_MINION);
        this.listOfMinions = new LinkedList<Minion>();
        this.towers = new LinkedList<Tower>();
        hero = new Hero(PATH_IMG_HERO);
        minion = new Minion(PATH_IMG_MINION);
        smallTower = new SmallTower(PATH_IMG_TOWER);
    }

    public void addTowerElement(Tower tower) {
        this.towers.add(tower);
    }

    public void startGame() {
        GameGraphics gg = new GameGraphics();

        JFrame frame = new JFrame(/* название нашей игры */);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setResizable(false);
        frame.add(new GameGraphics());
        frame.setVisible(true);
    }
}
