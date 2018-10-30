package org.example.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise2 {

	public static void main(String[] args) {
		List<Person> people = JsonUtil.readJsonFile();

		search(people, p -> p.getName().getFirst().startsWith("L"), p -> System.out.println( p.getName().toString()));

		// 1. rewrite to use stream
		// 2. extract names as a list
		// 3. extract tags as an ordered set


	}

	private static void search(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}


}
