package com.private_method_in_interface;

public class BankTest {
	public static void main(String[] args) {
		Bank savings = new SavingsAccount(1000);
		savings.executeTransaction("DEPOSIT", 9000);
		savings.executeTransaction("WITHDRAW", 2000);

		System.out.println("Final Amount: " + savings.getBalance());

	}
}
