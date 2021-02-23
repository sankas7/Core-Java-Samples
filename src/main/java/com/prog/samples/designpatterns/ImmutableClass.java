package com.prog.samples.designpatterns;

import java.util.HashMap;


public final class ImmutableClass {

	private final String description;
	private final int count;
	private final HashMap<String,String> valueMap;
	
	
	public ImmutableClass(String description,int count,HashMap<String,String> valueMap)
	{
		
		HashMap<String,String> valueMapCopy =new HashMap<String, String>();
		
		this.description=description;
		this.count=count;
		
		valueMap.forEach((key,value) -> valueMapCopy.put(key, value));
		this.valueMap=valueMapCopy;
		
	}
	

	public String getDescription() {
		return description;
	}


	public int getCount() {
		return count;
	}


	public HashMap<String, String> getValueMap() {
		return (HashMap<String, String>) valueMap.clone();
		
	}
	
	
	public static void main(String args[])
	{
		HashMap<String,String> addMap=new HashMap<String, String>();
		addMap.put("key1", "val1");
		addMap.put("key2", "val2");
		String desString="this is test";
		int count =1;
		ImmutableClass testClass=new ImmutableClass(desString, count, addMap);
		
	
		System.out.println(testClass.getDescription() == desString);
		System.out.println(testClass.getDescription().equals(desString));
		
		System.out.println(addMap == testClass.getValueMap());

		System.out.println(addMap.equals(testClass.getValueMap()));
		
		System.out.println("Description" + testClass.getDescription());
		System.out.println("Count" + testClass.getCount());
		System.out.println("Map " + testClass.getValueMap());
		
		addMap.put("key3", "value3");
		
		System.out.println("Map " + testClass.getValueMap());
		
		
		HashMap<String, String> strMap=testClass.getValueMap();
		strMap.put("newkey", "newval");
		System.out.println("Map " + testClass.getValueMap());
		
	}

	
}
