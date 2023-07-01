package com.prog.samples.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CopyOfFuncCollections {

	
	public static void main(String args[])
	{
		List<String> testList=new ArrayList<>();
		
		testList.add("Rama");
		testList.add("Raju");
		testList.add("Kolar");
		
		//Collectors.toUnmodifiableList is new introduced
		List<String> rList=testList.stream().filter(str -> str.startsWith("R")).collect(Collectors.toUnmodifiableList());
		
		List<String> dataList=List.copyOf(testList);
		
		testList.add("New");
		
		System.out.println(dataList);
		
		dataList.add("not allowed");
		

		
	
	}
}
