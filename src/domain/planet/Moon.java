package domain.planet;

import domain.Body;
import domain.Coordinate;
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

	private void addBodyToUniverse(){
		Universe.getInstance().addMoon(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Planet getPlanet() {
		return planet.clone();
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	@Override
	public Coordinate getCoordinate() {
		return planet.getCoordinate();
	}
}
