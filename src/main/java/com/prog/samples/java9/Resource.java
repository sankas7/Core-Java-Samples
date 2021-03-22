package com.prog.samples.java9;

public class Resource implements AutoCloseable{

	
	public Resource()
	{
		System.out.println("Resource Created");
	}
	
	public void op1()
	{
		System.out.println("Resource Operation Done");
	}
	
	
	@Override
	public void close()  {
		System.out.println("Resource Closed");
		
	}

}
