package domain.person;

import domain.planet.Climate;
import domain.planet.Planet;
import domain.planet.PlanetType;
import domain.planet.TechnicalLevel;

import java.util.Random;

//3.	Based on the TechnicalLevel of the species. If that is the highest from the list, the gender always is OTHER.
//    The next two levels (counting from the highest) have a random distribution of 20% other, 20% unknown, 30% male, 30% female.
//    The rest have 10% of other, 10% unknown, 40% male, 40% female.
public class GenderTechLevel implements IGenderGenerator{
    @Override
    public Gender getGender(Species species) {
//        NONE, STONE, BRONZE, IRON, RENAISSANCE, INDUSTRIAL, ELECTRIFIED, COMPUTERIZED, SPACEFARING, GATEUSER, FASTERTHANLIGHT, MOREADVANCED

        switch (species.getTechnicalLevel()){
            case MOREADVANCED:
                return Gender.OTHER;
            case FASTERTHANLIGHT:
            case GATEUSER:
                switch (new Random().nextInt(10)){
                    case 0:
                    case 1:
                        return Gender.OTHER;
                    case 2:
                    case 3:
                        return Gender.UNKNOWN;
                    case 4:
                    case 5:
                    case 6:
                        return Gender.MALE;
                    case 7:
                    case 8:
                    case 9:
                        return Gender.FEMALE;
                }
            default:
                switch (new Random().nextInt(10)) {
                    case 0:
                        return Gender.OTHER;
                    case 1:
                        return Gender.UNKNOWN;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return Gender.MALE;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return Gender.FEMALE;
                }
        }
        return null;
    }

    @Override
    public Gender getGender() {
        return getGender(new Species("name", "desc", Intelligence.COMMON, TechnicalLevel.NONE, PlanetType.D, Climate.TROPICAL, new Planet())) ;
    }
}
