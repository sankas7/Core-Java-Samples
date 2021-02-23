package com.prog.samples.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class VariableLambda {

	
	public static void main(String args[])
	{
		
		
		List<Integer> listData=new ArrayList<Integer>();
		
		listData.add(99);
		listData.add(44);
		listData.add(55);
		
		int toAdd=33;
		
		
		List<Integer> outerList=new ArrayList<Integer>();
		
		outerList.add(99);
		outerList.add(44);
		outerList.add(55);
	
		process(listData, data -> 
		{
		if(outerList.contains(99))
		{
	    System.out.println("Going");
		data.add(toAdd);
		}
	});

	
	}


	public static void process(List<Integer> listData, Consumer<List<Integer>> consumer)
	{
		
		consumer.accept(listData);
		
	}
}
