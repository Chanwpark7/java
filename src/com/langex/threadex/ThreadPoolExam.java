package com.langex.threadex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Thread Pooling : 프로그래머가 Thread 를 잘못 설계해서 생성하게 되면 제어불가능할 정도로 많은 Thread 가 생성되고,
 * 소멸되지 못한 상태에서 리소스만 차지할 수 있음. 이를 위해서 Thread pool이라는 개념이 등장함.(꽤 오래전부터)
 * Thread pool 은 원래 오픈 라이브러리로 제공이 되어서 사용했는데, 자바에선 최근 이 개념을 공식 api 로 등록해서 사용하도록 함.
 * 
 * 특징 : 한번에 생성할 쓰레드의 갯수를 지정하고, 특정 시간동안 활동하지 않는 쓰레드는 소멸시키며
 * 최소 몇개의 쓰레드를 항상 남겨두는지의 여부를 결정할 수 있음.
 * 
 * 이렇게 Thread pool을 생성하면 Thread 의 생성 및 주기 관리는 VM 이 알아서 하도록 하게되므로, 개발자는 로직에만 집중할 수 있음.
 */
public class ThreadPoolExam {
	public static void main(String[] args) {
		//1000개의 메일 설정.
		String[][] mails = new String[1000][3];
		
		for(int i = 0;i<mails.length;i++) {
			mails[i][0] = "test@test.com";
			mails[i][1] = "test"+i+"@test.net";
			mails[i][2] = "email contents";
		}
		
		long startTime = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		
		//위에 생성한 각 메일을 전송하는 작업 정의 및 Thread 수행
		for(int i = 0; i<1000; i++) {
			final int idx = 1;
			
			//쓰레드 수행
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String contents = mails[idx][2];
					
					System.out.println(thread.getName()+" : from : "+from+"==> to "+to+contents);
				}
			});
		}
		executorService.shutdown();
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간 : "+(endTime-startTime));
	}
}
