package com.prog.samples.threading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SyncronousQueueExample {

  public static void main(String args[]) throws InterruptedException {

    BlockingQueue<Integer> queueBlock = new SynchronousQueue<Integer>();

    ExecutorService services = Executors.newFixedThreadPool(30);

    IntStream.range(0, 10).forEach(
        number -> services.submit(new ProducerQueue("ProducerThread" + number, queueBlock)));


    IntStream.range(0, 10).forEach(
        number -> services.submit(new ConsumerQueue("ConsumerThread" + number, queueBlock)));



    services.shutdown();

    services.awaitTermination(10, TimeUnit.MINUTES);
  }



}


class ProducerQueue implements Runnable {

  private BlockingQueue<Integer> queueBlock;

  private String threadName;

  public ProducerQueue(String threadName, BlockingQueue<Integer> blockingQueue) {

    this.queueBlock = blockingQueue;
    this.threadName = threadName;

  }



  @Override
  public void run() {

    System.out.println("Producer Thread Started " + threadName);
    Random random = new Random();
    try {
      queueBlock.put(random.nextInt());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Produced by " + threadName);

  }



}


class ConsumerQueue implements Runnable {

  private BlockingQueue<Integer> queueBlock;

  private String threadName;

  public ConsumerQueue(String threadName, BlockingQueue<Integer> blockingQueue) {

    this.queueBlock = blockingQueue;
    this.threadName = threadName;

  }



  @Override
  public void run() {

    System.out.println("Consumer Thread Started " + threadName);
    try {
      System.out.println("Consumeed by thread : " + threadName + " Value " + queueBlock.take());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }



}
