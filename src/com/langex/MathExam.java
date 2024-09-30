package com.langex;

public class MathExam {
	public static void main(String[] args) {
		//수학 관련 API 대부분이 static 메소드로 정의됨.
		double d1 = Math.ceil(5.3);
		double d2 = Math.floor(5.3);
		System.out.println(d1+":"+d2);
		
		double d3 = 12.345135135;
		//소수 이하 2자리 얻기
		double temp = d3*100;
		System.out.println(Math.round(temp));
		
		double t2 = (int)temp/100.0;
		System.out.println(t2);
	}
}
