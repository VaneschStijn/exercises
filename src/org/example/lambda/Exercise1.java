package org.example.lambda;

import java.util.List;

public class Exercise1 {

	public static void main(String[] args) {
		List<Person> people = JsonUtil.readJsonFile();

		for (Person person : people) {
			System.out.println(person.toString());
		}

		// 1. Filter out Persons with a First name starting with L
		// 2. create a Filter interface that returns true or false for a Person
		// 3. extract for loop to other method that has the Filter as a parameter
		// 4. refactor to lambda
		// 5. use java functional interfaces Predicate and add Consumer to log person to out
	}

}
