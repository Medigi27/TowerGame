package models;

import other.Coordinates;

public class Minion extends ShootingUnit {
	private int speed;

	public Minion() {
		super();
		speed = 0;
	}

	public Minion(int health) {
		super(health);
	}

	public Minion(int health, int speed) {
		super(health);
		this.speed = speed;
	}

	public Minion(int health, int speed, boolean isAlive) {
		super(health, isAlive);
		this.speed = speed;
	}

	public Minion(int health, int speed, boolean isAlive, Coordinates coord) {
		super(health, isAlive, coord);;
		this.speed = speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return (this.speed);
	}

	public Coordinates move(Coordinates coord) {
		int x;
		int y;

		x = coord.getX();
		y = coord.getY();
		if (x < 10)
			++x;
		return (new Coordinates(x, y));

	}
}
