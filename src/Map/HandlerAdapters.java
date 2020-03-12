package Map;

import models.SmallTower;
import models.Tower;
import models.Unit;
import other.Coordinates;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class HandlerAdapters extends MouseAdapter {
	LinkedList<SmallTower> towers;
	Unit unit;

	public HandlerAdapters() {
		this.towers = new LinkedList<>();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Coordinates coord = new Coordinates(0,0);

		coord.setX(e.getX());
		coord.setY(e.getY());
		SmallTower tower = new SmallTower(coord);
		towers.add(tower);
	}

	public Unit getUnit() {
		return (unit);
	}

	public LinkedList<SmallTower> getTowers() {
		return (towers);
	}
}
