package Map;

import other.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Coordinates coordinates;
    private ArrayList<ArrayList<Coordinates>> mapOfCoordinates;
    private List<Minion> listOfMinions;
    private List<Towers> towers;
    private Hero hero;
    private HeroInterface herointerface;
    private Road road;

    Map(ArrayList<ArrayList<Coordinates>> mapOfCoordinates, ArrayList<Minion> listOfMinions,
        ArrayList<Towers> towers, Hero hero, HeroInterface heroInterface, Road road) {
        this.coordinates = new Coordinates(10, 10);
        this.mapOfCoordinates = mapOfCoordinates;
        this.listOfMinions = listOfMinions;
        this.towers = towers;
        this.hero = hero;
        this.herointerface = heroInterface;
        this.road = road;
    }
}
