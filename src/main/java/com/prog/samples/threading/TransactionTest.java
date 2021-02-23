package com.prog.samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
 
        ExecutorService executors=Executors.newFixedThreadPool(10);
        for (int i = 0; i < Bank.MAX_ACCOUNT; i++) {
            
            executors.execute(new Transaction(bank, i));
           
        }
        
        executors.shutdown();
        
    }
}