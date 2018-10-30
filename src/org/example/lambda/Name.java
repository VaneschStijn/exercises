package org.example.lambda;

public class Name {

	private String first;

	private String last;

	@Override
	public String toString() {
		return first + " " + last;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
}
