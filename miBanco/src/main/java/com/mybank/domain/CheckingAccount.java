package com.mybank.domain;

public class CheckingAccount extends Account{
	
	private double overdraftAmount;

	public CheckingAccount(double initBalance, double overdraftAmount) {
		super(initBalance);
		this.overdraftAmount = overdraftAmount;
	}

	public CheckingAccount(double initBalance) {
		this(initBalance, 0.0);	
	}
	
	public boolean withdraw(double amt){ 
		boolean result = true;
		
		if ( balance < amt ) {
            double overdraftNeeded = amt - balance;
            if ( overdraftAmount < overdraftNeeded ) {                
                result = false;
            } else {                
                balance = 0.0;
                overdraftAmount -= overdraftNeeded;
            }            
        } else {
            balance = balance - amt;
        }        
        return result;
   }
	
	

}
