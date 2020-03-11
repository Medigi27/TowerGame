package models;

import other.Coordinates;

public class SmallTower extends Tower {
	@Override
	public int shoot(int health) {
		if (health - dmg < 0)
			return (0);
		return (health - dmg);
	}
}
