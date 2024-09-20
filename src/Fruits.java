
public class Fruits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 사과, 배, 오렌지 가 각각 3,7,3 개씩 생산됨.(하루 기준)
		 * 그럼 시간당 총 생산량이 어떻게 되는지 출력 하시오(ex>0.3455..)
		 * 조건: 반드시 변수를 최대한 사용하고, 각 항목에 맞는 타입으로 사용하시오
		 * 반드시 한번의 캐스팅 연산을 사용하고, 한번의 리터럴을 사용하도록 하세요.
		 */
		byte apple = 3;
		byte pear = 7;
		byte orange = 3;
		int total=apple+pear+orange;
		float avg=(float)total/24;
		System.out.println(avg);
		
		//때에 따라서 산술 연산을 정확하게 계산하려면, 실수 타입을 사용하지 않는게 좋을 때가 있음.
		int a=1;
		double pUnit=0.1;
		int numb=7;
		
		double res = a - numb * pUnit;
		System.out.println(res);
		
		int a2=1;
		int tPiece=a2*10;
		int numb2 = 7;
		int result = tPiece - numb2;
		System.out.println(result/10.0);
	}

}
