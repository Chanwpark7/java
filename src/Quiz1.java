/*
 * 프로그램이 시작되면 세개의 수를 입력 받아서 큰수부터 나열하시오.
 * 결과는 변수가 fir, sec, third 가 있다면 결과 역시 fir >= sec>= third 로 나오도록 함.
 * ex) 수 1 입력 : 10, 수 2 입력 : 3
 * 결과 : 10 >= 3
 */

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("x 값 입력 : ");
		String strX = scanner.nextLine();
		int x = Integer.parseInt(strX);
		
		System.out.println("y 값 입력 : ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);
		
		System.out.println("z 값 입력 : ");
		String strZ = scanner.nextLine();
		int z = Integer.parseInt(strZ);
		
		if (x>y) {
			if(x>z) {
				if(y>z) {
					int fir=x;
					int sec=y;
					int third=z;
					System.out.println(fir+">="+sec+">="+third);
				}
				if(y<z) {
					int fir=x;
					int sec=z;
					int third=y;
					System.out.println(fir+">="+sec+">="+third);
				}
			}
		}
		
		if (y>x) {
			if(y>z) {
				if(x>z) {
					int fir=y;
					int sec=x;
					int third=z;
					System.out.println(fir+">="+sec+">="+third);
				}
				if(x<z) {
					int fir=y;
					int sec=z;
					int third=x;
					System.out.println(fir+">="+sec+">="+third);
				}
			}
		}
		
		if (z>x) {
			if(z>y) {
				if(x>y) {
					int fir=z;
					int sec=x;
					int third=y;
					System.out.println(fir+">="+sec+">="+third);
				}
				if(x<y) {
					int fir=z;
					int sec=y;
					int third=x;
					System.out.println(fir+">="+sec+">="+third);
				}
			}
		}
	}
}
