package com.clsex.interexam;

public class UseRemoCon {
	public static void main(String[] args) {
		//인터페이스가 자신의 인스턴스를 생성 못하는지 확인.
//		RemoteControl remocon = null;
//
//		Television tv = new Television();		
//		Audio audio = new Audio();
//		SmartTV smartTv = new SmartTV();
//		
//		//tv = audio; //타입이 달라서 오류 발생.
//		
//		remocon = audio;
//		remocon.turnOn();
//		
//		System.out.println("리모컨의 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
//		System.out.println("리모컨의 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
//
//		remocon.setVolume(10000);
//		remocon.turnOff();
//		remocon.setMute(true);
//		remocon.setMute(false);
//		
//		RemoteControl.changeBattery();
		
		//다중 인터페이스 상속시 사용 예시
		RemoteControl tv = new Television();
		RemoteControl audio = new Audio();
		MagicRemoteController smartTv = new SmartTV();
		
		tv.turnOn();
		audio.turnOn();
		smartTv.turnOn();
		smartTv.surfing("naver.com");
	}
}
