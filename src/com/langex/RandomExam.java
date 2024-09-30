package com.langex;

import java.util.Arrays;
import java.util.Random;

public class RandomExam {
	public static void main(String[] args) {
//		Random r = new Random();
//		Random seedR = new Random(System.currentTimeMillis());
//		
//		System.out.println(System.currentTimeMillis());
//		System.out.println(seedR.nextInt());
//		System.out.println(r.nextInt());
//		System.out.println(r.nextInt(100));
//		
//		System.out.println(r.nextDouble(10));
		
		//선택번호를 담는 배열 선언 해보시오.
		int[] select = new int[6];
		Random r = new Random(3);
		for(int i=0; i<6; i++) {
			select[i] = r.nextInt(45) + 1;
			System.out.println(select[i]);
		}
		System.out.println();
		
		//당첨번호
		int[] lucky = new int[select.length];
		r = new Random(5);
		for(int i=0; i<6; i++) {
			lucky[i] = r.nextInt(45) + 1;
			System.out.println(lucky[i]);
		}
		System.out.println();
		
		//배열 정렬 시키기
		Arrays.sort(select);
		Arrays.sort(lucky);
		boolean res = Arrays.equals(select, lucky);
		
		System.out.println("학원 나올지 말지 여부");
		if(res) {
			System.out.println("난 부자");
		}else {
			System.out.println("실패");
			System.out.println(Arrays.toString(select));
			System.out.println(Arrays.toString(lucky));
		}
	}
}
