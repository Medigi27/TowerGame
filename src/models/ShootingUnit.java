package models;

import other.Config;
import other.Coordinates;

public abstract class ShootingUnit extends Unit implements UnitAction {
	protected int radiusAttack;
	protected int damage;
	protected int reload;
	protected int cooldown;
	protected int timeShoot;

	ShootingUnit() {
		super();
		Config cfg = Config.getInstance();
		reload = cfg.getCfgValue(Config.RELOAD);
		timeShoot = 10;
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

	public boolean isReloading() {
		return (cooldown != 0);
	}

	public boolean isTimeShoot() {
		return (timeShoot != 0);
	}

	@Override
	public void shoot(Unit unit) {
		if (!isReloading() || isTimeShoot()) {
			this.su = StatusUnit.ATTACK;
			unit.su = StatusUnit.ATTACKED;
			cooldown = reload;
		}
		else if (!isTimeShoot()){
			--this.cooldown;
			unit.su = StatusUnit.DEFAULT;
			this.su = StatusUnit.DEFAULT;
			timeShoot = 10;
		}
	}
}
