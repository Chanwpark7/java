package com.clsex.nested;
/*
 * 익명 객체(클래스) : 익명 객체는 말 그대로 이름이 없는 객체를 뜻함.
 * 지금까지 봤던 inner 클래스 처럼, 명시적으로 클래스를 정의하는게 아니라
 * 객체를 발생하는 시점에 클래스가 정의되고 사라진다는 개념.
 * 때문에 익명 클래스 또는 객체라고 함.
 * 
 * 이걸 사용하는 이유는 특정 클래스나 인터페이스를 특정 시점에 딱 한번만 특정 메소드(들)을 사용시점에서만
 * 객체화해서 사용하고 버려야 하는 코드에 적합함.
 * 
 * 주로 필드값, 로컨 변수값, 파라미터 변수값 등으로 사용됨.
 * 
 * 익명 객체는 크게 두개로 나뉘는데, 클래스를 구현한 객체를 익명자식객체라 하고, 인터페이스를 구현한 것을 익명구현객체라고 한다.
 * 
 * 사용 예시) new 부모생성자(parameter...){field, method...) 여기서 생성자란, 클래스와 인터페이스 모두를 포함하는 개념.
 * 클래스인 경우엔 생성자가 있기 때문에 이해하기 쉽지만, 인터페이스는 생성자가 없기때문에 어떻게 생성자를 호출하는지 이해가 어려움.
 * 이건 익명 클래스 즉, new Interface() 라고 호출하면 내부적으로 해당 Interface 를 구현한 익명 클래스가 생성되고,
 * 그 클래스의 생성자를 호출한다고 생각하면 쉽다. 그래서 익명 클래스라고 함.
 * 
 * 
 */

import com.clsex.interexam.RemoteControl;

class Tire{
	public void roll() {
		System.out.println("normal tire rolling");
	}
}

class Car{
	private Tire tire1 = new Tire();
	private Tire tire2 = new Tire() {
		public void roll() {
			System.out.println("anonymous tire rolling");
		};
	};//익명 클래스는 반드시 끝에 ; 넣어야 함.
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	public void run2() {
		new Tire() {
			@Override
			public void roll() {
				System.out.println("anonymous tire2 rolling");
			}
		}.roll();
	}
	
	public void run3(Tire tire) {
		tire.roll();
	}
}
abstract class MyAnony{
	abstract void a();
	abstract void b();
	void c() {
		
	}
}
public class AnonymousExam {
	
	private RemoteControl rc = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("켬");
		}
		
		@Override
		public void turnOff() {
			System.out.println("끔");
		}
		
		@Override
		public void setVolume(int volume) {
			
		}
		
	};
	
	public void use1() {
		rc.turnOn();
		rc.turnOff();
		
	}
	
	public void use2() {
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("켬2");
			}
			
			@Override
			public void turnOff() {
				System.out.println("끔2");
			}
			
			@Override
			public void setVolume(int volume) {
				
			}
		};
		rc.turnOff();
		rc.turnOn();
	}
	
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.run1();
		car.run2();
		car.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("anonymous tire3 rolling");
			}
		});
		
		//익명 자식객체 구현 예시
		new MyAnony() {
			@Override
			void b() {
				System.out.println("바보같은 녀석");
			}
			
			@Override
			void a() {
				
			}
		};
		
		//인터페이스를 구현한 구현객체인 익명구현객체 사용예시
		AnonymousExam home = new AnonymousExam();
		
		home.use1();
		home.use2();
		home.use3(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("켬3");
			}
			
			@Override
			public void turnOff() {
				System.out.println("끔3");
			}
			
			@Override
			public void setVolume(int volume) {
				
			}
		});
	}
}
