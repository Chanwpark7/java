package com.utilex;
/*
 * 제한된 타입 파라미터 : 제한된이란 특정 타입의 Super or 하위 타입으로 파라미터를 제한시키는 Generic.
 * 이렇게 하는 이유는 API에 이렇게 선언된게 꽤 많기 때문. 개념만 잘 이해하면 됨.
 * 
 * ex) class someCls <T extends SomeCls or SomeInterface>
 */

public class GenericExam2 {
	
	//타입 제한을 건 메소드 정의
	public static <T extends Number> boolean compare(T t1, T t2) {
		//타입 출력
		System.out.println("비교 : "+t1.getClass().getSimpleName()+","+t2.getClass().getSimpleName());
		
		double d1 = t1.doubleValue();
		double d2 = t2.doubleValue();
		
		return (d1 == d2);
	}
	public static void main(String[] args) {
	
		boolean res = compare(100.0,100);
		System.out.println(res);
	}
}
