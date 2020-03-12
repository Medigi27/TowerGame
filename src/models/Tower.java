package models;

import other.Coordinates;

public abstract class Tower extends ShootingUnit {
	public Tower() {

	}

	public Tower(String pathImgTower) {
		super(pathImgTower);
	}

	public Tower(Coordinates coord) {
		this.coord = coord;
	}
}
