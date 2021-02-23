package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCollect {


  public static void main(String args[]) {


    List<Person> personList =
        Arrays.asList(new Person(23, "Pramit", "Kolkata"), new Person(24, "Rajesh", "Pune"),
            new Person(28, "Samir", "mumbai"), new Person(34, "Raju", "chennai"));
  
    System.out.println(
        personList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList()));


    System.out.println(personList.stream().filter(people -> people.getAge() > 20)
        .sorted((person, person2) -> person.getName().compareTo(person2.getName()))
        .collect(Collectors.toList()));



  }
}


class Person {


  private int age;
  private String name;
  private String city;



  @Override
  public String toString() {
    return "Person [age=" + age + ", name=" + name + ", city=" + city + "]";
  }


  public Person(int age, String name, String city) {
    super();
    this.age = age;
    this.name = name;
    this.city = city;
  }


  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
