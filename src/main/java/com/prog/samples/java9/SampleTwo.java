package com.prog.samples.java9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SampleTwo {

	
	public static void main(String args[])
	{
		List<Integer> ages = Arrays.asList(33, 44, 45, 66, 12, 23, 97);

		ages.stream().limit(5).filter(age -> age > 40).forEach(System.out::println);
		System.out.println("----------");
		ages.stream().skip(2).filter(age -> age > 40).forEach(System.out::println);
		System.out.println("----------");
		// Introduced in java 9
		ages.stream().takeWhile(age -> age < 60).forEach(System.out::println);
		System.out.println("----------");
		ages.stream().dropWhile(age -> age < 60).forEach(System.out::println);

		System.out.println("----------");
		IntStream.range(0, 5).forEach(System.out::println);
		System.out.println("----------");
		// Introduced in java 9
		IntStream.iterate(0, i -> i <= 5, i -> i + 2).forEach(System.out::println);
		System.out.println("----------");
		IntStream.iterate(0, i -> i + 2)
		.limit(4) // try with takewhile , drop while ,skip
		.forEach(System.out::println);
	}
}
