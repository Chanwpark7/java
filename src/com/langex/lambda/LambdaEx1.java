package com.langex.lambda;
/*
 * 자바의 람다 : 자바에서 람다는 인터페이스의 일종으로 처리됨. 단, 메소드가 하나만 있는 인터페이스여야만 람다식으로 컴파일 가능함.
 * 이 말은 람다(함수형 인터페이스)로 컴파일되기 위해선, 기본적으로 interface 를 정의하는 것과 같음.
 * 하지만 메소드는 반드시 추상 하나만 보유해야 함. 만약 이를 어기게 되면, 일반 인터페이스로 컴파일되고, 실행되어짐.
 * 
 * 만약 람다 인터페이스를 컴파일 시에 명시적으로 컴파일 시키려면, @FunctionableInterface 로 어노테이션 선언하면 됨.
 * 
 * 그럼 람다는 무엇인고 하면 익명객체임.
 * 
 * 자바는 원래 함수를 지원하지 않는 언어인데, 람다가 워낙 파급력이 쎄서 추가된 형태임.
 * 
 * 즉 람다는 함수(function)만 갖고 있는 객체라고 생각하면 됨.
 * 
 * 이를 (parameter)->{구현부} 형태로 표현하는 형식.
 * 
 * 예를 들어, interface A{ void ab()} 가 정의되어 있다고 가정.
 * 
 * 특정 클래스의 특정 메소드에서 ex)someMethod(A a){} 처럼 되어있을 때, 우린 3가지 형태로 위 메소드를 호출할 수 있음.
 * 
 * 1. A 타입의 하위 클래스 객체를 생성해서 넣어주는 방식.
 * 2. 익명으로 new A(){}; 로 구현하는 방식.
 * 3. ()->{} 로 구현하는 방식.
 * 
 * 위 메소드에는 반드시 A타입의 객체만 들어와야 하고, 그 객체가 들어오면 그 객체에 속한 메소드를 오버라이드 할 것.
 * 때문에 위 메소드에서 3번은 해당 객체가 들어올 수 있다는 걸 알기 때문에 ()->{}식으로 구현체를 넣는 형태로 생각.
 * 
 * () ---> represents parameter, 하나만 존재시엔 () 생략 가능. 이외엔 모두 넣어야 함.
 * -> ---> 람다식이라는 문법
 * {구현부} --->구현부의 내용이 하나인 경우엔 {} 생략 가능. 만약 return 이 있는 경우엔 한줄로 끝나야 함.
 * 나버진 모두 {} 해야 함.
 * 
 * 람다의 주 목적은 특정 데이터가 존재 하면 이 데이터를 수행할 함수를 그때그때 넣어주는 것.
 * 
 * 어떤 함수를 넣느냐에 따라 데이터의 처리 결과가 달라짐.
 * ex)method(a, b) --> 이 메소드에 함수가 + 인 경우와 - 인 경우를 각각 대입할 때 결과가 달라지는 것과 같음.
 */

@FunctionalInterface
interface Calculable {//인터페이스면서, 추상메소드 딱 하나만 존재하므로 람다 함수로 사용 가능.
	void calculate(int a, int b);
}

public class LambdaEx1 {
	static void doSome(Calculable calc) {
		int x = 1;
		int y = 2;
		
		calc.calculate(x,y);
	}
	public static void main(String[] args) {
		doSome((k, s) -> {
			int res = k+s;
			System.out.println(res);
		});
		
		doSome((m, n) -> {
			int res = m - n;
			System.out.println(res);
		});
		
		//기존의 thread 개체 생성
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		//람다로 thread 개체 생성
		Thread t1 = new Thread(()->{
			System.out.println(1);
		});
		t1.start();
		
		
	}
}
