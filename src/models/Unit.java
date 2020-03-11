package models;

import other.Coordinates;

import java.awt.event.KeyEvent;

public abstract class Unit {
	protected int           health;
	protected boolean       isAlive;
	protected Coordinates   coord;

	public Unit() {
		health = 0;
		isAlive = false;
		coord = new Coordinates(0, 0);
		coord.setX(0);
		coord.setY(0);
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


}
