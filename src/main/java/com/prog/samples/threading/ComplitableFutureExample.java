package com.prog.samples.threading;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplitableFutureExample {

	
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{
		
		
	CompletableFuture<String> greetingTask=	CompletableFuture.supplyAsync(() -> {
			
			try {
				System.out.println("Thread running - " +Thread.currentThread().getName()+ " Time - " +Instant.now());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Hello";
		}
		).thenApply((greetings) -> {
			
			try {
				System.out.println("Thread running - " +Thread.currentThread().getName()+ " Time - " +Instant.now());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return greetings + "Pramit";
		}).thenApply((name) -> {
			try {
				System.out.println("Thread running - " +Thread.currentThread().getName()+ " Time - " +Instant.now());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name + " How r you?";
		});
		
	
	Thread.sleep(5000);
	
	System.out.println("Answer " +greetingTask.get());
	
	}
}
