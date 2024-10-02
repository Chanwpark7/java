package com.langex;
/*
 * 자바 어노테이션 : @ 으로 시작하는 요소
 * 어노테이션은 클래스, 인터페이스를 컴파일 or 실행할때 어떻게 처리할것인지를 알려주는 정보의 일환.
 * 요즘은 자바계열에서는 이 어노테이션을 이용해서 app을 구성하는 형태가 일반적.
 * 
 * 목적은 다음과 같음.
 * 
 * 1. 컴파일 시 사용하는 정보를 전달
 * 2. 빌드 틀(이클립스, 인텔리J)이 코드를 자동으로 생성할 때 사용하는 정보를 전달
 * 3. 실행 시 특정 기능을 처리할 때 사용함.
 * 
 * 실제적으로 나중에 스프링부트(스프링 계열)은 모든 처리를 어노테이션으로 수행함.
 * 
 * 어노테이션을 정의해서 사용할 일은 드뭄. 이미 정의된 많은 어노테이션의 의미를 파악하고 응용하는데 포커스를 두면 됨.
 * 
 * 어노테이션 정의 방법.
 * 
 * 자바에서는 어노테이션 하나의 타입으로 간주함.
 * 정의하는 방법은 인터페이스를 정의하는 것과 매우 유사함. 단, interface 앞에 @을 붙여주면 어노테이션으로 컴파일 됨.
 * 
 * ex) public @interface AnnotationName{
 * 
 * }
 * 
 * 위에 정의된 어노테이션은 사용시에 @AnnotationName 을 선언해서 사용함.
 * 이때 어노테이션이 메모리에 머무는 시점을 정의시에 지정할 수 있음.
 * 
 * 어노테이션에는 속성을 정의할 수 있음. 속성은 타입, 이름으로 구성되며, 이름 뒤에 괄호를 붙여서 선언함.
 * 이때 이 속성의 값은 어노테이션을 사용할 때 지정해서 줄 수 있으며, default 키워드를 사용해서 값을 초기화할 수도 있음.
 * 
 * ex)public @interface MyAnno2{
 * 		//속성 선언
 * 		String prop1();
 * 		int prop2() default 1;//값 초기화 
 * }
 * 
 * 위 코드를 사용하는 예시
 * @MyAnno2(prop1 = "hello");//default 값 그냥 사용
 * @MyAnno2(prop1 = "hi",prop2 = 100);//default 값 변경.
 * 
 * 마지막으로 속성중에는 기본속성인 value() 를 선언할 수도 있음.
 * 
 * ex)public @interface MyAnno3{
 * 		String value();//속성 사용
 * 		int prop2() default 1;
 * }
 * 
 * 위 코드의 사용 예시//value 값에 값을 대입할 때는 반드시 '값'만 줘야 함.
 * 주의! 만약 value 와 일반 속성을 동시에 적용시엔 반드시 value = 이라는 속성명을 선언해야 함.
 * 
 * @MyAnno3("value 값"); or @MyAnno3(value = "value 값",100); --> value 값 설정 및 prop2 의 값 설정.
 * 
 * 어노테이션이 적용되는 범위에 대한 내용 : 
 * 
 * 어노테이션은 자바에서 모든 범위에 적용이 가능함.(패키지, 클래스, 생성자, 메소드, 필드, 지역변수 등)
 * 이때 정의된 어노테이션이 어디에 적용이되는지를 선언할 수 있음.
 * 만약 클래스에 적용하라고 선언했다면, 이는 클래스의 정의부 이전에 나와야 함.
 * 이를 메소드나 생성자에 적용을 하면 에러를 유발함.
 * 이렇게 적용되는 범위에 대해서 ElementType 이라는 열거 상수에 정의가 되어있음.
 * 이를 ElementType.범위 상수를 이용해서 @Target 이라는 어노테이션을 이용해서 선언함.
 * 
 * ex) @Target({ElementType.Type(클래스,인터페이스,열거타입), ElementType.FIELD,...}) -->하나 이상의 범위를 "," 를 이용해서 지정 가능.
 * 	public @interface MyAnno3{
 * 		properties n...
 * 	}
 * 
 * @Retention --> 어노테이션이 언제까지 유지될지를 결정하는 어노테이션.
 * 범위는 SOURCE, CLASS, RUNTIME 이며, 각각 컴파일 때 적용 후 제거되고,
 * 메모리로 로딩때 적용된 후 사라지며, 실행할때 적용되고 계속 유지되는 특징을 갖고 있음.
 */
public class AnnotationExam {
	public static void main(String[] args) {
		
	}
}
