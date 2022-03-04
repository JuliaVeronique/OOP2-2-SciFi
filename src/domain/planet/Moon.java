package domain.planet;

import domain.Body;
import domain.Coordinate;
import domain.Observer;
import domain.Universe;

public class Moon extends Body {
	private String name;
	private Planet planet;
	
	public Moon(String designation, String name, String name2, Planet planet) {
		super(designation, name);
		name = name2;
		this.planet = planet;
		addBodyToUniverse();
	}

	public void addBodyToUniverse(){
		Universe.getInstance().addBody(this);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.notifyObservers();
	}

	public Planet getPlanet() {
		return planet.clone();
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
		this.notifyObservers();
	}

	@Override
	public Coordinate getCoordinate() {
		return planet.getCoordinate();
	}


	@Override
	public String getIdentity() {
		return this.toString();
	}
}
