package gameGraphics;

import map.Storage;
import models.Hero;
import models.Minion;
import other.Config;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MinionsManager {
	List<Minion> minions;
	Config cfg;
	int cooldown = 100;
	Random r;
	int countMinions;
	Hero hero;

	public MinionsManager(Storage storage) {
		minions = storage.getListOfMinions();
		cfg = Config.getInstance();
		this.countMinions = cfg.getCfgValue(Config.COUNT_MINIONS);
		r = new Random();
		hero = storage.getHero();
	}

	void fillMinions(){
		cooldown--;
		if(minions.size() == countMinions){

		}else
		if(cooldown<= 0){
			minions.add(new Minion());
			cooldown = r.nextInt(100)+100;
		}

	}

	void minionAttackHero(){
		for (int i = 0; i < minions.size(); i++) {
			if(minions.get(i).getCoord().getX() == 810){
				minions.remove(i);
				hero.loseHeroHealth();
			}
		}

	}

	public void paint(Graphics g) {

		for (Minion iter : minions) {
			g.drawImage(iter.getCurrentImageMinion(), iter.getCoord().getX(), 350, 60, 60, null);
		}
	}

	public void update(){
		fillMinions();
		minionAttackHero();
		hero.heroHealth--;
		for(Minion m : minions){
			m.move();
		}
	}
}
