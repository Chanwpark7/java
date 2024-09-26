package com.clsex.nested;
/*
 * 멤버(중첩)클래스 예시
 */
 
//class CC{
//	
//}

public class AA {

	//CC cc;//AA 라는 클래스가 객체화 되어질 때, 필드로 CC 타입의 객체를 사용하겠다는 의미
	String name;
	int x;
	
	//중첩 클래스에 올 수 있는 접근 제어는 public default private 중 하나이다.
	class BB{
		int f1 = 1;
		
		//원래는 정적 필드는 정적 inner 에만 적용됐는데, 17부터는 허용됨.
		static int f2 = 2;
		
		BB(){
			
		}
		
		void methodBb() {
			System.out.println("Outer 의 멤버 사용하기" + x);
			System.out.println("Run BB Member method");
			//useBB();
			name = "박찬우";
		}
		
		static void StaticMethodBb() {
			//x += 100; //Outer 의 멤버는 inner 의 static 메소드에서는 접근 불가능함. 따라서 에러.
			System.out.println("Run BB Static method");
		}
	}//End of BB
	
	//Outer 의 멤버 메소드를 정의해서 같은 멤버인 BB 를 사용하는 코드 작성 함.
	
	void useBB() {
		BB bb = new BB();
		System.out.println(bb.f1);
		//bb.methodBb();
		System.out.println(BB.f2);
		BB.StaticMethodBb();
	}
//	
//	BB theBBMem = new BB();
//
//	AA(){
//		BB bb = new BB();
//		cc = new CC();
//	}
//	
//	void methodAA() {
//		BB bb = new BB();
//		cc = new CC();
//	}
}
