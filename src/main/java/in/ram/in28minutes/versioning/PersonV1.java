package in.ram.in28minutes.versioning;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonV1 {

	@JsonProperty("user_name")
	private String name;

	public PersonV1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
