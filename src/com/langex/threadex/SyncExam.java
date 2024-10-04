package com.langex.threadex;

class Account{
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	synchronized void setBalance1(int money) {
		this.balance = money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"현재 작액 : "+balance);
	}
	
	synchronized void setBalance2(int money) {
		this.balance = money;
		System.out.println(Thread.currentThread().getName()+"현재 작액 : "+balance);
	}
}

class UseThread extends Thread{
	//공유객체 필드로 선언.
	Account account;
	
	public UseThread(String name) {
		setName(name);
	}
	
	void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.setBalance1(10000);
	}
}

class UseThread2 extends Thread{
	//공유객체 필드로 선언.
	Account account;
	
	public UseThread2(String name) {
		setName(name);
	}
	
	void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.setBalance2(5000);
	}
}

public class SyncExam {
	public static void main(String[] args) {
		Account account = new Account(0);
		
		UseThread t1 = new UseThread("Thread1");
		t1.setAccount(account);
		t1.start();
		
		UseThread2 t2 = new UseThread2("Thread2");
		t2.setAccount(account);
		t2.start();
	}
}
