package domain.person;


import domain.planet.Climate;
import domain.planet.Planet;
import domain.planet.PlanetType;
import domain.planet.TechnicalLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static domain.planet.Climate.*;

//2.	Based on the preferred climate of the species. The lower in the list the preferred climate is,
//    the lower the chance of a person being male.
//    With subarctic climates the distribution is 10/11 male, 1/11 female. Tropical yields 50/50, while Ocean yields 10/11 female, 1/11 male.
public class GenderClimate implements IGenderGenerator {
    @Override
    public Gender getGender(Species species) {
        Climate climate = species.getPreferredClimate();
        Random r = new Random();

        if (climate.equals(TROPICAL)) {
            int random = r.nextInt(2);
            if (random == 0) return Gender.FEMALE;
            else return Gender.FEMALE;
        }

        List<Climate> climates = new ArrayList<>();
        climates.addAll(List.of(new Climate[]{SUBARCTIC, ARCTIC, TEMPERATE, MARSHY, SUBTROPICAL, TROPICAL, DESERT, FIERY, SUPERFIERY, CHEMICAL, OCEAN}));
        int chance = climates.indexOf(climate) + 1; //chance it is a female
        int random = r.nextInt(12) + 1;

        if (chance <= random) return Gender.FEMALE;
        else return Gender.MALE;
    }

    @Override
    public Gender getGender() {
        return getGender(new Species("name", "desc", Intelligence.COMMON, TechnicalLevel.NONE, PlanetType.D, Climate.TROPICAL, new Planet()));
    }
}
