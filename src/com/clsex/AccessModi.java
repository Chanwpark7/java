package com.clsex;
/*
 * 자바 접근제어 키워드 : public > protected > default > private
 * 
 * 자바에서는 위 키워드를 클래스, 필드, 생성자, 메소드에 적용해서 클래스 외부에서 접근여부를 결정짓게 할 수 있다.
 * 
 * 가장 큰 범위인 public 은 패키지의 위치에 상관없이 접근 가능하고, private 은 클래스 내부에서만 가능함.
 * 
 * protected 는 같은 패키지(폴더) 에서는 모두 접근 가능하나, 외부 패키지에서는 오직 상속받은 자식 클래스만 접근이 가능함.
 * 즉, 다른 패키지의 자식 클래스가 상속을 받았을 경우, super 로 생성자나 메소드를 접근하도록 하는데 주 목적이 있다.
 * 
 * default 는 아무것도 선언하지 않은 상태인데, 이 경우엔 같은 패키지(폴더) 에서만 접근 간으하며, 다른 패키지에서는 접근 불가능하다.
 */
public class AccessModi {
	public static void main(String[] args) {
		HisClass his = new HisClass();
	}
}
