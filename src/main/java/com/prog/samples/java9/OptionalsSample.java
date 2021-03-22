package com.prog.samples.java9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalsSample {

	
	public static void main(String args[])
	{
		
		IntStream.of(2,3,4,5,6,7).filter(number -> number > 4)
		.findFirst()
		.ifPresent(number -> System.out.println(number +" is present"));
		
		System.out.println(IntStream.of(2,3,4,5,6,7).filter(number -> number > 40)
		.findFirst()
		.orElse(0));
		
		
		//New in Java 9
		
		IntStream.of(2,3,4,5,6,7).filter(number -> number >10)
		.findFirst()
		.ifPresentOrElse(number -> System.out.println(number +" is present"), () -> System.out.println("Not present"));
		
		
		List<Integer>  listInt=Arrays.asList(2,3,4,5,6,9);
		
		Optional<Integer> optInt=listInt.stream().filter(number -> number >10)
		.findFirst().or( () -> Optional.of(0));
		
		System.out.println("Value" +optInt.get());
		
		process(listInt.stream().filter(number -> number >10)
		.findFirst()
		.stream());
		
		System.out.println("done");
	}
	
	
	public static void process(Stream<Integer> stream)
	{
		stream.forEach(System.out::println);
	}
}
