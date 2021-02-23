package com.prog.samples.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueExample {


  private static ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);

  public static void main(String args[]) throws InterruptedException {

    ExecutorService service = Executors.newFixedThreadPool(10);


    for (int i = 0; i < 20; i++) {
      service.execute(new ProducerThread(blockingQueue, "Prothread " + i));

      service.execute(new ConsumerThread(blockingQueue, "Conthread " + i));

    }


    Thread.sleep(20000);

    service.shutdown();

    while (!service.isTerminated()) {

      System.out.println("Doing");
    }

    System.out.println("Complete");
  }
}


class ProducerThread implements Runnable

{

  private ArrayBlockingQueue<String> blockingQueue;


  private static AtomicInteger candidate = new AtomicInteger(0);

  private String threadName;

  public ProducerThread(ArrayBlockingQueue<String> blockingQueue, String threadName) {
    this.blockingQueue = blockingQueue;
    this.threadName = threadName;
  }


  @Override
  public void run() {
    System.out.println("String Producer Thread " + threadName);
    try {
      blockingQueue.put("Candiate" + candidate.incrementAndGet());
      System.out.println("Candidate Added by " + threadName);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}


class ConsumerThread implements Runnable

{

  private ArrayBlockingQueue<String> blockingQueue;

  private String threadName;

  public ConsumerThread(ArrayBlockingQueue<String> blockingQueue, String threadName) {
    this.blockingQueue = blockingQueue;
    this.threadName = threadName;
  }


  @Override
  public void run() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("String Consumer Thread " + threadName);
    String candiate = blockingQueue.poll();
    System.out.println("Inteview for " + candiate + " scheduled by " + threadName);


  }

}


