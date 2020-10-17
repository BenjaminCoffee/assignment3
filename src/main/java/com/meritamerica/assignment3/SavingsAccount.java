package com.meritamerica.assignment3;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This is the definition of the SavingsAccount Class.
 * This class simulates the savings account of an account holder.
 */
public class SavingsAccount extends BankAccount {
	
	private double interestRate = 0.01;
	
	public SavingsAccount() {
		super();
	}
	public SavingsAccount(double openingBalance) {
		super(openingBalance);
	}
	
	public SavingsAccount(double openingBalance, double interestRate) {
		super(openingBalance, interestRate);
	}
	
	public SavingsAccount(double openingBalance, double interestRate, Date date) {
		super(openingBalance, interestRate, date);
	}
	
	public SavingsAccount(long accountNumber, double openingBalance, double interestRate) {
		super(accountNumber, openingBalance, interestRate);
	}
	
	public SavingsAccount(long accountNumber, double openingBalance, double interestRate,
			Date date) {
		super(accountNumber, openingBalance, interestRate, date);
	}
	
	public static SavingsAccount readFromString(String string) {
		try {

			String[] strArray = string.split(",");

			long accountNumber = Long.valueOf(strArray[0]);
			double balance = Double.valueOf(strArray[1]);
			double interestRate = Double.valueOf(strArray[2]);
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = dateFormatter.parse(strArray[3]);

			// not needed for CheckingAccount
			//int term = Integer.valueOf(strArray[4]);
			
			return new SavingsAccount(accountNumber, balance, 
										interestRate, date);
			
		} catch (Exception e) {
			System.out.println("readFromString in CDAccount "
					+ "threw NumberFormatException");
			throw new NumberFormatException();
		}
	}
	
	
}