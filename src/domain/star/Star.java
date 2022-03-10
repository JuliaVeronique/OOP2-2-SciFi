package domain.star;

import domain.Body;
import domain.Coordinate;
import domain.Universe;
import domain.planet.Planet;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Star extends Body implements Comparable<Star>, Cloneable {
	private StarType type;
	private int temperatureSequence;
	private LuminosityClass luminosity;
	private float absoluteMagnitude;
	private Coordinate coordinate;
	private double goldilockZoneStart; //In AU
	private double goldilockZoneEnd; //In AU
	private double distanceToCiadan;
	private Star sister = null;
	private SortedSet<Planet> planets;

	public Star(String designation, String name, StarType type, int temperatureSequence, LuminosityClass luminosity, float absoluteMagnitude, double distance, double longitude, double latitude) {
		this(designation, name, type, temperatureSequence, luminosity, absoluteMagnitude, new Coordinate(distance, longitude, latitude));
		this.distanceToCiadan = calcDistanceToCiadan(distance, longitude, latitude);
	}
	
	public Star(String designation, String name, StarType type, int temperatureSequence, LuminosityClass luminosity,
			float absoluteMagnitude, double distance, double longitude, double latitude, double goldilockZoneStart, double goldilockZoneEnd, Star sister) {
		this(designation, name, type, temperatureSequence, luminosity, absoluteMagnitude, distance, longitude, latitude);
		this.sister = sister;
		this.distanceToCiadan = calcDistanceToCiadan(distance, longitude, latitude);
	}
	
	public Star(String designation, String name, StarType type, int temperatureSequence, LuminosityClass luminosity, float absoluteMagnitude, double distance, double longitude, double latitude, double goldilockZoneStart, double goldilockZoneEnd ) {
		super(designation, name);
		this.type = type;
		this.temperatureSequence = temperatureSequence;
		this.luminosity = luminosity;
		this.absoluteMagnitude = absoluteMagnitude;
		this.coordinate = new Coordinate(distance, longitude, latitude);
		this.goldilockZoneStart = goldilockZoneStart;
		this.goldilockZoneEnd = goldilockZoneEnd;
		this.planets = new TreeSet<>();
		this.distanceToCiadan = calcDistanceToCiadan(distance, longitude, latitude);
		addBodyToUniverse();
	}

	public Star(String designation, String name, StarType type, int temperatureSequence, LuminosityClass luminosity, float absoluteMagnitude, Coordinate coordinate) {
		super(designation, name);
		this.type = type;
		this.temperatureSequence = temperatureSequence;
		this.luminosity = luminosity;
		this.absoluteMagnitude = absoluteMagnitude;
		this.coordinate = coordinate;
		calculateGoldilockZone();
		this.distanceToCiadan = calcDistanceToCiadan(coordinate);
		this.planets = new TreeSet<>();
		addBodyToUniverse();
	}

	public void addBodyToUniverse(){
		Universe.getInstance().addBody(this);
	}

	public boolean addPlanet(Planet p) {
		if (planets == null) {
			planets = new TreeSet<>();
		}
		return planets.add(p);
	}
	
	@Override
	public Star clone() {
		return new Star(this.getDesignation(), this.getName(), this.type, this.temperatureSequence, this.luminosity, this.absoluteMagnitude, this.coordinate.getDistance(), this.coordinate.getLongitude(), this.coordinate.getLatitude(), this.goldilockZoneStart, this.goldilockZoneEnd);
	}
	
	public SortedSet<Planet> getPlanets() {
		SortedSet<Planet> result = new TreeSet<>();
		result.addAll(planets);
		return result;
	}

	public StarType getType() {
		return type;
	}

	public int getTemperatureSequence() {
		return temperatureSequence;
	}

	public LuminosityClass getLuminosity() {
		return luminosity;
	}

	public float getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public double getGoldilockZoneStart() {
		return goldilockZoneStart;
	}

	public double getGoldilockZoneEnd() {
		return goldilockZoneEnd;
	}
	
	public  Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
		this.distanceToCiadan = new Coordinate(21950f, 0.00d, 0.0d).calculateDistance(coordinate);
		this.notifyObservers();
	}

	public Star getSister() {
		return sister;
	}

	public void setSister(Star sister) {
		this.sister = sister;
		this.notifyObservers();
	}

	public double getDistanceToCiadan() {
		return distanceToCiadan;
	}

	public void setDistanceToCiadan(double distanceToCiadan) {
		this.distanceToCiadan = distanceToCiadan;
		this.notifyObservers();
	}

	private void calculateGoldilockZone() {
		double bc = absoluteMagnitude + getBC();
		double l = Math.pow(10, ((bc - 4.72)) / -2.5);
		goldilockZoneStart = Math.sqrt(l/1.1) / 100d;
		goldilockZoneEnd = Math.sqrt(l/0.53) / 100d;
	}
	
	private double getBC() {
		if (type == StarType.W) return -256;
		if (type == StarType.O) return -16;
		if (type == StarType.B) return -4;
		if (type == StarType.B) return -2;
		if (type == StarType.A) return -0.3;
		if (type == StarType.G) return -0.15;
		if (type == StarType.K) return -0.4;
		if (type == StarType.M) return -2;
		if (type == StarType.D) return -4;
		if (type == StarType.C) return -16;
		if (type == StarType.S) return -256;
		return 0;
	}

	@Override
	public int hashCode() {
		return (int) (this.longHashCode() % Integer.MAX_VALUE);
	}
	
	public long longHashCode() {
		final long prime = 4675813100949394889l;
		long result = super.hashCode();
		result = prime * result + ((coordinate == null) ? 0 : coordinate.longHashCode());
		result = prime * result + ((this.getDesignation() == null) ? 0 : (long) this.getDesignation().hashCode());
		result = prime * result + ((luminosity == null) ? 0 : (long) luminosity.hashCode());
		result = prime * result + temperatureSequence;
		result = prime * result + ((type == null) ? 0 : (long) type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Star other = (Star) obj;
		if (coordinate == null) {
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		if (luminosity != other.luminosity)
			return false;
		if (temperatureSequence != other.temperatureSequence)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	public static String randomDesignation(StarType type, Coordinate coordinate) {
		while (true) {
			int length = 0;
			StringBuilder text = null;
			if (type == StarType.W) {
				text = new StringBuilder("WR");
				length = 2;
			}
			else {
				text = new StringBuilder("");
				length = 4;
			}
			int firstUppercaseIndex = (int)'A'; // for uppercase
		    Random r = new Random(new Date().getTime());
			for (int i=0; i<length; i++) {
				int letterIndex = r.nextInt(26); // random number between 0 and 26
				char randomUppercase = (char) (firstUppercaseIndex + letterIndex);
				text.append(Character.toString(randomUppercase));
			}
			text.append("-");
			long code = coordinate.longHashCode();
			text.append(code);
			int index = text.indexOf("--");
			if (index > -1) {
				text.deleteCharAt(index);
			}
			String result = new String(text);
			if ((type == StarType.W) || (!result.startsWith("WR"))) {
				return result;
			}
		}
	}

	@Override
	public String toString() {
		return "Star [type=" + type + ", temperatureSequence=" + temperatureSequence + ", luminosity=" + luminosity
				+ ", absoluteMagnitude=" + absoluteMagnitude + ", coordinate=" + coordinate + ", goldilockZoneStart="
				+ goldilockZoneStart + ", goldilockZoneEnd=" + goldilockZoneEnd + ", distanceToCiadan="
				+ distanceToCiadan + ", sister=" + sister + "]";
	}

	@Override
	public int compareTo(Star o) {
		return this.getDesignation().compareTo(o.getDesignation());
	}
	
	public static double calcDistanceToCiadan(double distance, double longitude, double latitude) {
		return calcDistanceToCiadan(new Coordinate(distance, longitude, latitude));
	}
	
	public static double calcDistanceToCiadan(Coordinate coordinate) {
		return new Coordinate(10951.618d, 0.0447d, 0.0041d).calculateDistance(coordinate);
	}


	@Override
	public String getIdentity() {
		return this.toString();
	}

	@Override
	public BigInteger getMass() {
		BigInteger totalMass = this.getWeight();
		this.planets.forEach(planet -> totalMass.add(planet.getMass()));
		return totalMass;
	}
}
