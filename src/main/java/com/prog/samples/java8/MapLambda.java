package com.prog.samples.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapLambda {


  public static void main(String args[]) {


    Map<String, String> sortMap = new HashMap<String, String>();

    sortMap.put("Data", "Data1");
    sortMap.put("Data2", "Data2");
    sortMap.put("Data3", "Data3");


    for (Map.Entry<String, String> entry : sortMap.entrySet()) {
      System.out.println(entry.getKey() + "-" + entry.getValue());
    }

    sortMap.forEach((s1, s2) -> System.out.println(s1 + s2));



    List<Person> personList =
        Arrays.asList(new Person(23, "Pramit", "Kolkata"), new Person(24, "Rajesh", "Pune"),
            new Person(28, "Samir", "mumbai"), new Person(34, "Raju", "chennai"));


    Map<String, Person> mapData = personList.stream().filter(person -> person.getAge() > 20)
        .sorted(Comparator.comparing(Person::getCity))
        .collect(Collectors.toMap(person -> person.getName(), person -> person));

    System.out.println(mapData);
  }
}
