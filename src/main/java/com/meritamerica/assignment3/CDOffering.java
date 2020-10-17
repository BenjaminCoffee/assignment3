package com.meritamerica.assignment3;


public class CDOffering {

	private int term;
	private double interestRate;
	
	
	public CDOffering()	{
		
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public static CDOffering readFromString(String string) {
		String[] strArray = string.split(",");
		
		int term = Integer.valueOf(strArray[0]);
		double interestRate = Double.valueOf(strArray[1]);
		
		return new CDOffering(term, interestRate);
		
	}
	public int getTerm() {
		return term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	
}
