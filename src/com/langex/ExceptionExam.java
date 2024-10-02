package com.langex;
/*
 * Java Exception : 예외는 실행중에 발생하는 예상치 못한 에러를 통틀어 말합니다.
 * 여기서 중요한건, 예외는 실행중에 발생된다는 것. 즉 컴파일러는 예외가 발생할지 여부를 모름.
 * 실행중에 발생된다는건 예외 또한 실행 이후에 발생되는 에러를 객체화 했다는 것.
 * 따라서 뭔가 예외가 발생하면 JVM 은 그 예외가 발생한 코드에서 실행을 멈추고, 발생된 예외의 내요을 담은 객체를 생성해서
 * 프로그램 밖으로 던져버리는 과정이(throw) 발생함.
 * 그래서 예외는 던져진다고 함.
 * 
 * 예외 객체를 던진다는 것은 예외 또한 객체라는 것이고 이 말은 예외 또한 클래스로 정의되었다는 것.
 * 
 * 이렇게 예외가 발생되어 throw 되면, 프로그램이 적절한 핸들링을 요구하는데, 이것을 예외 핸들링이라 함.
 * 
 * 만약 핸들링 하지 않으면 예외가 프로그램 밖으로 던져지기 때문에 그 시점에 JAVA는 모든 실행을 멈추고 종료됨.
 * 
 * 따라서 프로그래머는 예외가 발생할 지점에 적절히 예외를 핸들링(catch)하고ㅡ 프로그램이 비정상적으로 종료되지 않도록 해야 함.
 * 
 * 예외 핸들링 코드 문법 : try{예외가 발생할 코드 기술}catch(예외 객체 e){예외 발생 시 예외를 핸들링 하는 코드}finally{예외 발생 여부와 상관없이 무조건 실행되는 블락}
 * 
 * 위에서, try 없는 catch 는 사용될 수 없고 if 절처럼 필요에 따라서 예외를 중첩시킬 수 있음.
 * 즉 try 내부에 try 가 올 수 있고, catch 내부에 다시 try 가 올 수 있음. 물론 finally 내부에도 try 가 올 수 잇음.
 * 
 * 예외는 실행중에 발생되지만, API 특성상 예외가 발생될 수 있는 코드가 내포되어 잇음을 선언된 API가 많음.
 * 
 * 이때, 이를 사용하게 되면 경우에 따라서 컴파일러가 예외 핸들링을 검증하게 됨. 이를 일반 예외(Exception) 이라 하고,
 * 실행중에만 발생되는 예외, 즉 컴파일러가 상관 안하는 예외를 RuntimeException 이라 함.
 */
public class ExceptionExam {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		System.out.println(a+b);
		try {
			System.out.println(a/b);//예외 발생.
		}catch(Exception ar) {//예외가 발생하면 같은 타입이거나 큰 타입으로 잡아냅니다.
			System.out.println("짱구같은 녀석아 0으로 나누면 어떡하니");
			ar.printStackTrace(); // 예외가 발생된 콜스택을 콘솔에 출력하는 메소드
			System.out.println(ar.getMessage());//예외의 내용을 문자열로 리턴하는 메소드 호출
		}
		System.out.println("예외 발생 이후 코드");
		
		ArithmeticException aa = null;
	}
}
