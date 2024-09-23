/*
 * 자바에서 객체와 클래스 : 자바는 완벽한 객체지향 언어라는 평가를 받고 있는 언어.
 * 때문에 모든걸 객체로 만들어 프로그래밍하도록 지향하는데, 이를 OOP(Object Oriented Programming) 이라고 함.
 * 자바에서는 객체(Instance) 를 생성하기 위해서는 반드시 이의 기반이 되는 class 를 정의해야 함.
 * 즉, class 는 모든 객체의 설계도라고 생각하면 됨.
 * 예를 들어, 자동차 회사 경영 시 실제 소비자들은 현실에 존재하는 차(객체)를 타고 이용함.]
 * 또한 차를 선택할때는 그 차가 갖고 있는 본연의 속성(색상, 브랜드, 엔진 타입...) 을 기호에 맞게 선택하여 실제 차를 구매 및 이용하게 됨.
 * 
 * 이처럼 객체 지향 언어에서 객체는 실제 존재하는 것을 뜻하고(현실에 존재하는 차), 이 차의 속성과 메소드를 통해 차를 이용하듯
 * 객체의 속성과 메소드를 이용하여 다른 객체와 프로그래밍을 만들어 가는 것이 OOP.
 * 
 * must remember
 * 
 * 클래스를 정의할때는 3가지를 꼭 기억함.
 * 
 * 클래스에는 3개의 항목을 정의할 수 있는데,
 * 
 * 1. 속성을 나타내는 필드(field) -> 이 필드는 객체가 생성될 때 객체에 복사돼 간다고 하여 멤버필드라고 함.
 * 2. 기능을 정의하는 메소드 -> 메소드를 호출하여 객체의 속성의 값을 변경, 주고 받으면서 다른 개체간의 통시역할을 수행함.
 * 3. 생성자 -> 객체를 생성하는 역할을 하면서, 필요에 따라서는 객체의 속성을 특정 값으로 초기화 하거나 초기화 메소드를 호출하여
 * 객체 초기화 작업을 진행할 수 있음. 이 생성자가 없으면 클래스가 있다 하여도 객체를 만들 수 없음.
 * 자바는 모든 클래스에 기본적으로 컴파일 시에 기본 생성자(무인자 생성자)를 넣어줌. 단, 프로그래머가 클래스에 생성자를 하나도 정의하지 않을 경우만
 * 넣어주고, 만약 하나라도 정의하면, 넣어주지 않음. 꼭 기억.
 */
public class ClassEx1 {
	public static void main(String[] args) {
		//new 라는 키워드를 이용해 생성자를 호출하면 객체를 만들 수 있음.
		ClassEx1 a = new ClassEx1();
		ClassEx1 b = new ClassEx1();
		System.out.println(a);
		System.out.println(b);
		a=b;
		
		if(a==b) {//a와 b가 같은 객체인지 확인.(hash 가 같은지 확인)
			System.out.println("same");
		}else {
			System.out.println("not same");
		}
		
		//메소드 오버로딩의 예시
		String email = "chanwpark5234@gamil.com";
		
		email.indexOf(34);
	}
}
