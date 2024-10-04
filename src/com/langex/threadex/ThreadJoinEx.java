package com.langex.threadex;
/*
 * join() : join() 을 호출한 thread 를 그 즉시 실행대기 영역으로 전이하고,
 * 호출 될 쓰레드의 run()이 완전히 종료시까지 대기하다가, 해당 쓰레드가 run()을 종료하면
 * 그 후에 Runnable --> Running 상태로 전이됨.
 */
class CalThread extends Thread{
	private long num;
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"쓰레드 시작");
		for(int i = 1; i<10; i++) {
			num += i;
			System.out.println(i);
		}
		System.out.println(Thread.currentThread().getName()+"쓰레드 끝");
	}
}

public class ThreadJoinEx {
	public static void main(String[] args) {
		CalThread thread = new CalThread();
		thread.start();
		
		try {//join 을 호출한 쓰레드는 일시정지영역으로 전이되고, 이 호출된 쓰레드의 run()이 종료되면 실행됨.
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1~1000의 누적 합 : "+thread.getNum());
	}
}
