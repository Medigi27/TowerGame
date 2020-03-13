package models;

import map.Storage;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Unit {
	protected int           health;
	protected boolean       isAlive;
	protected Coordinates   coord;
	protected Image         imageUnit;
	protected StatusUnit    su;
	protected int           unitHeight;
	protected int           unitWight;

	public Unit() {
		this.su = StatusUnit.DEFAULT;
		health = 0;
		isAlive = false;
		coord = new Coordinates(0, 0);
		coord.setX(0);
		coord.setY(0);
		unitHeight = 0;
		unitWight = 0;
	}

	public Unit(Config cfg) {
		this();
		this.health = Config.DEFAULT_HEALTH;
	}

	public Unit(String pathImage) {
		this();
		this.imageUnit = new ImageIcon(pathImage).getImage();
	}

	public Unit(int health) {
		this();
		this.health = health;
	}

	public Unit(int health, boolean isAlive) {
		this(health);
		this.isAlive = isAlive;
	}

	public Unit(int health, boolean isAlive, Coordinates coord) {
		this(health, isAlive);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public void setCoord(int x, int y) {
		this.coord.setX(x);
		this.coord.setY(y);
	}

	public int getHealth() {
		return health;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public int getLength(Unit unit) {
		double xCurr = this.coord.getX();
		double yCurr = this.coord.getY();
		double xUnit = unit.getCoord().getX();
		double yUnit = unit.getCoord().getY();

		return ((int)Math.sqrt((Math.pow((xCurr - xUnit), 2)) + (Math.pow((yCurr - yUnit) - (Storage.WIDTH_WINDOW / 4), 2))));
	}

	public void setStatusUnit(StatusUnit su) {
		this.su = su;
	}

	public abstract Image getCurrentImage();
}
