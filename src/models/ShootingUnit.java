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
		this.health = cfg.getCfgValue(Config.HEALTH_MINION);
		reload = cfg.getCfgValue(Config.RELOAD);
		cooldown = 0;
		timeShoot = 30;
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
		if (!isReloading() && unit.getStatusUnit() != StatusUnit.DIE) {
			this.su = StatusUnit.ATTACK;
			unit.su = StatusUnit.ATTACKED;
			cooldown = reload;
			this.timeShoot = 30;
			Minion m = (Minion)unit;
			m.hitMinion();
		}
		else if (isTimeShoot() && unit.getStatusUnit() != StatusUnit.DIE) {
			this.su = StatusUnit.ATTACK;
			unit.su = StatusUnit.ATTACKED;
			if (timeShoot > 0)
				--this.timeShoot;
			--this.cooldown;
		}
		else {
			--this.cooldown;
			this.su = StatusUnit.DEFAULT;
		}
	}
}
