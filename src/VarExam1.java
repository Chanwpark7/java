
public class VarExam1 {

	public static void main(String[] args) {
		/*
		 * 변수에 대한 기본 개념 : 자바에서는 변수에 대한 규칙을 잘 이해해야 함.
		 * 스크립트에서는 할당되지 않은 변수는 undefined 로 표현하지만 자바에서는
		 * 값이 할당되지 않은 변수를 사용하면 에러.
		 * 자바에선 data type 이라는게 존재하는데, 변수가 처음 선언될땐 반드시 타입이 먼저 선언되어야 함.
		 * 이때 선언된 변수는 메모리를 할당하지 않은 상태가 되기 때문에 아무것도 없는 상태로 남게 됨.
		 * 이때, 이 변수를 연산하거나 사용하게 되면 에러를 유발함.
		 */
		int value=0; //변수 선언. 메모리는 생성되지 않은 상태임 -> 0 으로 초기화 함.
		int value2 = 10 + value;
		System.out.println(value);
	}
}
