package com.zipcode.macrolabs.atm.exceptions;

public class TransactionAmountIsZeroException extends Exception{

    public TransactionAmountIsZeroException(){
        System.out.println("Please don't waste our time with $0.00 transactions.");
    }

}
