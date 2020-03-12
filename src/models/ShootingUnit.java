package models;

import other.Coordinates;

public abstract class ShootingUnit extends Unit implements UnitAction {
	protected int radiusAttack;
	protected int damage;

	ShootingUnit() {
		super();
	}

	ShootingUnit(String pathImg) {
		super(pathImg);
	}

	public void setRadiusAttack(int radiusAttack) {
		this.radiusAttack = radiusAttack;
	}

	public int getRadiusAttack() {
		return (this.radiusAttack);
	}

	@Override
	public int shoot(int health) {
		return (health - damage);
	}
}
