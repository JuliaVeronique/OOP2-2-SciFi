package domain.person;

import domain.Observer;

import java.time.LocalDate;
import java.util.Random;


public class Person implements Observer {
    private final long ssn;
    private String name;
    private LocalDate dateOfBirth;
    private String description;
    private Species species;
    private Gender gender;

    public Person(String name, LocalDate dateOfBirth, String description, Species species) {
        super();
        Random r = new Random();
        this.ssn = r.nextLong();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
        this.species = species;
        this.gender = randomGender(this.howRandom());
        this.species.addObserver(this);
    }

    public Person(String name) {
        this.name = name;
        this.ssn = 0;
//		this.species = species;

        this.species.addObserver(this);
    }

    public Person(String name, LocalDate dateOfBirth, String description) {
        super();
        Random r = new Random();
        this.ssn = r.nextLong();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
        this.gender = randomGender(this.howRandom());

        this.species.addObserver(this);
    }

/*
	Implement the Strategy Design Pattern using one interface IGenderGenerator and three implementing classes.
	The first class does not need a Species parameter, the other two do.
	If no parameter is given just picking one of the three strategies at random with a random species is ok.
	Or do whatever creative thing you can think of, if the user doesn't know how to handle this situation any solution should be fine with him.
 */

    public Gender randomGender(String howRandom) {
        try {
            if (howRandom.equals("tech")) return new GenderTechLevel().getGender(this.species);
            else if (howRandom.equals("climate")) return new GenderClimate().getGender(this.species);
            else return new RandomGender().getGender();
        } catch (Exception e) {
            if (howRandom.equals("tech")) return new GenderTechLevel().getGender();
            else if (howRandom.equals("climate")) return new GenderClimate().getGender();
            else return new RandomGender().getGender();
        }
    }

    public String howRandom() {
        if (this.dateOfBirth.equals(null)) {
            Random r = new Random();
            LocalDate dateOfBirth = LocalDate.of(r.nextInt(1930, 2022), r.nextInt(1, 13), r.nextInt(1, 32));
            this.dateOfBirth = dateOfBirth;
        }
        if (this.dateOfBirth.isLeapYear()) {
            return "tech";
        }
        return "climate";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getSsn() {
        return ssn;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void update() {
        System.out.println(this.species.getIdentity());
    }

    @Override
    public void update(String arg) {
        System.out.println(this.species.getIdentity());
    }

}

