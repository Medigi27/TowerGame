package models;

import Map.Storage;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

enum StatusMinion {
	MINION_MOVING,
	MINION_ATTACKED,
	MINION_ATTACK,
	MINION_DIE;
}

public class Minion extends ShootingUnit {
	private final static Image MINION_IMG = new ImageIcon(Storage.PATH_IMG_MINION).getImage();
	private final static Image MINION_ATTACK = new ImageIcon(Storage.PATH_IMG_MINION_ATTACK).getImage();
	private final static Image MINION_ATTACKED = new ImageIcon(Storage.PATH_IMG_MINION_ATTACKED).getImage();
	private final static Image MINION_DIE = new ImageIcon(Storage.PATH_IMG_MINION_DIE).getImage();
	private int speed;
	StatusMinion sm;

	public Minion() {
		super();
		Config cfg = new Config();
		sm = StatusMinion.MINION_MOVING;
		this.speed = cfg.getCfgValue(Config.SPEED_MINION);
		this.imageUnit = new ImageIcon("./src/GameGraphics/image/minion.png").getImage();
	}

	public Minion(Config cfg) {
		this.health = cfg.getCfgValue(Config.SPEED_MINION);
		this.speed = cfg.getCfgValue(Config.SPEED_MINION);
	}

	public Minion(String pathImgMinion) {
		super(pathImgMinion);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return (this.speed);
	}

	public Image getImgMinion() {
		return (getCurrentImageMinion());
	}

	public void move() {
		//todo проверка выхода за пределы
		int x = this.coord.getX();
		int y = this.coord.getY();

		//tmp
		if (x > 820) {
			this.coord.setX(0);
		}
		else
			this.coord.setX(x + this.speed);
	}

	public Image getCurrentImageMinion() {
		switch (sm) {
			case MINION_ATTACK:
				return (MINION_ATTACK);
			case MINION_ATTACKED:
				return (MINION_ATTACKED);
			case MINION_DIE:
				return (MINION_DIE);
			case MINION_MOVING:
				return (MINION_IMG);
		}
		return (null);
	}
}
