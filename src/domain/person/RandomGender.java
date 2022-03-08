package domain.person;

import java.util.Random;

//1.	Random, with a distribution as shown in the class Person.
public class RandomGender implements IGenderGenerator{
    @Override
    public Gender getGender(Species species) {
        return getGender();
    }

    @Override
    public Gender getGender() {
        Random r = new Random();
        if (r.nextInt(4) == 0) {
            return Gender.MALE;
        }
        if (r.nextInt(3) == 1) {
            return Gender.FEMALE;
        }
        if (r.nextInt(10) <= 8) {
            return Gender.UNKNOWN;
        }
        else {
            return Gender.OTHER;
        }
    }
}
