package in.ram.in28minutes.versioning;

public class Name {

	private String firstName;
	private String secondName;
	private String lastname;

	public Name(String firstName, String secondName, String lastname) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastname = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", secondName=" + secondName + ", lastname=" + lastname + "]";
	}

}
