package domain.planet;

import java.io.Serializable;

import domain.star.Star;


public class KnownPlanet extends Planet implements Serializable {
	private static final long serialVersionUID = 1915169057063985758L;
	private double population;
	private String description;
	private TechnicalLevel technicalLevel;

	public KnownPlanet(String designation, String name, PlanetType type, Star star, int planetIndex,
			float averageDistanceToStar, float tilt, float excentricity, double population, String description,
			TechnicalLevel technicalLevel) {
		super(designation, name, type, star, planetIndex, averageDistanceToStar, tilt, excentricity);
		this.population = population;
		this.description = description;
		this.technicalLevel = technicalLevel;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}
	
	public TechnicalLevel getTechnicalLevel() {
		return technicalLevel;
	}

	public void setTechnicalLevel(TechnicalLevel technicalLevel) {
		this.technicalLevel = technicalLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public KnownPlanet clone() {
		return new KnownPlanet(getDesignation(), getName(), getType(), getStar(), getIndex(),getAverageDistanceToStar(), 
				getTilt(), getExcentricity(), population, description, technicalLevel);
	}
}
