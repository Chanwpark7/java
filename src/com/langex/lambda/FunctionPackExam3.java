package com.langex.lambda;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;


/*
 * Operator 함수 : 파라미터와 리턴이모두 존재하는 메소드를 보유한 함수
 * Operator를 사용하는 경우는 대부분 파라미터로 주어지는 것을 연산한 결과를 리턴하는데 사용됨.
 */

public class FunctionPackExam3 {
	
	static MyStudent[] list = {
		new MyStudent("바보","같은",50,50),
		new MyStudent("녀석","들",90,90)
	};
	
	//주어진 수를 연산한 결과 리턴
	static int maxOrMinMath(IntBinaryOperator op) {
		int res = list[0].getJava();
		for(MyStudent ms : list) {
			res = op.applyAsInt(res, ms.getJava());
		}
		return res;
	}
	
	//주어지는 두개의 double 을 비교연산해서 double 을 리턴하는 람다 이용
	static double maxOrMinAvg(DoubleBinaryOperator op) {
		double res = (list[0].getJava() + list[0].getJsp())/2.0;
		
		for (MyStudent ms : list) {
			res = op.applyAsDouble(res, (ms.getJava() + ms.getJsp())/2.0);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("최고 자바 점수 확인");
		int max = maxOrMinMath((x,y)->{
			if(x>=y) return x;
			else return y;
		});
		System.out.println(max);
		
		System.out.println(maxOrMinAvg((x,y)->(x>y ? x:y)));
	}
}
