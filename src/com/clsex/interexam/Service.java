package com.clsex.interexam;
/*
 * private method exam
 */
public interface Service {
	
	default void defMethod() {
		System.out.println("def method code1");
		defaultCommon();
	}
	
	default void defMethod2() {
		System.out.println("def method code2");
		defaultCommon();
	}
	
	//private method define
	private void defaultCommon() {
		System.out.println("def method 중복 코드 A");
		System.out.println("def method 중복 코드 B");
	}
	
	//static method define
	static void staticMethod() {
		System.out.println("static method code1");
		staticCommon();
	}
	
	static void staticMethod2() {
		System.out.println("static method code2");
		staticCommon();
	}
	
	//private static method
	private static void staticCommon() {
		System.out.println("static method 중복 코드 C");
		System.out.println("static method 중복 코드 D");
	}
}
