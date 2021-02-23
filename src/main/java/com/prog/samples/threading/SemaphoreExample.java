package com.prog.samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {


  public static void main(String args[]) throws InterruptedException {

    ExecutorService tasks = Executors.newCachedThreadPool();

    for (int i = 0; i < 100; i++) {
      tasks.submit(() -> Connection.getInstance().connect());
    }

    tasks.shutdown();

    tasks.awaitTermination(5, TimeUnit.MINUTES);

  }
}



class Connection {

  private Semaphore semaphore = new Semaphore(10, true);

  private int count = 0;

  private static Connection connection = new Connection();

  public static Connection getInstance() {
    return connection;
  }


  public void connect() {
    try {
      semaphore.acquire();
      doConnect();
    } catch (InterruptedException e) {

      e.printStackTrace();
    }

    finally {
      semaphore.release();
    }
  }


  private void doConnect() throws InterruptedException {



    synchronized (this) {

      count++;
      System.out.println("Connection happed - " + count);
    }

    Thread.sleep(2000);


    synchronized (this) {

      count--;

    }

  }

}
