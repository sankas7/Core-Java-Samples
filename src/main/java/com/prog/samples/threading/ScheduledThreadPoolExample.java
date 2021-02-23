package com.prog.samples.threading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	
	
	public static void main(String args[]) throws InterruptedException
	{
		
         ScheduledExecutorService executor=Executors.newScheduledThreadPool(10);
         
         
         Worker worker=new Worker("task0");
         executor.schedule(worker, 5, TimeUnit.SECONDS);
         
         
         for(int i=2;i<5;i++)
         {
        	 Worker workerTest=new Worker("task"+i);
        	 executor.scheduleAtFixedRate(workerTest, 2, 10, TimeUnit.SECONDS);
         }
         
         for(int i=5;i<7;i++)
         {
        	 Worker workerTest=new Worker("task"+i);
        	 executor.scheduleWithFixedDelay(workerTest, 2, 2, TimeUnit.SECONDS);
         }
         
         
         Thread.sleep(5000 * 12);
         executor.shutdown();
         
         while(!executor.isTerminated())
         {
        	 
         }
         
         System.out.println("Operation Completed");
	}
	
	
	
}


class Worker implements Runnable
{

	
	private String taskName;
	public Worker(String name)
	{
		
		this.taskName=name;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread " + Thread.currentThread().getName() + " Running Task " +taskName + " Start Time" + new Date());
		try {
			processTask();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName() + "completed " +taskName + "  End Time " + new Date());
	}
	
	void processTask() throws InterruptedException
	{
		System.out.println("Running process " + this.taskName);
		Thread.sleep(2000);
	}
	
	
	
}