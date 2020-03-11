package Map;

import other.Coordinates;
import java.util.List;

public class Map {
    private Coordinates coordinates;
    private List<List<Coordinates>> mapOfCoordinates;
    private List<Minions> listOfMinions;
    private List<Towers> towers;
    private Hero hero;
    private HeroInterface herointerface;
    private Road road;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<List<Coordinates>> getMapOfCoordinates() {
        return mapOfCoordinates;
    }

    public void setMapOfCoordinates(List<List<Coordinates>> mapOfCoordinates) {
        this.mapOfCoordinates = mapOfCoordinates;
    }

    public List<Minions> getListOfMinions() {
        return listOfMinions;
    }

    public void setListOfMinions(List<Minions> listOfMinions) {
        this.listOfMinions = listOfMinions;
    }

    public List<Towers> getTowers() {
        return towers;
    }

    public void setTowers(List<Towers> towers) {
        this.towers = towers;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public HeroInterface getHerointerface() {
        return herointerface;
    }

    public void setHerointerface(HeroInterface herointerface) {
        this.herointerface = herointerface;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
}
