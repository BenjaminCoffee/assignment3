package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {

	private CDOffering offering;
	private double balance;
	private Date startDate;

	public CDAccount(CDOffering offering, double balance, 
			long accountNumber, Date date) {
		super(accountNumber, balance, date);
		
		this.offering = offering;
		//this.balance = balance;
		//this.startDate = date;
		//this.accountNumber = accountNumber;
	}
	public CDAccount(CDOffering offering, double balance) {
		this.startDate = new Date();

		this.offering = offering;
		this.balance = balance;
	}

	public static CDAccount readFromString(String string) {
		try {

			String[] strArray = string.split(",");

			long accountNumber = Long.valueOf(strArray[0]);
			double balance = Double.valueOf(strArray[1]);
			double interestRate = Double.valueOf(strArray[2]);
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = dateFormatter.parse(strArray[3]);

			int term = Integer.valueOf(strArray[4]);
			
			return new CDAccount(new CDOffering(term, interestRate),
								balance, accountNumber, date);
			
		} catch (Exception e) {
			System.out.println("readFromString in CDAccount "
					+ "threw NumberFormatException");
			throw new NumberFormatException();
		}
	}

	public double getBalance() {
		return super.getBalance();
	}

	public double getInterestRate() {
		return offering.getInterestRate();
	}

	public int getTerm() {
		return offering.getTerm();
	}

	public Date getOpenedOn() {
		return super.getOpenedOn();
	}

	public long getAccountNumber() {
		return super.getAccountNumber();
	}

	public double futureValue() {
		double interestRate = offering.getInterestRate();
		int years = offering.getTerm();

		return balance * (Math.pow(1 + interestRate, years));
	}
	
	public boolean withdraw(double amount) {
		
		return false;
	}
	
	public boolean deposit(double amount) {
		
		return false;
	}

}
