package com.langex.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

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
public class FunctionPackExam {
	public static void main(String[] args) {
//		Consumer<String> c = new Consumer<String>() {
//			
//			@Override
//			public void accept(String t) {
//				System.out.println("내 이름은 "+t);
//			}
//		};
//		
//		c.accept("바보");
		
		Consumer<String> c = t -> System.out.println("내 이름은 "+t);
		c.accept("바보");
		
		BiConsumer<String, Integer> bc = (t, u) -> {
			System.out.println("key : "+t);
			System.out.println("value : "+u);
		};
		bc.accept("d", 1);
		
		
		DoubleConsumer dc = d -> System.out.println(0.01+d);
		dc.accept(0.001);
		
		//Supplier : 파람이 없고, 리턴이 있는 메소드를 갖고 있음. 리턴은 대부분 getter 로 구성돼있음
		Supplier<String> sl = () -> "바보";
		System.out.println(sl.get());
		
		sl = () -> "내일\"은\" 쉬는 날";
		System.out.println(sl.get());
		
		IntSupplier is = () -> {
			int random = (int)(Math.random()*100);
			return random;
		};
		System.out.println(is.getAsInt());
		
		//Function 인터페이스 : 파라미터와 리턴이 모두 존재하는 추상 메소드인 apply() 를 보유한 인터페이스들.
		//사용하는 방식으로는 주어지는 타입을 매핑해서 리턴해주는 역할을 함
		Function<String, Integer> fn = (number) -> {
			return Integer.parseInt(number);
		};
		System.out.println(fn.apply("1323"));
	}
}
