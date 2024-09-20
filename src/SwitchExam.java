import java.lang.reflect.Array;

public class SwitchExam {
	public static void main(String[] args) {
		//기본 switch 구문
		
		char grade = 'B';
		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("우수 회원");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 회원");
			break;
		default:
			System.out.println("Guest");
			break;
		}
		
		switch(grade) {
			case 'A','a' -> System.out.println("우수 회원");
			case 'B','b' -> System.out.println("일반 회원");
			default -> System.out.println("Guest");
		}
	}
}
