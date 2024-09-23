package com.clsex;

public class UseCar {
	public static void main(String[] args) throws InterruptedException {
		Car genesis = new Car("black", "현대", "GV80", 0, false);
		Car myCar = new Car("white", "기아", "morning", 0, false);
		
		myCar.engineStart();
		myCar.accel(10);
		myCar.engineStop();
	}
}
