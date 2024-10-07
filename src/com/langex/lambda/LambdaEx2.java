package com.langex.lambda;

@FunctionalInterface
interface DoSomething{//얘를 상속하는 놈은 알아서 할 일을 오버라이드 하라는 의미.
	void doSome();
}

class Person{
	public void action(DoSomething doSomething) {
		doSomething.doSome();
	}
}

public class LambdaEx2 {
	public static void main(String[] args) {
		Person student = new Person();
		Person salaryMan = new Person();
		
		student.action(() -> {
			System.out.println("ㅎㅅ");
			System.out.println("바보");
		});
		salaryMan.action(() -> System.out.println("ㅈㅈㅇ"));
	}
}
