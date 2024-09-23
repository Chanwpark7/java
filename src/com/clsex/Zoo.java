package com.clsex;

public class Zoo {
	public static void main(String[] args) {
		// Dog dog1 = new Dog();
		// Dog dog2 = new Dog("시베리안허스키");
		Dog dog = new Dog("철수", "시고르자브종");
		Cat cat = new Cat("영희", "코리안숏헤어");
		Duck duck = new Duck("희밥", "고영희밥");
		
		System.out.println(dog.getName());
		System.out.println(dog.toString());
		
		dog.sound();
		cat.sound();
		duck.sound();
		
		
		//dog.name="철수";
		//dog.breed="시고르자브종";
		
		//System.out.println(dog.name);
		//System.out.println(dog.breed);
		//System.out.println(dog.age);
	}
}
