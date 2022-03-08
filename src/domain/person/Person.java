package domain.person;

import domain.Observable;
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
		this.gender = randomGender("");
		this.species.addObserver(this);
	}

	public Person(String name, LocalDate dateOfBirth, String description, Species species, String howRandom) {
		super();
		Random r = new Random();
		this.ssn = r.nextLong();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.species = species;
		this.gender = randomGender(howRandom);

		this.species.addObserver(this);
	}

	public Person(String name, LocalDate dateOfBirth, String description, String howRandom) {
		super();
		Random r = new Random();
		this.ssn = r.nextLong();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.gender = randomGender(howRandom);

		this.species.addObserver(this);
	}

/*
	Implement the Strategy Design Pattern using one interface IGenderGenerator and three implementing classes.
	The first class does not need a Species parameter, the other two do.
	If no parameter is given just picking one of the three strategies at random with a random species is ok.
	Or do whatever creative thing you can think of, if the user doesn't know how to handle this situation any solution should be fine with him.
 */

	public Gender randomGender(String howRandom){
		try{
			if (howRandom.equals("tech")) return new GenderTechLevel().getGender(this.species);
			else if (howRandom.equals("climate")) return new GenderClimate().getGender(this.species);
			else return new RandomGender().getGender();
		} catch (Exception e) {
			if (howRandom.equals("tech")) return new GenderTechLevel().getGender();
			else if (howRandom.equals("climate")) return new GenderClimate().getGender();
			else return new RandomGender().getGender();
		}
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


	public enum Gender { MALE("M", "Gender producing the smaller reproductive cell"), 
		 				 FEMALE("F", "Gender producing the larger reproductive cell"), 
		 				 OTHER("O", "Catch-all for situations where the reproductive structure is unclear"), 
		 				 UNKNOWN("U", "We have'nt got the foggiest");
		private String abbreviation;
		private String description;
		
		private Gender(String abbreviation, String description) {
			this.abbreviation = abbreviation;
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
		
		public static Gender parse(String description) {
			if (description.toUpperCase().equals("M")) {
				return Gender.MALE;
			}
			if (description.toUpperCase().equals("F")) {
				return Gender.FEMALE;
			}
			if (description.toUpperCase().equals("O")) {
				return Gender.OTHER;
			}
			if (description.toUpperCase().equals("U")) {
				return Gender.UNKNOWN;
			}
			return null;
		}
	}
}

