package com.langex.lambda;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * 자바에서 람다식으로 정의된 함수형 인터페이스가 모여있는곳이 java.util.function 패키지임.
 * 앞으로 사용될 람다 적용 API 들은 내부적으로 이 패키지의 함수들을 사용함.
 * 따라서 이 함수 패키지의 기본 내용을 반드시 알아야 응용을 할 수 있음.
 * 
 * 아래의 함수형인터페이스(함수) 는 기억하기
 * 
 * Consumer : 파라미터가 있고, 리턴이 없는 경우
 * Supplier : 파라미터가 없고, 리턴이 있는 경우
 * Function : 파라미터가 있고, 리턴이 있는 경우
 * Operator : 파라미터가 있고, 리턴이 있는 연산 결과를 리턴하는 함수
 * Predicate : 파라미터가 있고 ,리턴이 boolean 형태인 경우
 */
@AllArgsConstructor
@Data
class MyStudent{
	private String name;
	private String subject;
	private int java;
	private int jsp;
}
public class FunctionPackExam2 {
	static MyStudent[] list = {
		new MyStudent("바보","같은",50,50),
		new MyStudent("녀석","들",90,90)
	};
	
	//각 학생의 속성 또는 속성의 값을 연산한 결과를 정의하도록 mapper 함수를 이용하는 메소드 정의.
	static void printAvg(ToDoubleFunction<MyStudent> avg) {
		double res = 0;
		for(MyStudent st : list) {
			res += avg.applyAsDouble(st);
		}
		System.out.println(res/list.length);
	}
	
	static void printString(Function<MyStudent,String> function) {
		for(MyStudent st:list) {
			System.out.println(function.apply(st)+" ");
		}
		System.out.println();
	}
	
	static void printInt(Function<MyStudent, Integer> function) {
		for(MyStudent st : list) {
			System.out.println(function.apply(st));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		printAvg(value -> value.getJava());
		
		//학생 이름을 리턴하도록 정의된 메소드 호출.
		//Mapper 를 통해 학생 객체를 String 으로 매핑 시키는 메소드를 통해 출력함.
		printString(t -> t.getName());
		
		//과목의 점수를출력하는 메소드 호출
		printInt(t -> t.getJava());
	}
}
