
public class ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1~20 사이의 랜덤값 2개를 생성해서 두 값 사이의 누적합을 구하는 for 를 작성하시오.
		//단, 두 수는 반드시 오름으로 계산되어야 함.
		int ran1=(int)(Math.random()*20+1);
		int ran2=(int)(Math.random()*20+1);
		int a = ran1;
		int b = ran2;
		if(ran2>ran1) {
			a=ran2;
			b=ran1;
		}
		int total=0;
		
		for(int i=b+1;i<a;i++) {
			total+=i;
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(total);
		
		
	}

}
