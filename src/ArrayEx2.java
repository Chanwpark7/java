import java.util.Arrays;

public class ArrayEx2 {
	public static void main(String[] args) {
		//정수를 담고 있는 배열을 동적 생성해서 printItem 에 전달하려고 함.
		// int[] inArr = {52,16,43,96,23};
		// printItem(inArr);
		printItem(new int[] {52,16,43,96,23});
		
		double[] dArr = new double[3];
		dArr[0]=1;
		dArr[1]=2;
		dArr[2]=3;
		//dArr[dArr.length] = 4;
		for(double d : dArr) {
			System.out.println(d);
		}
	}
	private static void printItem(int[] scores) {
		//전달된 배열의 총 합을 구하는 로직을 작성 후 출력하세요.
		//여기에 구현.
		int total=0;
		for(int i = 0; i<scores.length; i++) {
			total += scores[i];
		}
		System.out.println(total);
	}
}
