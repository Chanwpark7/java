package com.clsex.interexam;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//위 두개의 기기에 대해 기본적으로 상속받을 기능인 음소거 기능을 추가 합니다.
	//이때, 음소거는 버튼 하나만 누르면 바로 mute 가 되기 때문에, 이 기능을 인터페이스에서 정의 한 후에 기본적으로
	//구현 객체(인터페이스를 상속한 객체를 뜻함)가 기능의 내용까지를 모두 상속 받도록 할 예정임.
	//이러한 목적으로 사용되는 인터페이스 메소드를 default 메소드라고 함.
	//default 메소드는 접근제어가 public or default 만 가능하고, 반드시 리턴 타입 앞에 default 라는 선언을 해줘야 함.
	//이 default 메소드는 메소드의 정의부를 갖을 수 있고, 필요하다면 인터페이스 내의 상수 필드와 추상 메소드를 호출할 수도 있음.
	
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("음소거합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("음소거를 해제합니다.");
		}
	}
	
	/* 
	 * 정적 메소드 : 이 메소드는 상속을 위한다기 보다는 인터페이스에서 필요한 기능을 정의하며
	 * 필요시에 참조해서 가져다 쓸 수 있도록 하는데 목적이 있다. 정적 메소드이기 때문에 메소드의 구현부를 가질 수 있고,
	 * 이를 호출할 때는 구현체가 필요 없이 인터페이스 명으로만 접근 가능함.
	 * 접근 제어는 public or private 만 가능. public 을 생략하면 자동으로 컴파일 시에 public 이 추가됨.
	 */
	static void changeBattery() {
		System.out.println("배터리를 교체 합니다.");
	}
}
