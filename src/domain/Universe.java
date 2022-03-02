package domain;

import domain.planet.Moon;
import domain.planet.Planet;
import domain.star.Star;

import java.util.ArrayList;
import java.util.List;

public class Universe implements Observer {
    private static Universe instance = new Universe();
    private List<Body> bodies = new ArrayList<>();

    private Universe() {
    }

    public static Universe getInstance() {
        return instance;
    }

    public void addBody(Body body) {
        bodies.add(body);
    }

    @Override
    public String toString() {
        return "Universe{" +
                "bodies=" + bodies + bodies.size() +
                '}';
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
