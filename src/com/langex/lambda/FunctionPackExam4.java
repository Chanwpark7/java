package com.langex.lambda;

import java.util.function.Predicate;

/*
 * Predicate : 존재하는지의 여부를 boolean 으로 리턴하는 함수
 * 내부적으로는 test()라는 메소드를 갖고 있고, 파라미터는 각 함수마다 틀림.
 */
public class FunctionPackExam4 {
	
	static MyStudent[] list = {
		new MyStudent("멍청이","같은",40,40),
		new MyStudent("바보","같은",50,50),
		new MyStudent("녀석","들",90,90)
	};
	
	static double avgEng(Predicate<MyStudent> predecate) {
		int cnt = 0;
		int sum = 0;
		
		for(MyStudent ms : list) {
			//test 를 이용해서 equals 를 비교
			if(predecate.test(ms)) {
				cnt++;
				sum+=ms.getJava();
			}
		}
		return (double)sum/cnt;
	}
	public static void main(String[] args) {
		double avg = avgEng(ms -> ms.getSubject().equals("같은"));
		System.out.println("학생들의 Java 평균 : "+avg);
	}
}
