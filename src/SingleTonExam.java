/*
 * Singleton 패턴 : 자바에서는 무분별하게 객체를 생성하지 않기 위해 이 패턴을 적용해서 객체 생성을 제한할 수 있음.
 * 이 패턴은 외부에서 객체를 생성하지 못하게 하면서 하나의 인스턴스만 자신이 생성 후, 필요한 외부 객체에 전달할 수 있는 설계 패턴.
 * 
 * 이 패턴은 주로 웹 개발에서 쓰임
 * 
 * 패턴을 생성하는 방식은 자신의 instance 를 static field 로 초기화 하고, 기본 생성자는 private 으로 막아버림
 * 이후 getter 를 통해서 원하는 객체가 있으면 인스턴스의 ref 를 리턴하는 방식.
 */

class Singleton{
	//클래스가 로드됨과 동시에 자신의 인스턴스 생성 후 필드 초기화.
	private static Singleton instance = new Singleton();
	
	//외부에서 인스턴스 생성 못하게 생성자 막음
	private Singleton() {
		
	}
	
	//외부에 단 하나의 인스턴스만 넘겨주도록 getter 정의
	public static Singleton getInstance() {
		return instance;
	}
}
public class SingleTonExam {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		//위 instance1 과 2 는 같은 객체일까 아닐까??
		if(instance1==instance2) {
			System.out.println(instance1);
			System.out.println(instance2);
		}else {
			System.out.println("다른 객체");
		}
	}
}
