package com.clsex.nested;
/*
 * 정적 중첩 클래스의 정의 예시
 * 정적 중첩 클래스의 접근제어는 public default private 만 가능.
 * 정적 중첩은 Outer 의 멤버로서의 기능 보다는, 외부에 노출 시켜서 Outer와 함께 사용되는 경우를 대비해서 주로 설계함.
 */
public class CC {
	
	int x;
	
	static class DD{
		//필드, 생성자, 메소드 모두 정의 가능.
		
		int sf1 = 1;
		
		static int sf2 = 2;
		
		DD(){
			
		}
		
		void doSome() {
			System.out.println(sf1);
		}
		
		static void doSome2() {
			System.out.println(sf2);
		}
	}
	
	DD dd = new DD();
	
	static DD dd2 = new DD();

	CC(){
		DD dd = new DD();
	}
	
	void method1() {
		DD dd = new DD();
	}
	
	static void method2() {
		DD dd = new DD();
	}
	
}
