package models;

import map.Storage;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class SmallTower extends Tower {
	private static final Image TOWER_ATTACK = new ImageIcon(Storage.PATH_IMG_TOWER_ATTACK).getImage();
	private static final Image TOWER_DEFAULT = new ImageIcon(Storage.PATH_IMG_TOWER).getImage();

	public SmallTower() {
		super();
		Config cfg = Config.getInstance();
		this.radiusAttack = cfg.getCfgValue(Config.RADIUS_ATTACK_TOWER);
		this.imageUnit = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
		this.towerHit = false;
	}

	public SmallTower(Coordinates coord) {
		this();
		this.coord = coord;
	}

	@Override
	public Image getCurrentImage() {
		switch (su) {
			case ATTACK:
				return (TOWER_ATTACK);
			case DEFAULT:
				return (TOWER_DEFAULT);
		}
		return (null);
	}
}
