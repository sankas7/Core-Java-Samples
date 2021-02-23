package com.prog.samples.threading;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class UncaughtExceptionHandlerTesting {

	
	public static void main(String args[]) throws InterruptedException
	{
		
		/*
		 * Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
		 * 
		 * @Override public void uncaughtException(Thread t, Throwable e) {
		 * System.out.println("Exception Occured " +" Thred Name " + t.getName() +
		 * e.getMessage());
		 * 
		 * }
		 * 
		 * });
		 */
		Thread threadCalculator=new Thread(new Calculator());
		threadCalculator.setName("CalThread");
		threadCalculator.start();
		Thread.sleep(1000);
		UncaughtExceptionHandler uncaughtHander=Thread.getDefaultUncaughtExceptionHandler();
	    System.out.println("Name " +uncaughtHander.getClass().getName());
	    
		Thread threadCalculator2=new Thread(new Calculator2());
		threadCalculator2.setName("CalThread2");
		threadCalculator2.start();
		Thread.sleep(1000);
		UncaughtExceptionHandler uncaughtHander2=Thread.getDefaultUncaughtExceptionHandler();
		System.out.println("Name 2 " +uncaughtHander2.getClass().getName());
		Thread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler(new UncaughtExceptionHandlerPair(uncaughtHander, uncaughtHander2)));
		threadCalculator.join();
		threadCalculator2.join();
	
		 
		System.out.println("Name 1 again " +uncaughtHander.getClass().getName());
		System.out.println("Main End");
		
		
	}
	
}
	
	
	 class Calculator implements Runnable
	{

		@Override
		public void run() {
			  Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler()
				{

					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println(" Root Exception Occured " +" Thred Name " + t.getName() + e.getMessage());
						
					}
			
				} );
			  System.out.println(Integer.parseInt("123"));
		      System.out.println(Integer.parseInt("234"));
		      System.out.println(Integer.parseInt("345"));
		      try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
		      System.out.println(Integer.parseInt("456"));
			
		}
		
	}
	 

	 class Calculator2 implements Runnable
	{

		@Override
		public void run() {
			  Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler()
				{

					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println(" Root Exception Occured In 2 " +" Thred Name " + t.getName() + e.getMessage());
						
					}
			
				} );
			  System.out.println(Integer.parseInt("123"));
		      System.out.println(Integer.parseInt("234"));
		      System.out.println(Integer.parseInt("345"));
		      try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      //System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
		      System.out.println(Integer.parseInt("456"));
		      System.out.println(1/0);
			
		}
		
	}
	 
	  class CustomUncaughtExceptionHandler  implements UncaughtExceptionHandler  {

			private final UncaughtExceptionHandler originalHandler;
			
			public CustomUncaughtExceptionHandler(UncaughtExceptionHandler originalHandler)
			{
				this.originalHandler=originalHandler;
			}
			
			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				
				
			
				if(throwable!=null &&
						Arrays.stream(throwable.getStackTrace()).anyMatch(i -> i.getClassName().equalsIgnoreCase("com.prog.samples.threading.Calculator2")))
				{
					System.out.println("Skipping System Exit for Cassandra Repair Exceptions");
				}
				
				else
				{
					originalHandler.uncaughtException(thread, throwable);
				}
				
			}
	  }
	  
	
