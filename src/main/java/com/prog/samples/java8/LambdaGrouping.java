package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaGrouping {

	
	public static void main(String args[])
	{
		List<Person> personList=Arrays.asList(new Person(23,"Pramit","Kolkata"),new Person(24,"Rajesh","Pune"),
				new Person(28,"Samir","mumbai"),new Person(34,"Raju","chennai"),new Person(43,"Kamal","Hyderabad"),new Person(47,"Sanjib","mangalore"),
				new Person(45,"Sanjib","deradun"));
		
		
		System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getName)));
		
	
		System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getName,Collectors.mapping(Person::getAge, Collectors.toList()))));
	}
}
