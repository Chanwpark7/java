import java.util.Arrays;

public class ArrayEx1 {
	public static void main(String[] args) {
		/*
		 * 배열은 대표적 Ref 타입.
		 * 메소드는 없고, 속성으로 길이를 나타태는 length 하나만 갖고 있음.
		 * null은 속성/메소드 없음.
		 * 
		 * 아래는 객체가 언제 생성되는지 확인 하는 코드.
		 * int[] inArr = null;
		 * System.out.println(inArr.length); //null 배열의 길이를 호출함.
		 */
		// 배열의 생성식.
		// 1. new 를 이용해 생성하기. 이때는 반드시 배열의 길이를 줘야함.
		// 배열은 객체이고, 객체는 속성과 메소드를 갖음.
		// 이중 배열은 속성만 갖는데, 자바에서는 기본 객체를 생성하면 그 속성(필드)의 값이 타입의 기본갑승로 자동 초기화됨.
		// 아래 배열은 int 타입으로 배열을 생성하고, 길이만 주어졌기 때문에, 값은 자동으로 0으로 초기화 됨.
		 
		int[] inArr1 = new int[3];
		//생성된 배열의 hash code 확인
		System.out.println(inArr1);
		
		//2. {}를 이용해서 값으로 초기화 된 배열을 생성함.
		int[] inArr2 = {1,2,3};
		System.out.println(inArr2);
		
		//3. 위 두개의 생성식을 하나로 합친 문법.
		int inArr3[] = new int[] {10,20,30};
		System.out.println(inArr3);
		
		inArr1 = new int[] {5,5,5}; //new = 새로운 instance 생성.
		/*
		 * 자바에서 =,!= 연산자는 p타입과 r타입 모두에서 사용됨.
		 * p에서는 값이 같은지를 물어보고, r에서는 ref 가 같은지, 즉 hash code 가 같은지를 물어봄.
		 * 만약 같다면 true 가 리턴되고 ,이를 객체라고 칭함.
		 * 객체가 같다는 말은, 그 내부의 속성(field) 의 값도 당연히 같다라고 생각하면 됨.
		 */
		//inArr1=inArr2; //inArr1에서 생성된 빈 배열 삭제 및 inArr2 로 대체.
		
		if(inArr1==inArr2) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
		
		inArr1 = new int[3];
		//배열의 값을 문자열로 출력만 하고 싶을때는 배열을 사용할 때 유효한 메소드로 구성된 java.util 의 Arrays 클래스의 메소드를 이용함
		System.out.println(Arrays.toString(inArr1));
		System.out.println(Arrays.toString(inArr3));
		
		for(int i = 0; i<inArr2.length;i++) {
			System.out.println(inArr2[i]);
		}
		
		//자바스크립트의 for of 와 같은 for in
		//inArr3 의 모든 index 를 자동으로 접근해서, 각 index의 값을 리턴하고 그 값을 x에 담도록 하는 for 구문.
		for(int x : inArr3) {
			System.out.println(x);
		}
	}
}
