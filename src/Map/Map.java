package Map;

import models.Hero;
import models.Minion;
import models.SmallTower;
import models.Tower;
import other.Coordinates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Map {
    //private Coordinates coordinates;
    private ArrayList<ArrayList<Coordinates>> mapOfCoordinates;
    private List<Minion> listOfMinions;
    private List<Tower> towers;
    private Hero hero;
//    private HeroInterface herointerface;
//    private Road road;

    public Map() {
        this.mapOfCoordinates = new ArrayList<ArrayList<Coordinates>>();
        this.listOfMinions = new LinkedList<Minion>();
        this.towers = new LinkedList<Tower>();
        hero = new Hero();
    }
}
