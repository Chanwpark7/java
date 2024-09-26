package com.clsex.interexam;

public class SmartTV implements MagicRemoteController {

	int volume;
	int currentVolume;
	
	@Override
	public void turnOn() {
		System.out.println("Smart TV를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("Smart TV를 켭니다.");
	}

	@Override
	public void setVolume(int volume) {
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
	
	@Override
	public void surfing(String url) {
		System.out.println(url + " 로 이동합니다.");

	}

}
