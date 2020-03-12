package map;

import models.SmallTower;
import other.Coordinates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HandlerAdapters extends MouseAdapter {
	Storage storage;

	public HandlerAdapters(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Coordinates coord = new Coordinates(0,0);

		coord.setX(e.getX());
		coord.setY(e.getY());
		SmallTower tower = new SmallTower(coord);
		storage.setStorageTower(tower);
	}
}
