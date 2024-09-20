import java.util.Arrays;

public class UseMethod {

	public static void main(String[] args) {
		MethodEx.checkOp("-");
		
		int a=1;
		doSome(a);
		System.out.println(a);
		
		int[] inArr = {1,2,3};
		System.out.println("메인의 배열 출력 1 : "+Arrays.toString(inArr));
		refDoSome(inArr);
		System.out.println("메인의 배열 출력 2 : "+Arrays.toString(inArr));
	}
	
	static void refDoSome(int[] Arr1){//int 타입의 배열을 받아서 값을 조작하는 메소드
		System.out.println("refDoSome의 배열값 1 : "+Arrays.toString(Arr1));
		Arr1[0]=2000;
		System.out.println("refDoSome의 배열값 2 : "+Arrays.toString(Arr1));
	}
	
	static void doSome(int b){
		b=b+10;
	}

}
