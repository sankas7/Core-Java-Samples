package com.prog.samples.threading;

import java.text.SimpleDateFormat;

public class ThreadLocalExample implements Runnable {
	
	private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd/mm/yyyy"));
	
	
	

	@Override
	public void run() {
		System.out.println("Thread running " + Thread.currentThread().getName() + " fomat value" + formatter.get().toLocalizedPattern());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formatter.set(new SimpleDateFormat("yyyy/MM/dd"));
		
		System.out.println("Thread running " + Thread.currentThread().getName() + " fomat value" + formatter.get().toLocalizedPattern());
	}
	
	
	
	public static void main(String args[])
	{
		ThreadLocalExample example=new ThreadLocalExample();
		
		for(int i=0;i<10;i++)
		{
			Thread formatThread=new Thread(example, "Thread"+i);
			formatThread.start();
	    }
		
		
		
		
		
		
		

}
}
