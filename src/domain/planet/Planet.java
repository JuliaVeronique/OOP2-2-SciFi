package domain.planet;

import java.util.HashSet;
import java.util.Set;

import domain.Body;
import domain.Coordinate;
import domain.Universe;
import domain.star.Star;

public class Planet extends Body implements Comparable<Planet>, Cloneable {
	private Star star;
	private int planetIndex;
	private PlanetType type;
	private float averageDistanceToStar; // in AU
	private float tilt = 0; // degrees relative to the plane of the star system
	private float excentricity; // in degrees
	private Set<Moon> moons;
	
	public Planet(String designation, String name, PlanetType type, Star star, int planetIndex, float averageDistanceToStar, float tilt,float excentricity) {
		super(designation, name);
		this.planetIndex = planetIndex;
		this.type = type;
		this.star = star;
		this.averageDistanceToStar = averageDistanceToStar;
		this.tilt = tilt;
		this.excentricity = excentricity;
		this.moons = new HashSet<>();
		addBodyToUniverse();
	}

	private void addBodyToUniverse(){
		Universe.getInstance().addPlanet(this);
	}


	@Override
	public Planet clone() {
		return new Planet(getDesignation(), getName(), type, star, planetIndex, averageDistanceToStar, tilt, excentricity);
	}
	
	@Override
	public int hashCode() {
		return (int) (this.longHashCode() % Integer.MAX_VALUE);
	}
	
	public long longHashCode() {
		long prime = 2031055211850435299l;
		long result = super.hashCode();
		result = prime * result + (long) Float.floatToIntBits(averageDistanceToStar);
		result = prime * result + (long) Float.floatToIntBits(excentricity);
		result = prime * result + ((star == null) ? 0 : star.longHashCode());
		result = prime * result + (long) Float.floatToIntBits(tilt);
		result = prime * result + ((type == null) ? 0 : (long) type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (this.getDesignation().equals(other.getDesignation())) {
			return true;
		}
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (planetIndex != other.planetIndex)
			return false;
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		return true;
	}

	public PlanetType getType() {
		return type;
	}

	public void setType(PlanetType type) {
		this.type = type;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public float getAverageDistanceToStar() {
		return averageDistanceToStar;
	}

	public float getTilt() {
		return tilt;
	}

	public float getExcentricity() {
		return excentricity;
	}
	
	@Override
	public Coordinate getCoordinate() {
		return star.getCoordinate();
	}
	
	public int getIndex() {
		return planetIndex;
	}

	@Override
	public String toString() {
		return "Planet [designation=" + this.getDesignation() + ", type=" + type + ", starType=" + star.getType() + ", averageDistanceToStar="
				+ averageDistanceToStar + "]";
	}

	@Override
	public int compareTo(Planet o) {
		if (!this.star.equals(o.star)) {
			return this.star.compareTo(o.star);
		}
		else {
			return this.planetIndex - o.planetIndex;
		}
	}
	
	public boolean addMoon(Moon moon) {
		return moons.add(moon);
	}
	
	public boolean removeMoon(Moon moon) {
		return moons.remove(moon);
	}
	
	public Set<Moon> getMoons() {
		Set<Moon> result = new HashSet<>();
		result.addAll(moons);
		return result;
	}
}
