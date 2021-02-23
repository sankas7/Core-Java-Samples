package com.prog.samples.threading;

public class Transaction implements Runnable {
    private Bank bank;
    private int fromAccount;
 
    public Transaction(Bank bank, int fromAccount) {
        this.bank = bank;
 
 
        this.fromAccount = fromAccount;
    }
 
    public void run() {
 
       
            int toAccount = (int) (Math.random() * Bank.MAX_ACCOUNT);
 
            if(! (toAccount == fromAccount))
            {
 
            int amount = (int) (Math.random() * Bank.MAX_AMOUNT);
 
            if (amount != 0)
            {
 
            	try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }	
            bank.transfer(fromAccount, toAccount, amount);
 
            
            }
            }
        
    }
}

