package domain.person;

public class Organization {
	private final long registrationNumber; 
	private String name; 
	private String description; 

	public Organization(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.registrationNumber = (long) (Math.random() * Long.MAX_VALUE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (registrationNumber ^ (registrationNumber >>> 32));
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
		Organization other = (Organization) obj;
		if (registrationNumber != other.registrationNumber)
			return false;
		return true;
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

	public long getRegistrationNumber() {
		return registrationNumber;
	}
}
