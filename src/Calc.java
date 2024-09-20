//4칙 계산기 만들기
/*
 * 클래스 이름은 Calc 이고, 프로그램이 시작되면 ---계산기 시작---
 * 출력 후 값1, 값2, 연산자를 입력 받음.
 * 연산자를 검증해서 4칙 연산자 중 하나라면, 결과를 출력 하도록 하고,
 * 그렇지 않다면, 올바른 연산자가 아니라고 출력시킴.
 * 
 * 목적에 따라서 메소드를 최소 2개 이상 정의하여 활용.
*/

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		System.out.println("---계산기 시작---");
		getInput();
	}
	
	static void getInput() {
		int x,y;
		String z;
		Scanner scanner = new Scanner(System.in);
		System.out.println("값1 입력 : ");
		String strX = scanner.nextLine();
		x = Integer.parseInt(strX);

		System.out.println("값2 입력 : ");
		String strY = scanner.nextLine();
		y = Integer.parseInt(strY);

		System.out.println("연산자 입력 : ");
		z = scanner.nextLine();
		
		if(checkOp(z)) {
			if(z.equals("/")) {
				if(x%y != 0) {
					double ans=(double)x/y;
					System.out.println(x+z+y+"="+ans);
				}else {
					int ans = x/y;
					System.out.println(x+z+y+"="+ans);
				}
			}else {
				System.out.println(x+z+y+"="+calc(x,y,z));
			}
		}else {
			System.out.println("올바른 값 입력");
		}
	}
	
	static boolean checkOp(String op) {
		boolean res=false;
		
		switch (op) {
		case "+","-","*","/":
			res = true;
			break;
		default:
			res=false;
		}
		
		return res;
	}
	
	static int calc(int a,int b,String c) {
		int ans=0;
		switch (c) {
		case "+":
			ans = a+b;
			break;

		case "-":
			ans = a-b;
			break;

		case "*":
			ans = a*b;
			break;
			
		case "/":
			ans = a/b;
			break;

		default:
			ans=0;
		}
		return ans;
	}
}
