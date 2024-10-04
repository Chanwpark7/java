package com.langex.threadex;

import java.util.Scanner;

public class ThreadEx1 {
	static String input;
	private static void waitInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("값 좀 입력해라");
		input = sc.nextLine();
	}
	public static void main(String[] args) throws Exception {
		waitInput();
		System.out.println("입력값 : "+input);
		System.out.println("main 종료");
		
		throw new Exception("예외 던짐");
	}
}
