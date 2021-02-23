package com.prog.samples.threading;

import java.util.Arrays;
import java.util.List;

public class VolatileThreading {

  private volatile static boolean dataFlag = false;


  public static void main(String args[]) throws InterruptedException {

    List<Integer> calculateList = Arrays.asList(3, 2, 4, 56, 4);
    Thread firstThread = new Thread(new Runnable() {

      @Override
      public void run() {

        if (calculateList.stream().filter(i -> i % 2 == 0).count() > 3) {
          System.out.println("Running" + Thread.currentThread().getName());
          dataFlag = true;
        }


      }

    });

    Thread secondThread = new Thread(() ->

    {
      while (!dataFlag) {
        System.out.println("Running" + Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });


    secondThread.setName("Second Thread");
    firstThread.setName("First Thread");

    secondThread.start();
    firstThread.start();


    firstThread.join();
    secondThread.join();
    System.out.println("Done");

  }
}
