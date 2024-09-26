package com.clsex.nested;
/*
 * 로컬클래스(지역 중첩)은 클래스의 정의부가 Outer 클래스의 생성자 또는 메소드 내부에 정의되고
 * 사용 또한(객체화) 내부에서만 이뤄지고 사용되는 특징을 갖고 있다.
 * 이러한 특징 때문에 지역(local) 클래스라 호칭한다.
 * 
 * 로컬 클래스 또한 내부에는 생성자, 필드, 메소드도 정의될 수 있고, static 은 자바 17부터 정의 가능하다.
 * 
 * 중요! 지역 클래스가 생성자 또는 메소드에서 사용되는 변수는 기본적으로 final로 선언된다.
 * 17 이전에는 명시적으로 선언해야 하지만, 이후 부터는 컴파일 시에 자동으로 붙여짐
 * 때문에 지역 변수를 한부로 변경하면 컴파일 에러를 유발한다.
 */
public class EE {

	void useFF(int k) {
		int x = 100;
		class FF{
			int ffField1 = 1;
			
			static int ffField2 = 100;
			
			//생성자
			FF(){
				System.out.println("지역 FF 클래스 생성자 실행됨.");
			}
			void method1() {
//				x += 100;
//				k += 100;
				System.out.println(x);
				System.out.println(k);
				System.out.println("지역 FF 클래스 메소드 1 실행됨.");
			}
			static void method2() {
				System.out.println("지역 FF 클래스 static 메소드2 실행됨.");
			}
		}//End of FF
		FF f = new FF();
		System.out.println(f.ffField1);
		System.out.println(FF.ffField2);
		f.method1();

	}
//	void useKK() {
//		//FF f = null;
//	}
}
