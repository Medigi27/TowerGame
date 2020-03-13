package models;

import map.Storage;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class SmallTower extends Tower {
	private static final Image TOWER_ATTACK = new ImageIcon("src/imagesPolina/imegesGame/towerAttack.png").getImage();
	private static final Image TOWER_ATTACKED = new ImageIcon("").getImage();
	private static final Image TOWER_DESTROY = new ImageIcon("").getImage();
	private static final Image TOWER_DEFAULT = new ImageIcon(Storage.PATH_IMG_TOWER).getImage();

	public SmallTower() {
		super();
		Config cfg = Config.getInstance();
		this.radiusAttack = cfg.getCfgValue(Config.RADIUS_ATTACK_TOWER);
		this.imageUnit = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
	}

	public SmallTower(String pathImgTower) {
		super(pathImgTower);
	}

	public SmallTower(Coordinates coord) {
		this();
		this.coord = coord;
	}

	public Image getImage() {
		return (getCurrentImage());
	}

	@Override
	public Image getCurrentImage() {
		switch (su) {
			case ATTACK:
				return (TOWER_ATTACK);
			case ATTACKED:
				return (TOWER_ATTACKED);
			case DEFAULT:
				return (TOWER_DEFAULT);
		}
		return (null);
	}
}
