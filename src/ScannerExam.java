/*
 * 콘솔에 출력이 아닌, 콘솔로부터 사용자의 값을 입력받아서 프로그램에서 응용하는 방법.
 * Scanner 객체 : java.util package 에 존재하는 클래스로, 객체를 생성하면 콘솔로부터 입력을 받을 수 있도록 해줌.
 * 이 객체는 new 라는 키워드로 생성함.
 */

import java.util.Scanner;

public class ScannerExam {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("x 값 입력 : ");
		
		//콘솔로부터 사용자의 입력을 get 하는 메소드 호출해서 enter 전까지의 값을 가져옴.
		//리턴 타입은 String 타입임. 수치형인 경우에도 문자열 타입으로 오기 때문에 필요시 parsing 해서 사용함.
		String strX = scanner.nextLine();
		//System.out.println("입력한 값 : " + strX);
		int x = Integer.parseInt(strX);
		
		System.out.println("y 값 입력 : ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);
		
		int result = x+y;
		System.out.println(strX+"+"+strY+"="+result);
	}

}
