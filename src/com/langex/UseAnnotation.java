package com.langex;

import java.lang.reflect.Method;

public class UseAnnotation {

	@PrintAnnotation
	public void method1() {
		System.out.println("실행내용1");
	}
	
	@PrintAnnotation("*") //String value 의 기본값을 *로 변경함.
	public void method2() {
		System.out.println("실행내용2");
	}
	
	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("실행내용3");
	}
	
	public static void main(String[] args) {
		//어노테이션이 선언된 메소드를 읽고, 거기에 선언된 어노테이션 객체를 얻어낸 후,
		//어노테이션 정보를 확인하는 printLine()을 호출하도록 정의.
		Method[] methods = UseAnnotation.class.getMethods();
		for(Method method : methods) {
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			
			//설정 정보를 이용해서 출력하기
			printLine(printAnnotation);
			
			//Method 클래스이는 메소드를 이용해서 동적으로 메소드 호출.
			//method.invoke(new UserAnnotation(),0);
			
			printLine(printAnnotation);
			
		}
	}
	//어노테이션의 속성 정보를 확인하는 메소드 정의
	static void printLine(PrintAnnotation printAnnotation) {
		if(printAnnotation != null) {
			int number = printAnnotation.number();
			for(int i = 0; i<number; i++) {
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
