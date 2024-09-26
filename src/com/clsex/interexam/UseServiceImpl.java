package com.clsex.interexam;

public class UseServiceImpl {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		
		service.defMethod();
		System.out.println();
		service.defMethod2();
		System.out.println();
		
		//정적 메소드 호출
		Service.staticMethod();
		System.out.println();
		Service.staticMethod2();
	}
}
