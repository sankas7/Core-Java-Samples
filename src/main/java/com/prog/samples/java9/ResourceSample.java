package com.prog.samples.java9;

public class ResourceSample {

	
	public static void main(String args[])
	{
		Resource resource=new Resource();
		
		try(resource)
		{
			resource.op1();
		}
		
		System.out.println("Done");
		System.out.println(resource);
	}
}
