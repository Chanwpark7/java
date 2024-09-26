package com.clsex.interexam;

public class Audio implements RemoteControl {

	private int volume;
	private int currentVolume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");

	}
	
	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
		
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
