package gameGraphics;

import map.Storage;
import models.Minion;
import models.StatusUnit;
import other.Config;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class ManagerMinions {
	List<Minion> minions;
	Config  cfg;
	int     cooldown;
	Random  r;
	int     countMinions;

	public ManagerMinions(Storage storage) {
		this.cooldown = 100;
		minions = storage.getListOfMinions();
		cfg = Config.getInstance();
		this.countMinions = cfg.getCfgValue(Config.COUNT_MINIONS);
		r = new Random();
		fillMinions();
	}

	void fillMinions(){
		cooldown--;
		if (cooldown <= 0){
			minions.add(new Minion());
			cooldown = r.nextInt(100) + 100;
		}
	}

	public void paint(Graphics g) {

		for (Minion iter : minions) {
			g.drawImage(iter.getCurrentImage(), iter.getCoord().getX(), 350, 60, 60, null);
		}
	}

	public void update(){
		if (minions.size() != countMinions)
			fillMinions();
		for(Minion m : minions){
			if (m.getCoord().getX() < 820)
				m.move();
		}
	}

	public boolean OneMinionHasGoneToHero() {
		if (minions.size() == cfg.getCfgValue(Config.COUNT_MINIONS)) {
			for (Minion minion : minions) {
				if (minion.getCoord().getX() >= 820) {
					return (true);
				}
			}
		}
		return (false);
	}

	public boolean isAllDie() {
		if (minions.size() == cfg.getCfgValue(Config.COUNT_MINIONS)) {
			for (Minion minion : minions) {
				if (minion.getStatusMinion() != StatusUnit.DIE) {
					return (false);
				}
			}
			return (true);
		}
		return (false);
	}
}
