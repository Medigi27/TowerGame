package models;

import other.Coordinates;

public class Hero extends Unit {
	public Hero() {
		super();
	}

	public Hero(int health) {
		super(health);
	}

	public Hero(int health, boolean isAlive) {
		super(health, isAlive);
	}

	public Hero(int health, boolean isAlive, Coordinates coord) {
		super(health, isAlive, coord);
	}
}
