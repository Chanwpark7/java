import java.util.Scanner;

public class WhileEx {
	public static void main(String[] args) {
		
		//Scanner sc = null; //null로 객체 초기화
		//while 의 flag 초기화

		Scanner sc= new Scanner(System.in);
		boolean run=true;
		int speed=0;
		
		while(run) {
			System.out.println("--");
			System.out.println("1. 증속 \n2. 감속 \n3. 중지");
			System.out.println("--");
			System.out.println("선택 : ");
			System.out.println(speed);
			
			String strNum = sc.nextLine();
			
//			if(strNum=="1"){//같은 객체를 물어보는 코드. 값은 따지지 않음.
			
			//문자열 내의 값이 무엇인지 판별하는 메소드인 equals.
			if(strNum.equals("1")){
				speed++;
				System.out.println("현재 속도 : "+speed);
			}
			if(strNum.equals("2")){
				speed--;
				System.out.println("현재 속도 : "+speed);
			}
			if(strNum.equals("3")){
				run=false;
			}
			
		}

		//System.out.println("프로그램 종료.");
		//명시적으로 자바의 프로그램을 강제종료하는 API
		System.exit(0); //이 코드를 호출하면 자바 Process 가 종료됨.
	}
}
