package gameGraphics;

import map.Storage;
import models.Minion;
import other.Config;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeneratorMinions{
	List<Minion> minions;
	Config cfg;
	int cooldown = 100;
	Random r;
	int countMinions;

	public GeneratorMinions(Storage storage) {
		minions = storage.getListOfMinions();
		cfg = Config.getInstance();
		this.countMinions = cfg.getCfgValue(Config.COUNT_MINIONS);
		r = new Random();
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

	public void paint(Graphics g) {

		for (Minion iter : minions) {
			g.drawImage(iter.getCurrentImage(), iter.getCoord().getX(), 350, 60, 60, null);
		}
	}

	public void update(){
		fillMinions();
		for(Minion m : minions){
			m.move();
		}
	}
}
