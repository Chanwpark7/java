package com.clsex.interexam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

public class UseEnum {
	public static void main(String[] args) {
		/*
		 * 날짜 객체를 이용해서 오늘의 요일을 추출한 뒤 열거 상수와 비교해보는 로직을 작성해 봅니다.
		 * 참고로, 자바스크립트와 같은 Date 도 잇고, 좀더 많은 기능의 Calendar 객체도 있음.
		 * Calendar 를 이용해서 사용해 봄.
		 */
		
		//오늘의 요일을 초기화 함.
		Week today = null;
		
		//시간 객체인 Calendar 객체 생성.
		Calendar cal = Calendar.getInstance();
		
		//오늘의 요일 get
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		//리턴된 요일의 숫자를 열거상수와 비교해서 값 get
		switch(week) {
			case 1: today = Week.SUNDAY;break;
			case 2: today = Week.MONDAY;break;
			case 3: today = Week.TUESDAY;break;
			case 4: today = Week.WEDNESDAY;break;
			case 5: today = Week.THURSDAY;break;
			case 6: today = Week.FRIDAY;break;
			case 7: today = Week.SATURDAY;break;
		}
		
		if(today==Week.SUNDAY || today == Week.SATURDAY) {
			System.out.println("주말");
		}else {
			System.out.println("주일");
		}
		
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int min = now.getMinute();
		int sec = now.getSecond();
		
		System.out.println(now);
		Scanner sc = new Scanner(System.in);
		String strX = sc.nextLine();
		
		LocalTime nowafter = LocalTime.now();
		int hourafter = now.getHour();
		int minafter = now.getMinute();
		int secafter = now.getSecond();
		System.out.println(nowafter);
		
	}
}
