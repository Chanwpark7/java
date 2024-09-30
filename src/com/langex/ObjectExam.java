package com.langex;
/*
 * java.lang 의 Object 클래스.
 * 이 클래스는 묵시적으로 모든 클래스의 부모로 존재함.
 * 이 말은 모든 클래스타입은 이 타입으로 형변형이 가능하다는 것.
 * Object 클래스에는 하위 클래스들이 기본적으로 오버라이드 한 몇개의 메소드와 쓰레드를 제어할때 사용되는 메소드를 보유하고 있음.
 * 이 중 필수 메소드를 확인함.
 * 
 * toString() : 이 메소드는 모든 자식 클래스가 자신의 목적에 맞게(일반적으로는 객체의 상태를 문자열로 리턴하도록) 재정의한 대표적 메소드임.
 * Object 에서는 객체의 hash를 문자열로 리턴하도록 정의됨.
 * 
 * equals(Object obj) : 같은 객체인지를 비교하는 대표적 메소드. String 등의클래스에서는 이 메소드를 자신에 맞게 오버라이딩 함.
 * 
 * 
 */
public class ObjectExam {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj);
		System.out.println(obj2);
		if(obj.equals(obj2)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
	}
}
