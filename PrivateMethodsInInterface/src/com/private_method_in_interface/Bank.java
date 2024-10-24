package com.private_method_in_interface;

public interface Bank {
	double getBalance();

	void deposit(double amount);

	void withdraw(double amount);

	default void executeTransaction(String type, double amount) {
		if (type.equals("DEPOSIT")) {
			deposit(amount);
			logTransaction(type, amount);
		} else if (type.equals("WITHDRAW") && sufficientFunds(amount)) {
			withdraw(amount);
			logTransaction(type, amount);
		} else {
			System.out.println("Transaction Failed! - Insufficient Funds");
		}
	}

	private void logTransaction(String type, double amount) {
		System.out.println("Transaction Type: " + type);
		System.out.println("Amount: " + amount);
		System.out.println("Current Balance: " + getBalance());
	}
	
	private boolean sufficientFunds(double amount) {
		return getBalance() >= amount;
	}
}
