package io.zihaocastine;


import java.util.Date;

/**
 * Created by zihaocastine on 5/3/16.
 */
public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private Account sourceAccount;
    private Account destinationAccount;
    private Date timeStamp;
    private String FTN;
    public enum TransactionType{
        WITHDRAWALS, DEPOSITS, TRANSFERS
    }

    Transaction(TransactionType transactionType, double amount, Account sourceAccount, Account destinationAccount){
        this.transactionType=transactionType;
        this.amount=amount;
        this.sourceAccount=sourceAccount;
        this.destinationAccount=destinationAccount;
        //timeStamp=new Date();
    }

    public void makeTransaction(){
        switch (transactionType){
            case WITHDRAWALS:
                if (sourceAccount.debit(amount)){
                    timeStamp=new Date();
                    sourceAccount.setRecord("Withdrawal " +amount+" time: "+timeStamp);
                }else {
                    System.out.println("Transaction fail");
                    sourceAccount.setRecord("Withdrawal fail, time: "+timeStamp);
                }
                break;
            case DEPOSITS:
                sourceAccount.credit(amount);
                timeStamp=new Date();
                sourceAccount.setRecord("Deposit " +amount);
                break;
            case TRANSFERS:
                if(destinationAccount.getAccountName()!="null"){
                    if (sourceAccount.debit(amount)){
                        timeStamp=new Date();
                        sourceAccount.setRecord("Withdrawal " +amount+", time: "+timeStamp);
                        destinationAccount.credit(amount);
                        sourceAccount.setRecord("Transfer "+amount+" to "+destinationAccount.getAccountName());
                        destinationAccount.setRecord(amount+" transfer from  "+sourceAccount.getAccountName());
                    }else {
                        System.out.println("Transaction fail");
                        sourceAccount.setRecord("Transfer fail, time: "+timeStamp);
                    }

                }
                break;
            default:System.out.println("makeTransaction error");
        }
    }





}
