package domain.person;

import java.util.Random;

//1.	Random, with a distribution as shown in the class Person.
public class RandomGender implements IGenderGenerator{
    @Override
    public Person.Gender getGender(Species species) {
        return getGender();
    }

    @Override
    public Person.Gender getGender() {
        Random r = new Random();
        if (r.nextInt(4) == 0) {
            return Person.Gender.MALE;
        }
        if (r.nextInt(3) == 1) {
            return Person.Gender.FEMALE;
        }
        if (r.nextInt(10) <= 8) {
            return Person.Gender.UNKNOWN;
        }
        else {
            return Person.Gender.OTHER;
        }
    }
}
