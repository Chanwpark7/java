package com.langex.threadex;

import javax.swing.JOptionPane;
class InputThread extends Thread{
		
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		String str = JOptionPane.showInputDialog("입력");
		System.out.println("입력 값 : "+str);
	}
}

//Runnable 구현한 클래스 정의
class PrintAlpha implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Thread start");
		for(int i = 0; i<100000000;i++) {
			System.out.println((char)i);
		}
	}
}

public class ThreadEx2 {
	public static void main(String[] args) {
		//1. 사용자로부터 값 입력 받기
		//2. 타이머 표시해서 콘솔에 뿌리기
		
		//Thread 객체 생성 후 실행 명령 내리기
		Thread thread = new InputThread();
		thread.start();
		
		/*
		 * Thread 생성방법
		 * 1. Thread 클래스를 상속받아 해당 클래스가 쓰레드가 됨.
		 * 2. Runnable interface 를 구현한 객체를 Thread 의 생성자에 넘겨서 쓰레드를 생성.
		 */
		
		//Thread를 정지하는 method : sleep(), join(), wait()
		
		//문자를 출력하는 Thread 생성 후 실행
//		Thread alphaThread = new Thread(new PrintAlpha());
//		alphaThread.start();
		
		Thread alphaThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" Thread start");
				for(int i = 0; i<100000000;i++) {
					System.out.println((char)i);
				}
			}
		});
		alphaThread.start();
		
		Thread currThread = Thread.currentThread();
		System.out.println("현재 쓰레드 : "+currThread.getName());
		
		for(int i = 0;i<100000000;i++) {
			System.out.println("타이머 값 : "+i);
		}
	}
}
