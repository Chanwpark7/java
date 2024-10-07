package com.langex.threadex;

class Account{
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	void doSome() {
		System.out.println(balance);
	}
	
	void setBalance1(int money) {
		
		//동기화 블락 : 동기화가 필요한 코드에 synchronized(공유 객체명)을 선언하고
		//코드를 적용하면, 동기화 메소드와 동일한 효과를 얻어낼 수 있다.
		synchronized(this) {
			this.balance = money;
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"현재 작액 : "+balance);
		}
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
