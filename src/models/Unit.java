package models;

import map.Storage;
import other.Coordinates;

import java.awt.*;

public abstract class Unit {
	protected int           health;
	protected Coordinates   coord;
	protected StatusUnit    su;
	protected int           unitHeight;
	protected int           unitWight;

	public Unit() {
		this.su = StatusUnit.DEFAULT;
		health = 0;
		coord = new Coordinates(0, 0);
		coord.setX(0);
		coord.setY(0);
		unitHeight = 0;
		unitWight = 0;
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

	public StatusUnit getStatusUnit() {
		return (this.su);
	}

	public abstract Image getCurrentImage();
}
