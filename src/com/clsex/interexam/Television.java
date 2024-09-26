package com.clsex.interexam;
/*
 * 클래스가 인터페이스를 상속 받을 때는 클래스명 다음에 implements interA,B,C,...
 * 로 선언함. 클래스는 필요하다면 위처럼 하나 이상의 인터페이스를 , 를 기준으로 다중 상속을 받을 수 잇음.
 */
public class Television extends Object implements RemoteControl{

	private int volume;
	private int currentVolume; //mute 실행시 현재 볼륨 값을 저장하는 필드.
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	
	@Override
	public void setVolume(int volume) {
		//리모콘의 필드값을 기준으로 그 값 사이의 볼륨으로 조정되게 로직 추가
		this.volume=volume;
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}
		if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}
		
		System.out.println("현재 볼륨은 : " + this.volume);
		
	}
	
	//상속받은 default 메소드를 오버라이드 하려면 반드시 public 접근제어를 줘야 하며, default 키워드는 생략되어야 함.
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.currentVolume = this.volume;
			System.out.println("음소거합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("음소거를 해제합니다.");
			setVolume(this.currentVolume);
		}
	}
	
}
