package models;

import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class SmallTower extends Tower {
	public SmallTower() {
		super();
		this.imageUnit = new ImageIcon("./src/GameGraphics/image/tower.png").getImage();
	}

	public SmallTower(String pathImgTower) {
		super(pathImgTower);
	}

	public SmallTower(Coordinates coord) {
		this();
		this.coord = coord;
	}

	@Override
	public int shoot(int health) {
		if (health - dmg < 0)
			return (0);
		return (health - dmg);
	}

	public Image getImage() {
		return (this.imageUnit);
	}
}
