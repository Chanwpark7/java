package com.clsex;
/*
 * final 키워드 : final 키워드는 클래스, 메소드, 메소드 파라미터, 메소드 내부에 선언이 가능함.
 * 선언된 위치에 따라서, 클래스에 붙으면 상속 금지, 메소드에 붙으면 오버라이드 금지, 메소드 파라미터에 붙으면 값 변경 금지, 변수에 붙으면 값 변경 금지
 * final 은 주로 상수를 표현할 때 사용함. 상수는 값이 초기화 되어지고, 이 값이 변경되어지지 않아야 할 때 사용됨.
 * js 의 const 와 유사.
 * 자바에서는 이 상수를 공유(다른 클래스나 객체에서 잠초하는 것)할 땐, 일반적으로 static 과 같이 선언함.
 * 그리고 이렇게 static final 로 선언된 변수는 값이 무조건 초기화 되어야 하고, 절대 변경이 금지됨.
 * 이렇게 공유 목적의 필드는 소유권이 class에게 있으므로 접근도 class이름.필드명 으로 접근함.
 * static 은 메소드에도 붙을 수 있는데, 설계적으로는 만약 특정 메소드가 연산처리를 할 때 해당 클래스의 필드값이 필요치 않거나 할때는
 * static 으로 선언해서 이를 사용할때는 객체 생성없이 class.methodName() 으로만 호출하도록 함.
 * 
 * 마지막으로, 자바에서는 이러한 공유 목적의 필드는 변수명을 무조건 모두 대문자로 함. 필요시엔 _(under bar)를 이용해서 단어를 연결함.
 */
class MyCls{
	final int a=100;
	//public static final double I_RATE = 0.05; 
	public static final double I_RATE;
	
	//static 변수보다 먼저 호출되는 구문이 static 블락임.
	static {
		I_RATE = 0.05;
	}
	
	public final void doSome() {
	
	}
}

class UrCls extends MyCls{
	
//	@Override 금지됨.
//	public void doSome() {
//		
//	}
	
	public void myMethod(final int a) {//메소드 내에서 값 변경 금지
		//a = a + 1;
		final int k = 10;
		//k = 20;
	}
}

public class FinalExam {
	public static void main(String[] args) {
		
	}
}
