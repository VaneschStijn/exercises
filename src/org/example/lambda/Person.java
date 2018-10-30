package org.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {

	private Name name;
	private String company;
	private List<String> tags;

	public Name getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return name.toString() + " - " + company + " - " + Arrays.toString(tags.toArray());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
