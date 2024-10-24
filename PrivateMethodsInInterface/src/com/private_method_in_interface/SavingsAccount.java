package com.private_method_in_interface;

public class SavingsAccount implements Bank {

	private double balance;

	@Override
	public double getBalance() {
		return balance;
	}

	public SavingsAccount(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;

	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;

	}

}
