package com.langex.threadex;


class WorkingObj{
	public synchronized void methodA() {
		//이 동기화 메소드는 동기화 블락과 같음.
		//따라서 wait, notify() 등은 이 내부에서 호출해야 함.
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName()+"메소드 A 작업 실행중");
		notify();//wait() 전이된 thread 를 Runnable 상태로 전환토록 호출.
		
		try {
			wait();//자신은 waiting 영역으로 전이함.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName()+"메소드 B 작업 실행중");
		notify();//wait() 전이된 thread 를 Runnable 상태로 전환토록 호출.
		
		try {
			wait();//자신은 waiting 영역으로 전이함.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadA extends Thread{
	
	private WorkingObj workingObj;
	
	public ThreadA(WorkingObj workingObj) {
		setName("ThreadA");
		this.workingObj = workingObj;
	}
	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			workingObj.methodA();
		}
	}
}

class ThreadB extends Thread{
	private WorkingObj workingObj;
	
	public ThreadB(WorkingObj workingObj) {
		setName("ThreadB");
		this.workingObj = workingObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			workingObj.methodB();
		}
	}
}

public class WaitNotifyEx {
	public static void main(String[] args) {
		WorkingObj sharedObj = new WorkingObj();
		ThreadA threadA = new ThreadA(sharedObj);
		ThreadB threadB = new ThreadB(sharedObj);
		
		threadA.start();
		threadB.start();
	}
}
