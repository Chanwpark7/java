
public class DataTypeEx2 {
	public static void main(String[] args) {
		//실수 데이터 타입 : float, double(default)
		//double 은 float 보다 딱 2배 만큼 실수 표현을 더 할 수 있음.
		//때문에 특수한 상황이 아니고서는 실수를 사용하고 이게 연산이 되어질 경우엔 double 을 사용함.
		
		//float 은 값 초기화 시엔 반드시 값 끝에 f or F로 표기해야함.(아니면 에러)
		float f = 1.1F;
		long lo;
		lo=(long)f;//캐스팅 시 소수점 아래는 잘려나감.
		System.out.println(lo);
		
		f=0.1234567890123456789f;
		double d = 0.1234567890123456789;
		System.out.println(f);
		System.out.println(d);
		
		float ft=3.14f;
		double ft2= ft+1.0;
	}
}
