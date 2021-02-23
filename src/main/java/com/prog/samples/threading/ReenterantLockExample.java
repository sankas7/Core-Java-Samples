
package com.prog.samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockMethodsCounter {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public void incrementAndGet() throws InterruptedException {
        // Check if the lock is currently acquired by any thread
        System.out.println("IsLocked : " + lock.isLocked());

        // Check if the lock is acquired by the current thread itself.
        System.out.println("IsHeldByCurrentThread : " + lock.isHeldByCurrentThread());

        // Try to acquire the lock
        boolean isAcquired = lock.tryLock(40000,TimeUnit.MILLISECONDS);
        
       
        System.out.println("Lock Acquired : " + isAcquired + "\n");

        if(isAcquired) {
            try {
                Thread.sleep(2000);
                System.out.println("IncrementCount ("+Thread.currentThread().getName()+") : " +
                        increment() + "\n");
            } finally {
                lock.unlock();
            }
        }
        
    }
    
    
    public int increment()
    {
    	count = count + 1;
    	return count;
    }
}




public class ReenterantLockExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter();

        
        for(int i =0;i<10;i++)
        {
        	executorService.submit(() -> {
				try {
					lockMethodsCounter.incrementAndGet();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
        }
        
       Thread.sleep(60000);
        executorService.shutdown();
    }
}