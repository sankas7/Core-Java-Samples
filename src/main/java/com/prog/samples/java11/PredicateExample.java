package com.prog.samples.java11;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String args[])
	{
		List<String> empNames=List.of("Raja","Rami","Pramit","Alok");
		Predicate<String> namesWithR=emp -> emp.startsWith("R");
		empNames.stream().filter(namesWithR).forEach(System.out::println);
		empNames.stream().filter(namesWithR.negate()).forEach(System.out::println);
		empNames.stream().filter(Predicate.not(namesWithR)).forEach(System.out::println);
		
	}
	
}
