package com.prog.samples.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

  public static void main(String args[]) {



    Thread answerThread = new Thread(() -> {
      CompletableFuture<Double> answer = getWeight().thenCombine(getheight(), (height, weight) -> {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return weight / (height * 2);
      });

      try {
        System.out.println("Answer is - " + answer.get());
      } catch (InterruptedException | ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    });


    answerThread.start();

    System.out.println("Main is done");

  }



  public static CompletableFuture<Integer> getWeight() {

    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return 56;

    });


  }



  public static CompletableFuture<Double> getheight() {

    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return 5.6;

    });


  }


}
