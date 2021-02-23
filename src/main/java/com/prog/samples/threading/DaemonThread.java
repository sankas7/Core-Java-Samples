package com.prog.samples.threading;

public class DaemonThread {
    public static void main(String[] args) {
        Thread userThread = new Thread(new Runnable() {
            public void run() {
                int x = 10;
 
                while (x > 0) {
                    System.out.println("User thread: " + x--);
 
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) { ex.printStackTrace(); }
                }
            }
        });
        userThread.start();
 
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("Daemon thread is running...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) { ex.printStackTrace(); }
 
                }
            }
        });
 
        daemonThread.setDaemon(true);
        daemonThread.start();
      
    }
}