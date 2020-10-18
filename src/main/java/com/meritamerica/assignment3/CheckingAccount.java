package com.meritamerica.assignment3;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This is the definition of the CheckingAccount class.
 * This class simulates the checking account of an account holder
 * within a banking application.
 */
public class CheckingAccount extends BankAccount {
	
	private double interestRate = 0.0001;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(double openingBalance) {
		super(openingBalance);
	}
	
	public CheckingAccount(double openingBalance, double interestRate) {
		super(openingBalance, interestRate);
	}
	
	public CheckingAccount(long accountNumber, double openingBalance, double interestRate) {
		super(accountNumber, openingBalance, interestRate);
	}
	
	public CheckingAccount(long accountNumber, double openingBalance, double interestRate,
			Date date) {
		super(accountNumber, openingBalance, interestRate, date);
	}
	
	public static CheckingAccount readFromString(String string) {
		try {

			String[] strArray = string.split(",");

			long accountNumber = Long.valueOf(strArray[0]);
			double balance = Double.valueOf(strArray[1]);
			double interestRate = Double.valueOf(strArray[2]);
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = dateFormatter.parse(strArray[3]);

			// not needed for CheckingAccount
			//int term = Integer.valueOf(strArray[4]);
			
			return new CheckingAccount(accountNumber, balance, 
										interestRate, date);
			
		} catch (Exception e) {
			System.out.println("readFromString in CDAccount "
					+ "threw NumberFormatException");
			throw new NumberFormatException();
		}
	}
	
	public double futureValue(int years) {
		return getBalance() * (Math.pow(1 + interestRate, years));
	}
	
}