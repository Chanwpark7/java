package com.langex.lambda;

/*
 * 리턴이 존재하는 람다식 : 만약 한줄의 코드가 리턴을 나타낸다면 return 키워드와 함께 {} 생갹 가능.
 * ex) {return a+b} --> a+b;
 * 
 * 그렇지 않은 경우엔 중괄호 사용하고, 필요에 따라서 return 키워드는 연산식의 결과로 대체할 수 있음.
 * ex) {int a = 10, b = 20; a+b;} 여기서 a+b 가 return 이 생략된 코드임. 자동으로 a + b 의 결과값이 리턴됨.
 */

interface Calc{
	double calc(double x, double y); //x, y 를 파람으로 받고, 오버라이드된 결과를 리턴하도록 선언한 메소드
}

class  UseCalc{
	void doSome(Calc calc) {
		double res = calc.calc(10, 10);
		System.out.println(res);
	}
}

public class LambdaEx5 {
	public static void main(String[] args) {
		UseCalc uc = new UseCalc();
		uc.doSome((x, y) -> {
			double res = x+y;
			return res;
		});
		
		uc.doSome((a, b) -> a-b);
		
		uc.doSome((x, y) -> sum(x,y));
	}
	
	static double sum(double x, double y) {
		return x+y;
	}
}
