package com.prog.samples.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedStream {

	
	public static void main(String args[])
	{
		List<Integer> listdata=IntStream.of(10,12,35,43,55).boxed().filter(i -> i%5==0).map(i -> i*2).collect(Collectors.toList());
		System.out.println(listdata);
	}
}
