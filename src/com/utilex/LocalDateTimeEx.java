package com.utilex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
 * Calendar 클래스에는 기본적으로 날짜를 연산하는 메소드도 있지만 날짜의 연산을 위한 클래스를 이용하면 더 쉬움.
 * 이 클래스가 그 역할을 함. 날짜와 관련된 연산을 하는 LocalDateTime
 */
public class LocalDateTimeEx {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println(now.format(dtf));
		
		System.out.println(now.plusYears(1));
		
		LocalDateTime endDate = LocalDateTime.of(2025, 3, 14, 18, 10);
		System.out.println(endDate);
		System.out.println(now.isBefore(endDate));

		long remainDays = now.until(endDate, ChronoUnit.DAYS);
		System.out.println(remainDays);
	}
}
