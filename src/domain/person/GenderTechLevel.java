package domain.person;

import domain.planet.Climate;
import domain.planet.Planet;
import domain.planet.PlanetType;
import domain.planet.TechnicalLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static domain.planet.TechnicalLevel.*;

//3.	Based on the TechnicalLevel of the species. If that is the highest from the list, the gender always is OTHER.
//    The next two levels (counting from the highest) have a random distribution of 20% other, 20% unknown, 30% male, 30% female.
//    The rest have 10% of other, 10% unknown, 40% male, 40% female.
public class GenderTechLevel implements IGenderGenerator{
    @Override
    public Person.Gender getGender(Species species) {
//        NONE, STONE, BRONZE, IRON, RENAISSANCE, INDUSTRIAL, ELECTRIFIED, COMPUTERIZED, SPACEFARING, GATEUSER, FASTERTHANLIGHT, MOREADVANCED

        switch (species.getTechnicalLevel()){
            case MOREADVANCED:
                return Person.Gender.OTHER;
            case FASTERTHANLIGHT:
            case GATEUSER:
                switch (new Random().nextInt(10)){
                    case 0:
                    case 1:
                        return Person.Gender.OTHER;
                    case 2:
                    case 3:
                        return Person.Gender.UNKNOWN;
                    case 4:
                    case 5:
                    case 6:
                        return Person.Gender.MALE;
                    case 7:
                    case 8:
                    case 9:
                        return Person.Gender.FEMALE;
                }
            default:
                switch (new Random().nextInt(10)) {
                    case 0:
                        return Person.Gender.OTHER;
                    case 1:
                        return Person.Gender.UNKNOWN;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return Person.Gender.MALE;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return Person.Gender.FEMALE;
                }
        }
        return null;
    }

    @Override
    public Person.Gender getGender() {
        return getGender(new Species("name", "desc", Intelligence.COMMON, TechnicalLevel.NONE, PlanetType.D, Climate.TROPICAL, new Planet())) ;
    }
}
