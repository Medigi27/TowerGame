package map;

import models.Hero;
import models.Minion;
import models.SmallTower;

import java.util.LinkedList;
import java.util.List;

public class Storage {
	public static final String PATH_IMG_HERO = "./src/GameGraphics/image/despicableMe.png";
	public static final String PATH_IMG_TOWER = "./src/GameGraphics/image/tower.png";
	public static final String PATH_IMG_TOWER_ATTACK = "src/imagesPolina/imegesGame/damagedTower.png";
	public static final String PATH_IMG_MINION = "./src/GameGraphics/image/minion.png";
	public static final String PATH_IMG_MINION_ATTACK = "";
	public static final String PATH_IMG_MINION_ATTACKED = "src/imagesPolina/imegesGame/damagedMinion.png";
	public static final String PATH_IMG_MINION_DIE = "src/imagesPolina/imegesGame/deadMinion.png";

	private List<Minion> listOfMinions;
	private List<SmallTower> towers;
	private Hero hero;
	public  static final int HEIGHT_WINDOW = 700;
	public  static final int WIDTH_WINDOW = 900;

	Storage() {
		this.listOfMinions = new LinkedList<>();
		this.towers = new LinkedList<>();
		hero = new Hero();
	}

	public Hero getHero() {
		return (this.hero);
	}

	public List<SmallTower> getTowers() {
		return towers;
	}

	public List<Minion> getListOfMinions() {
		return listOfMinions;
	}

	public void setStorageTower(SmallTower st) {
		towers.add(st);
	}
}
