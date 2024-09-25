package com.clsex;

public class Account {
	private int balance;
	private String name;
	private int accountNumb;
	private int deposit;
	private int withdraw;
	public static int counter;

	public Account(int accountNumb, String name, int balance) {
		this.accountNumb = accountNumb;
		this.name = name;
		this.balance = balance;
		counter++;
	}
	
	public String toString() {
		return "계좌번호 : " + accountNumb + "\n계좌주 : "+ name + "\n잔액 : "+ balance;
	}

	public int getBalance() {
		return balance;
	}

	public int getAccountNumb() {
		return accountNumb;
	}

	public void setAccountNumb(int accountNumb) {
		this.accountNumb = accountNumb;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.balance += deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		if(withdraw>this.balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.balance -= withdraw;
	}
	
	public static int getCounter() {
		return counter;
	}
	
}
