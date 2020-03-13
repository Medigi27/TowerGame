package models;

import map.Storage;
import other.Config;

import javax.swing.*;
import java.awt.*;

public class Minion extends ShootingUnit {
	private final static Image MINION_IMG = new ImageIcon(Storage.PATH_IMG_MINION).getImage();
	private final static Image MINION_ATTACK = new ImageIcon(Storage.PATH_IMG_MINION_ATTACK).getImage();
	private final static Image MINION_ATTACKED = new ImageIcon(Storage.PATH_IMG_MINION_ATTACKED).getImage();
	private final static Image MINION_DIE = new ImageIcon(Storage.PATH_IMG_MINION_DIE).getImage();
	private int speed;
	private boolean minionTarget;

	public Minion() {
		super();
		Config cfg = Config.getInstance();
		this.speed = cfg.getCfgValue(Config.SPEED_MINION);
		this.radiusAttack = cfg.getCfgValue(Config.RADIUS_ATTACK_MINION);
		this.imageUnit = new ImageIcon("./src/GameGraphics/image/minion.png").getImage();
		minionTarget = false;
		this.su = StatusUnit.DEFAULT;
	}

	public void setTargetMinion() {
		this.minionTarget = true;
	}

	public void setMinionImg() {
		if (this.health == 0) {
			this.su = StatusUnit.DIE;
		}
		else
			this.su = StatusUnit.DEFAULT;
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
		return (getCurrentImage());
	}

	public void move() {
		//todo проверка выхода за пределы
		int x = this.coord.getX();
		int y = this.coord.getY();

		if (this.su != StatusUnit.DIE) {
			if (x > 820) {
				this.coord.setX(0);
			} else
				this.coord.setX(x + this.speed);
		}
	}

	public void hitMinion() {
		if (this.health > 0)
			this.health--;
		else
			this.su = StatusUnit.DIE;
	}

	public StatusUnit getStatusMinion() {
		return (this.su);
	}

	@Override
	public Image getCurrentImage() {
		switch (su) {
			case ATTACK:
				return (MINION_ATTACK);
			case ATTACKED:
				return (MINION_ATTACKED);
			case DIE:
				return (MINION_DIE);
			case DEFAULT:
				return (MINION_IMG);
		}
		return (null);
	}
}
