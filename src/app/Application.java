package app;

import domain.Universe;
import domain.news.News;
import domain.news.Source;
import domain.person.Intelligence;
import domain.person.Organization;
import domain.person.Person;
import domain.person.Species;
import domain.planet.*;
import domain.star.LuminosityClass;
import domain.star.Star;
import domain.star.StarType;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<Star> stars = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 50; i++) { //create stars
            Star tempStar = new Star("none", "name", StarType.K, 0, LuminosityClass.IX, 0, 0, 4253.1807, 144.82558, 0.44032276, 0.10076359586949325);
            stars.add(tempStar);
        }
        List<Planet> planets = new ArrayList<>();
        for (Star star : stars) {
            Planet tempPlanet = new Planet("none", "none", PlanetType.R, star, 0, 0, 0, 0);
            star.addPlanet(tempPlanet);
            planets.add(tempPlanet);
        }
        for (Planet planet : planets) {
            Moon tempMoon = new Moon("none", "none", "none2", planet);
            planet.addMoon(tempMoon);
        }

        for (int i = 0; i < 3; i++) {
            Organization organization = new Organization("name organisation", "description");
            Source source = new Source("name source", "desc");
            Person person = new Person("Jan");
        }
    }
}
