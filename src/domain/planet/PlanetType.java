package domain.planet;

import java.util.LinkedList;
import java.util.List;

public enum PlanetType { D("Moon", "An uninhabitable planetoid, moon, or small planet with little to no atmosphere", Habitability.TERRAFORMING),
						H("Bear", "Generally uninhabitable for Humans due to gravity or climate, might be suitable for other species", Habitability.MARGINALLY),
						J("Saturn", "Gas Giant with no nuclear fusion", Habitability.NO),
						K("Mars", "Adaptable for Humans by use of artificial biospheres", Habitability.BIOSPHERE),
						L("Soggy", "Marginally habitable, with vegetation but usually no animal life", Habitability.MARGINALLY),
						M("Gaia", "Earth-like, with atmospheres containing oxygen. Largely habitable for humanoid life forms.", Habitability.YES),
						G("Dead", "This planet once was habitable, but for some reason is completely dead and sterile now", Habitability.BIOSPHERE),
						N("Cania", "Moon or small planet with atmosphere but very low temperatures", Habitability.BIOSPHERE),
						R("Bikini", "Moon orbiting within heavy radiation of a gas giant", Habitability.NO),
						T("Cronos", "Gas giant with some nuclear fusion at its core", Habitability.NO),
						Y("Demon", "A world with a toxic atmosphere and surface temperatures exceeding 500 Kelvin. Prone to thermic and/ or radiation discharges.", Habitability.NO);
	private final String nickname;
	private final String description;
	private final Habitability habitability;

	private PlanetType(String nickname, String description, Habitability habitability) {
		this.nickname = nickname;
		this.description = description;
		this.habitability = habitability;
	}

	public String getNickname() {
		return nickname;
	}

	public String getDescription() {
		return description;
	}

	public Habitability getHabitability() {
		return habitability;
	}
	
	public static PlanetType parse(String description) {
		if (description.equals("D")) {
			return PlanetType.D;
		}
		if (description.equals("H")) {
			return PlanetType.H;
		}
		if (description.equals("J")) {
			return PlanetType.J;
		}
		if (description.equals("K")) {
			return PlanetType.K;
		}
		if (description.equals("L")) {
			return PlanetType.L;
		}
		if (description.equals("M")) {
			return PlanetType.M;
		}
		if (description.equals("N")) {
			return PlanetType.N;
		}
		if (description.equals("R")) {
			return PlanetType.R;
		}
		if (description.equals("T")) {
			return PlanetType.T;
		}
		if (description.equals("Y")) {
			return PlanetType.Y;
		}
		return null;
	}

	public enum Habitability { NO ("The planet is not habitable and cannot be made so by any known means."), 
								BIOSPHERE("Terraforming is impossible, but life can be sustained under an artificial biodome"), 
								TERRAFORMING ("Terraforming is possible, though probably expensive."), 
								MARGINALLY ("The planet is habitable, but will only be able to sustain a limited population."), 
								YES ("The planet is fully suitabable for habitation by humans and humanoid species without major modification."); 
		private final String description;
		
		private Habitability(String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return this.description;
		}
	}
	
	public static List<String> getDatabaseScript() {
		List<String> result = new LinkedList<>();
		
		result.add("CREATE TABLE habitability(level VARCHAR(255) PRIMARY KEY, description VARCHAR(255) NOT NULL);");
		Habitability[] habits = Habitability.values();
		for (Habitability c: habits) {
			result.add("INSERT INTO habitability(level, description) VALUES (\"" + c.toString() + "\", \"" + c.getDescription() + "\");");
		}
		
		result.add("CREATE TABLE planet_type(type VARCHAR(255) PRIMARY KEY, nickname VARCHAR(255), description VARCHAR(255) NOT NULL, habitability VARCHAR(255) NOT NULL);");
		PlanetType[] types = PlanetType.values();
		for (PlanetType c: types) {
			result.add("INSERT INTO planet_type(type, nickname, description, habitability) VALUES (\"" + c.toString() + "\",\"" + 
											c.getNickname() + "\",\"" + 
											c.getDescription() + "\", \"" +
											c.getHabitability().toString() + "\");");
		}
		return result;		
	}
}
