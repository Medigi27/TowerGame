package models;

import other.Coordinates;

public abstract class ShootingUnit extends Unit implements UnitAction {
	protected int radiusAttack;
	protected int dmg;

	ShootingUnit() {
		super();
	}

	ShootingUnit(int health) {
		super(health);
	}

	public ShootingUnit(int health, boolean isAlive) {
		super(health, isAlive);
	}

	public ShootingUnit(int health, boolean isAlive, Coordinates coord) {
		super(health, isAlive, coord);;
	}

	public ShootingUnit(int health, boolean isAlive, Coordinates coord, int radiusAttack) {
		super(health, isAlive, coord);
		this.radiusAttack = radiusAttack;
	}

	public ShootingUnit(int health, boolean isAlive, Coordinates coord, int radiusAttack, int dmg) {
		this(health, isAlive, coord, radiusAttack);
		this.dmg = dmg;
	}

	public void setRadiusAttack(int radiusAttack) {
		this.radiusAttack = radiusAttack;
	}

	public int getRadiusAttack() {
		return (this.radiusAttack);
	}

	@Override
	public int shoot(int health) {
		return (health - dmg);
	}
}
