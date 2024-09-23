/*
 * 배열의 Deep Copy의 이해.
 * System API를 이용.
 */

import java.util.Arrays;

public class ArrayEx3 {
	private static void callByRef(int[] arr) {
		System.out.println(Arrays.toString(arr));
		//값 변경
		arr[0]=1000;
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		System.out.println(args.length);
		System.out.println(Arrays.toString(args));
		
		int arr[] = {1,2,3};
		
		System.out.println(Arrays.toString(arr));
		
		int newArr[] = new int[arr.length];
		//System 클래스의 배열 복사 메소드를 호출. arrayCopy()
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		
		callByRef(arr);
		System.out.println(Arrays.toString(newArr));
		
	}
}
