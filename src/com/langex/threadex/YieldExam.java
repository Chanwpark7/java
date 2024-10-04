package com.langex.threadex;
/*
 * yield() : 다른 쓰레드에게 실행을 양보하고, Runnable 상태로 갔다가,
 * 다른 쓰레드의 작업이 끝난 후 Running 상태로 와서 수행하도록 하는 제어 메소드.
 * 쓸데없는 자원 점유를 막기위함 메소드임.
 */

class WorkThread extends Thread{
	//run 에서 무한 루프 시 flag field
	//ex) 채팅의 경우 입력값을 무한정대기하기 보다는 입력의 여부를 수행하는 쓰레드가 CPU를 점유하고 있다가
	//	입력 신호가 감지되면 flag 를 바꿔서 빠져 나가면
	//	그 이후에 입력값들을 처리하는 쓰레드가 running 상태로 전이되게 하는 기법.
	boolean flag = true;
	
	public WorkThread(String name) {//쓰레드 이름을 파라미터로 하는 생성자.
		setName(name);//상속받은 쓰레드의 setName()을 호출, 이름 세팅
	}
	@Override
	public void run() {
		
		while(true) {
			System.out.println(getName()+ "와우 친구들 빡빡이 아죠씨야");
			if(flag) {
				System.out.println(getName()+" 작업 처리");
			}
			else {
				Thread.yield();
			}
		}
	}
}

public class YieldExam {
	public static void main(String[] args) {
		WorkThread work1 = new WorkThread("워크 쓰레드A");
		WorkThread work2 = new WorkThread("워크 쓰레드B");
		work1.start();
		work2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//work1의 상태값을 false 로 설정. 이렇게 되면 while()로 들어와도 할게 없음. 즉 자원만 차지함.
		work1.flag = false;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		work1.flag = true;
	}
}
