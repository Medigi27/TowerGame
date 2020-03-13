package map;

import models.Hero;
import models.Minion;
import models.SmallTower;
import other.Config;

import java.util.LinkedList;
import java.util.List;

public class Storage {
	private int healthMinion;
	private int healthHero;
	private int healthTower;
	private int speedMinion;
	public static final String PATH_IMG_HERO = "./src/GameGraphics/image/despicableMe.png";
	public static final String PATH_IMG_HERO_ATTACKED = "";
	public static final String PATH_IMG_TOWER = "./src/GameGraphics/image/tower.png";
	public static final String PATH_IMG_TOWER_ATTACK = "src/imagesPolina/imegesGame/towerAttack.png";
	public static final String PATH_IMG_TOWER_DESTROY = "";
	public static final String PATH_TOWER_ATTACKED = "";
	public static final String PATH_IMG_MINION = "./src/GameGraphics/image/minion.png";
	public static final String PATH_IMG_MINION_ATTACK = "";
	public static final String PATH_IMG_MINION_ATTACKED = "src/imagesPolina/imegesGame/damagedMinion.png";
	public static final String PATH_IMG_MINION_DIE = "src/imagesPolina/imegesGame/deadMinion.png";

	private List<Minion> listOfMinions;
	private List<SmallTower> towers;
	private Hero hero;
	private Minion minion;
	private SmallTower smallTower;
	public  static final int HEIGHT_WINDOW = 700;
	public  static final int WIDTH_WINDOW = 900;

	Storage() {
		Config cfg = Config.getInstance();
		this.healthMinion = cfg.getCfgValue(Config.HEALTH_MINION);
		this.healthHero = cfg.getCfgValue(Config.HEALTH_HERO);
		this.healthTower = cfg.getCfgValue(Config.HEALTH_TOWER); //todo: переделать под тип башни
		this.speedMinion = cfg.getCfgValue(Config.SPEED_MINION);
		this.listOfMinions = new LinkedList<Minion>();
		this.towers = new LinkedList<SmallTower>();
		hero = new Hero(PATH_IMG_HERO);
	}

	public int getHealthMinion() {
		return healthMinion;
	}

	public void setHealthMinion(int healthMinion) {
		this.healthMinion = healthMinion;
	}

	public int getHealthHero() {
		return healthHero;
	}

	public void setHealthHero(int healthHero) {
		this.healthHero = healthHero;
	}

	public int getHealthTower() {
		return healthTower;
	}

	public void setHealthTower(int healthTower) {
		this.healthTower = healthTower;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public int getSpeedMinion() {
		return speedMinion;
	}

	public void setSpeedMinion(int speedMinion) {
		this.speedMinion = speedMinion;
	}

	public Minion getMinion() {
		return minion;
	}

	public void setMinion(Minion minion) {
		this.minion = minion;
	}

	public List<SmallTower> getTowers() {
		return towers;
	}

	public void setTowers(List<SmallTower> towers) {
		this.towers = towers;
	}

	public void setStorageMinion(Minion minion) {

	}

	public List<Minion> getListOfMinions() {
		return listOfMinions;
	}

	public void setListOfMinions(List<Minion> listOfMinions) {
		this.listOfMinions = listOfMinions;
	}

	public void setStorageTower(SmallTower st) {
		towers.add(st);
	}
}
