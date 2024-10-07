package com.langex.lambda;
/*
 * 파라미터가 존재하는 람다의 처리방식.
 * 1. 메소드등의 타입은 대부분 무시해도 됨. 컴파일 시에 검사하기 때문
 * 2. 하나인 경우엔 ()를 생략 가능하나, 두개 이상 또는 무인자 인 경우엔 반드시 () 해야함.
 */

interface DoSome2{
	void doSome2(String who, String duty);
}

interface DoSome3{
	void doSome3(String who);
}

class MyClass{
	public void action(DoSome2 doSome2) {
		doSome2.doSome2("hi","bye");
	}
	
	public void action2(DoSome3 doSome3) {
		doSome3.doSome3("lmao");
	}
}

public class LambdaEx4 {
	
	
	public static void main(String[] args) {
		MyClass jason = new MyClass();
		jason.action((name,duty) -> {
			System.out.println(name+" "+duty);
		});
		jason.action2(who -> System.out.println("aaron"));
	}
}
