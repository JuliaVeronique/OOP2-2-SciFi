package domain.person;

public interface IGenderGenerator {
    Person.Gender getGender(Species species);
    Person.Gender getGender();
}
