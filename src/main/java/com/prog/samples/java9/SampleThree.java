package com.prog.samples.java9;

import java.util.List;
import java.util.Map;

public class SampleThree {

	
	public static void main(String args[])
	{
		List<Integer> intList=List.of(1,2,4,5,6,7);
		
		System.out.println("Class :" + intList.getClass());
		
		//cant add new value to it as list returned is immutable
		//intList.add(12);
		
		
		Map<String,Integer> dataMap=Map.of("a",1,"b",2,"c",3);
		
		dataMap.forEach((k,v) -> System.out.println(" Key is "+ k + " value is " +v));
		
		
	}
}
