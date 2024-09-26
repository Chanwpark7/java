package com.clsex.interexam;
/*
 * java 열거형 상수 : 상수는 보통 클래스나 인터페이스에 변수로 선언해서 사용하는 경우가 많은데
 * 이를 객체 타입으로 선언하게 해서 보다 직관적으로 사용할 수 있도록 한게 enum 이다.
 * 열거형상수는 내부적으로 각 값을 ref 타입으로 관리하여 사용되도록 되어 있다.
 */
public enum Week {
	
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}

/*
 * 오늘이 무슨 요일인지 의 값을 비교 할 때는 열가값으로 비교 가능함.
 * EX) Week today = Week.SUNDAY
 * 또한 열거타입의 값은 모두 객체로 관리되기 때문에 null 도 대입이 가능함.
 * ex) Week myBirth = null
 * 이 열거 상수의 값을 비교할 때는 객체 이기 때문에 == or != 을 써야함.
 */