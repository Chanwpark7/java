package com.langex.lambda;
/*
 * 람다식 메소드 참조
 * 
 * 람다에서는 특정 클래스(static), 인스턴스 메소드를 참조하여 호출할 수 있음.
 * 문법은 CLASS::METHOD명 --> 주의! 메소드 명만 호출함. static 의 경우
 * instance변수::METHOD명
 * 
 * 위와 같은 식으로 호출 가능함.
 */

@FunctionalInterface
interface Proc{
	double process(double x, double y);
}

interface LamInter{
	void doSome();
}

class UseLamInter{
	public int k = 0;//인스턴스 변수 선언
	
	void methodA() {
		final int k = 100;//지역 변수 선언
		
		LamInter lam = ()->{
			//람다로 오버라이드
			System.out.println("member field calling(this) --> "+this.k);
			System.out.println("this which includes class --> "+UseLamInter.this.k);
			System.out.println("local variable : "+k);
		};
		lam.doSome();
	}
}

class UseProc{
	public void doSome(Proc proc) {
		double res = proc.process(10, 10);
		System.out.println(res);
	}
}

class ComputeSome{
	public static double staticMethod(double x, double y) {
		return x + y;
	}
	public double instanceMethod(double x,double y) {
		return x * y;
	}
}

public class LambdaMethod {
	public static void main(String[] args) {
		//람다에서 사용되는 this의 예시 호출
		UseLamInter checkThis = new UseLamInter();
		checkThis.methodA();
		
		UseProc up = new UseProc();
		up.doSome((x, y) -> ComputeSome.staticMethod(x, y));
		up.doSome(ComputeSome::staticMethod); //위와 같음.
		
		ComputeSome com = new ComputeSome();
		up.doSome(com::instanceMethod);
	}
}
