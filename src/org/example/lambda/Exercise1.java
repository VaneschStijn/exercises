package org.example.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise1 {

    public static void main(String[] args) {
        List<Person> people = JsonUtil.readJsonFile();

        for (Person person : people) {
            System.out.println(person.toString());
        }

        // 1. Filter out Persons with a First name starting with L
        // Before Generics we would make use of a For/foreach loop
        System.out.println();
        System.out.println("---- Vraag1 ----");
        //For-loop
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().getFirst().startsWith("L")) {
                System.out.println(people.get(i));
            }
        }

        System.out.println();
        //Foreach-loop
        for (Person person : people) {
            if (person.getName().getFirst().startsWith("L")) {
                System.out.println(person);
            }
        }

        // 2. create a Filter interface that returns true or false for a Person
        // First step to creating Reusage for different names, atributes, settings, ...

        // 3. extract for loop to other method that has the Filter as a parameter
        // Implementing the Filter interface as an Anonymous inner class given to the checkPerson-method as argument
        // Also see the checkPerosn-method outside of the psvm
        System.out.println();
        System.out.println("---- Vraag3 ----");

        Filter personStartWithLFilter = new Filter() {
            @Override
            public boolean check(Person person) {
                if (person.getName().getFirst().startsWith("L")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        checkPerson(personStartWithLFilter, people);

        // 4. refactor to lambda
        System.out.println();
        System.out.println("---- Vraag4 ----");

        Filter personStartWithLLambdaFilter = person -> person.getName().getFirst().startsWith("L");

        checkPerson(personStartWithLLambdaFilter, people);

        // 5. use java functional interfaces Predicate and add Consumer to log person to out
        System.out.println();
        System.out.println("---- Vraag5 ----");

        Predicate<Person> personStartWithLPredicateFilter = person -> person.getName().getFirst().startsWith("L");
        Consumer<Person> personStandardOutput = System.out::println;

        checkPersonForQuestion5(personStartWithLPredicateFilter, personStandardOutput, people);
    }

    public static void checkPerson(Filter filter, List<Person> people) {
        for (Person person : people) {
            if (filter.check(person)) {
                System.out.println(person);
            }
        }
    }

    public static void checkPersonForQuestion5(Predicate<Person> filter, Consumer<Person> output, List<Person> people) {
        for (Person person : people) {
            if (filter.test(person)) {
                output.accept(person);
            }
        }
    }
}
