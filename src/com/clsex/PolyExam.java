package com.clsex;

class A{
	
}

class B{
	
}

class C{
	
}

public class PolyExam {
	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		char ch = 3;
		
		int[] arr = {b,s,ch}; //Promotion
		
		b = (byte)arr[0];
		
		A aa = new A();
		B bb = new B();
		C cc = new C();
		
		System.out.println(aa);
		System.out.println(bb);
		
		Object objArr[] = {aa,bb,cc};
		
		aa = (A)objArr[0];
		
		Object obj = aa;
		obj = new A();
	}
}
