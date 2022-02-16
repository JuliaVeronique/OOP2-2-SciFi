package domain;

import domain.planet.Moon;
import domain.planet.Planet;
import domain.star.Star;

import java.util.ArrayList;
import java.util.List;

public class Universe{
    private static Universe instance = new Universe();
    private List<Body> bodies = new ArrayList<>();
    private List<Planet> planets = new ArrayList<>();
    private List<Moon> moons = new ArrayList<>();
    private List<Star> stars = new ArrayList<>();


    private Universe(){}

    public static Universe getInstance() {
        return instance;
    }

    public void addPlanet(Planet planet){
        planets.add(planet);
    }
    public void addMoon(Moon moon){
        moons.add(moon);
    }
    public void addStar(Star star){
        stars.add(star);
    }
    public void addBody(Body body){
        bodies.add(body);
    }

    @Override
    public String toString() {
        return "Universe{" +
                "bodies=" + bodies + bodies.size() +
                '}';
    }
}
