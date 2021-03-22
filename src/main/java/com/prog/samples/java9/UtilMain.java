package com.prog.samples.java9;

public class UtilMain implements UtilInterface{

	
	public static void main(String args[])
	{
		UtilMain utilMain=new UtilMain();
		
		System.out.println("General Default using private method in interface " +utilMain.getNumberOfCore());
		
		System.out.println("General static method using private static  method in interface " +UtilInterface.getResult());
	}
}
