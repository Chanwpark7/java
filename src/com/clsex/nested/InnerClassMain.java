package com.clsex.nested;
/*
 * 자바 중첩(Nested) 클래스 : 일반적으로 객체 지향이란, 클래스를 바탕으로 객체를 생성 후
 * 객체간의 메소드등을 이용해서 프로그래밍을 하는걸 말함.
 * 이처럼 각 클래스는 독립적으로 존재하는게 일반적이지만, 어떤 클래스 or 인터페이스 존재 자체가
 * 특정 클래스만을 위해서 존재하는 경우도 있음(마치 필드처럼, 필드의 목적으로 특정 클래스에만 종속적이라는 의미)
 * 
 * 이럴때는 해당 클래스를 독립적으로 정의하는게 아닌, 종속되어지는 클래스 내부에 클래스를 정의해서 필요시 객체를 생성해서
 * 사용토록 하는걸 중첩클래스라고 함(Nested class)
 * 
 * 이렇게 사용할 때 장점은 클래스의 멤버를 쉽게 사용할 수 있고, 중첩 관계의 복잡성을 내부로 감추어서 외부에서는
 * 쉽게 객체 형태로 되어진 멤버필드를 사용할 수 있음. 물론 설계가 쉽지는 않음.
 * 
 * 이 중첩 클래스는 크게 4가지로 구분되어 지는데, 선언 위치에 따라서 각각 이름이 틀려짐.
 * 
 * 1. 클래스 멤버로 참여(정의) 하는 클래스 : 멤버 중첩
 * 2. 정적 멤버로 참여(정의) 하는 클래스 : 정적 중첩
 * 3. 특정 메소드 내부에만 참여(정의) 되어서 해당 메소드가 호출되어야만 인스턴스가 생성되어 수행되는 클래스 : 지역 중첩(로컬 클래스)
 * 4. 이름이 없이 익명으로 정의되었다가 인스턴스를 생성해서 바로 사용하는 익명중첩
 * 
 * 위 4가지의 형태로 구분되어 짐.
 * 
 * 클래스가 표기되는 형식은 만약 A 클래스 내부에 B 클래스를 정의 했다면, A $ B.class 형태로 보여짐.
 * 만약 로컬클래스로 정의 되었다면, A $1 B.class 로 보여지게 됨.
 */

public class InnerClassMain {
	
	public static void main(String[] args) {
		//외부에서 멤버 중춥을 사용하는 예시
		AA aa = new AA();
		//AA.BB bb = aa.new BB();
		AA.BB bb = (new AA()).new BB();
		
		aa.useBB();
		
		//Static inner 객체를 Outer 의 외부에서 생성하는 문법
		CC.DD dd = new CC.DD();
		
		//지역 클래스를 사용하는 예시. 반드시 지역 클래스가 정의된 메소드 or 생성자를 호출해야 함.
		EE e = new EE();
		e.useFF(0);
	}
}
