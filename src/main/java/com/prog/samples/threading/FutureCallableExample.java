package com.prog.samples.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableExample {

	
	public static void main(String args[]) throws InterruptedException
	{
		
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future> futures =new ArrayList<Future>();
		for(int i=1;i<21;i++)
		{
			Future future=service.submit(() -> 
			{
			System.out.println("Thread Name " +Thread.currentThread().getName());	
			return Thread.currentThread().getName();
			});
			futures.add(future);
		}
		
		
		Thread.sleep(5000);
		
	futures.forEach(future -> 
	{
		while(!future.isDone())
		{
			
		}
		try {
			System.out.println("Output - " +future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
	
	
		
	}
}


