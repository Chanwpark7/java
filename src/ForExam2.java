
public class ForExam2 {

	public static void main(String[] args) {
		//국우단 출력 ex) 2단 시작 -> 2단 끝
		
		for (int i = 2; i <=9 ; i++) {
			System.out.println(i+"단 시작");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println(i+"단 끝\n");
		}
		
	}

}
