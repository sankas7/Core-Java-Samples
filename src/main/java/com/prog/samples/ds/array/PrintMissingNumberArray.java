package com.prog.samples.ds.array;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

public class PrintMissingNumberArray {


  public static void main(String args[]) {



    printMissingNumber(new int[] {1, 2, 3, 5, 6, 7, 8}, 9);



  }

  private static void printMissingNumber(int[] integers, int i) {

    int missingCount = i - integers.length;


    BitSet bitset = new BitSet(i);
    IntStream.of(integers).forEach(integer -> bitset.set(integer - 1));


    System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(integers), i);
    int lastMissingIndex = 0;

    for (int j = 0; j < missingCount; j++) {
      lastMissingIndex = bitset.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }

  }
}
