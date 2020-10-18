package com.meritamerica.assignment3;


public class MeritAmericaBankApp {
	public static void main(String[] args) {
		//MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		
		CDAccount cdAccount = CDAccount.readFromString("84,20000,0.03,01/03/2020,5");
		System.out.println(cdAccount.getAccountNumber());
		System.out.println(cdAccount.getBalance());
		//demonstration();
	}
	
public static void demonstration() {
		
		// add 5 CDOfferings to MeritBank
		MeritBank.setCDOfferings(initialCDOfferings());
		
		// instantiate a new account holder
		AccountHolder ah1 = new AccountHolder();
		
		// add a checking account with an opening balance of 1000 to ah1
		ah1.addCheckingAccount(new CheckingAccount(1000.00));
		System.out.println(ah1.getCombinedBalance());
		
		// add a savings account with an opening balance of 10000 to ah1
		ah1.addSavingsAccount(new SavingsAccount(10000.00));
		System.out.println(ah1.getCombinedBalance());
		
		// add a checking account with an opening balance of 5000 to ah1
		ah1.addCheckingAccount(5000.00);
		System.out.println(ah1.getCombinedBalance());
		
		// add a savings account with an opening balance of 50000 to ah1
		ah1.addSavingsAccount(50000.00);
		System.out.println(ah1.getCombinedBalance());
		
		// add a checking account with an opening balance of 50000 to ah1
		ah1.addCheckingAccount(50000.00);
		System.out.println(ah1.getCombinedBalance());
		
		// add a checking account with an opening balance of 500000 to ah1
		ah1.addSavingsAccount(500000);
		System.out.println(ah1.getCombinedBalance());
		// add a checking account with an opening balance of 5000 to ah1
		ah1.addCheckingAccount(5000.00);
		System.out.println(ah1.getCombinedBalance());
		
		// add a savings account with an opening balance of 50000 to ah1
		ah1.addSavingsAccount(50000.00);
		System.out.println(ah1.getCombinedBalance());
		
		// confirm last checking and savings accounts were not created
		System.out.println(ah1.getNumberOfCheckingAccounts());
		System.out.println(ah1.getNumberOfSavingsAccounts());
		System.out.println(ah1.getCheckingBalance() + ah1.getSavingsBalance());
		
		CDOffering bestCDOffering = MeritBank.getBestCDOffering(100);
		CDAccount aCDAccount = new CDAccount(bestCDOffering, 100);
		ah1.addCDAccount(aCDAccount);
		//System.out.println(ah1.getCombinedBalance());
		
		// this is throwing an error
		ah1.getCDBalance();
		//9
		MeritBank.addAccountHolder(ah1);
		//10
		AccountHolder ah2 = new AccountHolder();
		//11
		ah2.addCheckingAccount(1000);
		//12
		CDOffering secondBestCDOffering = MeritBank.getSecondBestCDOffering(100);
		ah2.addCDAccount(secondBestCDOffering, 100);
		//13
		MeritBank.addAccountHolder(ah2);
		//14
		MeritBank.clearCDOfferings();
		//15
		AccountHolder ah3 = new AccountHolder();
		//16
		secondBestCDOffering = MeritBank.getSecondBestCDOffering(100);
		ah3.addCDAccount(secondBestCDOffering, 100);
		//17
		//HAVE TO CONFIRM STEP 16 DID NOT ADD THE CD ACCOUNT
		
		//18
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		//19
		MeritBank.addAccountHolder(ah3);
		//20
		MeritBank.totalBalances();
		

		
		
		
	}
	
	public static CDOffering[] initialCDOfferings() {
		CDOffering[] cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);

		return cdOfferings;
	}
}