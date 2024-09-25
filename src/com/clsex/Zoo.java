package com.clsex;

public class Zoo {
	public static void main(String[] args) {
		// Dog dog1 = new Dog();
		// Dog dog2 = new Dog("시베리안허스키");
		Dog dog = new Dog("철수", "시고르자브종"); //new 생성자() : heap 영역에 instance 생성
		Cat cat = new Cat("영희", "코리안숏헤어");
		Duck duck = new Duck("희밥", "고영희밥");
		
		System.out.println(dog.getName());
		
		dog.sound();
		cat.sound();
		duck.sound();
		
		System.out.println(dog);
		
		Animal ani = dog;
		Animal ani2 = cat;
		Animal ani3 = duck;
		ani.sound();
		
		
		//다형성 : 슈퍼타입의 ref 변수로 상속된 자식 인스턴스의 오버라이드된 메소드를 super 타입으로 호출하여
		//오버라이드된 내용을 수행하도록 하는 기법
		Animal[] animals = {dog,cat,duck};
		for(int i = 0;i<animals.length;i++) {
			Animal thePet = animals[(int)(Math.random()*animals.length)];
			thePet.sound();
			//instanceof 연산자 : 좌측의 인스턴스가 우측의 클래스타입인지를 검증해서 맞으면 true/ false 를 리턴하는 연산자
			if(thePet instanceof Duck) {
				((Duck)thePet).layEggs();
			}
		}
		
		//Animal a = new Animal("동물");//Abstract 객체(현실화 되어질 수 없는 추상적 형태의 클래스)
		//System.out.println(a);
		//여기서 Animal 은 현실에 존재하지 않는 추상적인 형태의 객체로, 객체지향에서는 이 객체가 실제 생성되어지는 의미가 없음.
		//하지만 추상화 클래스가 되기 전까지는 객체를 생성하는데엔 문제 없음.
		
		
		//dog.name="철수";
		//dog.breed="시고르자브종";
		
		//System.out.println(dog.name);
		//System.out.println(dog.breed);
		//System.out.println(dog.age);
	}
}
