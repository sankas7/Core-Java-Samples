package com.prog.samples.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaSorting {


  public static void main(String args[]) {

    List<Person> personList =
        Arrays.asList(new Person(44, "Rajen", "Patna"), new Person(23, "Pramit", "Kolkata"),
            new Person(24, "Rajesh", "Pune"), new Person(28, "Samir", "mumbai"),
            new Person(34, "Raju", "chennai"), new Person(34, "Kumar", "durgapur"));


    personList = personList.stream()
        .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getCity))
        .collect(Collectors.toList());
    System.out.println(personList);


    personList.sort(LambdaSorting::compareByNameThenAge);
    System.out.println(personList);

    List<Person> reverseSortedList =
        personList.stream().sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder()))
            .collect(Collectors.toList());

    System.out.println(reverseSortedList);

    List<Person> nullList =
        Arrays.asList(null, new Person(24, "Rajesh", "Pune"), new Person(28, "Samir", "mumbai"),
            new Person(34, "Raju", "chennai"), new Person(34, "Kumar", "durgapur"));

    nullList = nullList.stream().sorted(Comparator.nullsLast(Comparator.comparing(Person::getName)))
        .collect(Collectors.toList());
    System.out.println(nullList);
  }

  public static int compareByNameThenAge(Person lhs, Person rhs) {
    if (lhs.getName().equals(rhs.getName())) {
      return lhs.getAge() - rhs.getAge();
    } else {
      return lhs.getName().compareTo(rhs.getName());
    }
  }
}
