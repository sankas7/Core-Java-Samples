package com.prog.samples.threading;

public class ThreadGroupExample {

	
	
	 public static void main(String[] args) throws InterruptedException {
	        ThreadGroup group = new ThreadGroup("GroupA");
	 
	        new Task(group, "A").start();
	        new Task(group, "B").start();
	        new Task(group, "C").start();
	        new Task(group, "D").start();
	 
	        Thread.sleep(10000);
	        
	       System.out.println("Active Threads"+group.activeCount());
	 
	        group.interrupt();
	 
	    }
	
}

class Task extends Thread {
    public Task(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }
 
    public void run() {
        boolean running = true;
 
        while (running) {
            try {
                System.out.println(getName() + " is running");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                running = false;
                System.out.println(getName() + " is interrupted and then terminates");
            }
        }
    }
}



