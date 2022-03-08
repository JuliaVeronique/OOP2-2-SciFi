package domain.person;

public interface IGenderGenerator {
    Gender getGender(Species species);
    Gender getGender();
}
