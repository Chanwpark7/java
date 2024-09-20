
public class IfEx1 {
	public static void main(String[] args) {
		//랜덤을 이용해서 81 부터 100사이의 값이 나오도록 만들어 보쇼.
		
		int ran= 100 - (int)(Math.random()*20);
		System.out.println(ran);
		
		int ran2= (int)((9+Math.random())*(9+Math.random()));
		System.out.println(ran2);
		
		//등급 변수 선언.
		String grade;
		
		//90점 이상은 A+
		if(ran >=90) {
			if(ran >= 95) {
				grade="A+";
			}else {
				grade="A";
			}
		}else {
			if(ran >= 85) {
				grade="B+";
			}else {
				grade="B";
			}
		}
		
		System.out.println(grade);
	}
}
