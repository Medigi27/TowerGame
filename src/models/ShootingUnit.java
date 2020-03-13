package models;

import other.Config;
import other.Coordinates;

public abstract class ShootingUnit extends Unit implements UnitAction {
	protected int radiusAttack;
	protected int reload;
	protected int cooldown;
	protected int timeShoot;
	protected boolean unitCanShoot;

	ShootingUnit() {
		super();
		Config cfg = Config.getInstance();
		reload = cfg.getCfgValue(Config.RELOAD);
		cooldown = 0;
		timeShoot = 30;
		unitCanShoot = true;
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

	public void unitCantShoot() {
		this.unitCanShoot = false;
	}

	public void unitCanShoot() {
		this.unitCanShoot = true;
	}

	public boolean isCanShoot() {
		return (unitCanShoot);
	}

	@Override
	public void shoot(Unit unit) {
			if (!isReloading() && unit.getStatusUnit() != StatusUnit.DIE && this.isCanShoot()) {
				cooldown = reload;
				this.timeShoot = 30;
				Minion m = (Minion) unit;
				m.hitMinion();
				this.unitCantShoot();
			} else if (isTimeShoot() && unit.getStatusUnit() != StatusUnit.DIE) {
				this.su = StatusUnit.ATTACK;
				unit.su = StatusUnit.ATTACKED;
				if (timeShoot > 0)
					--this.timeShoot;
				--this.cooldown;
			} else {
				--this.cooldown;
				this.su = StatusUnit.DEFAULT;
				if (unit.getStatusUnit() != StatusUnit.DIE)
					unit.setStatusUnit(StatusUnit.DEFAULT);
			}
	}
}
