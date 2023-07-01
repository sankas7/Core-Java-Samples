package com.prog.samples.java10;

import java.util.HashMap;

public class VarExample {


	public static void main(String args[])
	{
		var i=10;
		
		i=22;
		
		var tMap=new HashMap<String,String>();
		tMap.put("dd", "data");
		tMap.put("ee", "eeee");
		
		
		for(var entry:tMap.entrySet())
		{
			System.out.println(entry.getKey() + " " + entry.getValue());
			welcome(entry.getKey());
		}
	}

	private static <T> void welcome(T key) {
	
		System.out.println(key);
	}
}
