package models;

import map.Storage;
import other.Config;
import other.Coordinates;

import javax.swing.*;
import java.awt.*;

public class Hero extends Unit {

	private String name;
	public int heroHealth = 3;

	private static Hero instance;

	public static Hero getInstance(){
		if(instance == null){
			instance = new Hero("Me");
		}
		return instance;
	}



	public Hero(String pathImgHero) {
		super(pathImgHero);
	}

	public void loseHeroHealth(){
		heroHealth--;
	}

}

