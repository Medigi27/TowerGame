package models;

import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class Minion extends ShootingUnit {
	private int speed;

	public Minion() {
		super();
		speed = 0;
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
		return (imageUnit);
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
		//this.coord.setY()
	}
}
