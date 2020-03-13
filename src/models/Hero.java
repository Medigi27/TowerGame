package models;

import map.Storage;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class Hero extends Unit {
	private static final Image HERO_STAND = new ImageIcon(Storage.PATH_IMG_HERO).getImage();
	private static final Image HERO_DIE = new ImageIcon(Storage.PATH_IMG_HERO).getImage();
	private String name;

	public Hero() {
		super();
		coord.setX(820);
		coord.setY(300);
	}

	public Hero(String pathImgHero) {
		super(pathImgHero);
	}

	public Image getCurrentImage() {
		switch (su) {
			case DIE:
				return (HERO_DIE);
			case DEFAULT:
				return (HERO_STAND);
		}
		return (null);
	}
}
