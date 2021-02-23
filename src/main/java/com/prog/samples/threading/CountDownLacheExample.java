package com.prog.samples.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLacheExample {

  public static void main(String args[]) {

    CountDownLatch latch = new CountDownLatch(10);

    ExecutorService task = Executors.newCachedThreadPool();
    IntStream.range(0, 10).forEach(number -> {

      task.execute(() -> {

        System.out.println("Developer Thread Started " + number);

        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        latch.countDown();

        System.out.println("Developer Thread completed " + number);
      });
    });



    task.execute(() -> {
      System.out.println(
          "QA Thread Started will work once all dev tasks are completed - " + System.nanoTime());
      try {
        latch.await();
      } catch (InterruptedException e) {

        e.printStackTrace();
      }

      System.out.println("QA done - " + System.nanoTime());

    });

  }
}
