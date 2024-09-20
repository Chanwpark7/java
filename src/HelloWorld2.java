
public class HelloWorld2 {

	//이건 라인 주석이다 이눔아
	
	/*
	 * 이건 블락 주석이란다 이눔아
	 */
	
	//Java Application 은 클래스 기반의 언어로, 대부분이 클래스로 정의 및 유지 되어야 함.
	//나중에 배울 Interface 등은 다른 형태이긴 하나, 기본적으로 클래스 기반 언어임.
	
	//클래스를 정의 후에 App 이 실행이 되려면 entry point, 즉 시작점이 있어야하는데, 그걸 main method 라고 함.
	//즉 약 만개의 클래스를 정의해서 하나의 App을 만들었어도, 시작 method(main)이 없으면 실행이 안된다는 뜻.
	//이 main method 는 모든 클래스에서 딱 하나만 존재해야하고, 이 method 를 보유한 클래스를 main class 라고 함.
	//아무튼 java 클래스명을 cmd 창에서 실행하며는 jvm 은 제일 먼저 main()을 자동으로 호출하고, 이때부터 자바가 실행된다는 뜻.
	
		public static void main(String[] args) {
			System.out.println("해위영");
		}
}
