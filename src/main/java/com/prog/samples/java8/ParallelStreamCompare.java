package com.prog.samples.java8;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamCompare {


  public static void main(String args[]) {


    List<Integer> listData = Arrays.asList(32, 44, 13, 31, 67, 56, 77, 55);



    TimeIt.code(() -> {
      listData.stream().filter(i -> i % 2 == 0).mapToInt(ParallelStreamCompare::compute).sum();
    });


    TimeIt.code(() -> {
      listData.parallelStream().filter(i -> i % 2 == 0).mapToInt(ParallelStreamCompare::compute)
          .sum();
    });



  }


  public static int compute(Integer i) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return i * 2;
  }
}


class TimeIt {
  public static void code(Runnable task) {
    long startTime = System.nanoTime();

    task.run();

    long endTime = System.nanoTime();

    System.out.println("Time Taken" + (endTime - startTime) / 1.0e9);


  }
}
