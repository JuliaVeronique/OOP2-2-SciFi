package domain.person;

import domain.planet.Climate;
import domain.planet.Planet;
import domain.planet.PlanetType;
import domain.planet.TechnicalLevel;


public class Species {
	private String name;
	private String description;
	private Intelligence intelligence; // The common level of intelligence of a species. This does not preclude individuals having it lower or higher.
	private TechnicalLevel technicalLevel;
	private PlanetType preferredPlanetType;
	private Climate preferredClimate;
	private Planet planetOfOrigin;

	public Species(String name, String description, Intelligence intelligence, TechnicalLevel technicalLevel,
			PlanetType preferredPlanetType, Climate preferredClimate, Planet planetOfOrigin) {
		super();
		this.name = name;
		this.description = description;
		this.intelligence = intelligence;
		this.technicalLevel = technicalLevel;
		this.preferredPlanetType = preferredPlanetType;
		this.preferredClimate = preferredClimate;
		this.planetOfOrigin = planetOfOrigin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Species [name=" + name + ", description=" + description + ", planetOfOrigin=" + planetOfOrigin + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Planet getPlanetOfOrigin() {
		return planetOfOrigin;
	}

	public void setPlanetOfOrigin(Planet planetOfOrigin) {
		this.planetOfOrigin = planetOfOrigin;
	}

	public TechnicalLevel getTechnicalLevel() {
		return technicalLevel;
	}

	public void setTechnicalLevel(TechnicalLevel technicalLevel) {
		this.technicalLevel = technicalLevel;
	}

	public Intelligence getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Intelligence intelligence) {
		this.intelligence = intelligence;
	}

	public PlanetType getPreferredPlanetType() {
		return preferredPlanetType;
	}

	public void setPreferredPlanetType(PlanetType preferredPlanetType) {
		this.preferredPlanetType = preferredPlanetType;
	}

	public Climate getPreferredClimate() {
		return preferredClimate;
	}

	public void setPreferredClimate(Climate preferredClimate) {
		this.preferredClimate = preferredClimate;
	}
}
