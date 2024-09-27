package com.myfile3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberBaseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run=true;
		int total=0;
		
		String[] userArr = new String[4];
		NumberBaseball nbb = new NumberBaseball();
		String[] comArr = nbb.comNumber();
		
		System.out.println("게임시작");
		while(run=true) {
			total++;
			int ball=0;
			int strike=0;
			System.out.println("숫자 4개를 입력하세요");
			String strX = sc.nextLine();
			
			if(strX.length()>4) {
				System.out.println("좋은말로 할때 숫자 4개만 입력하세요");
			}else {
				for(int i = 0;i<4;i++) {
					userArr[i] = strX.substring(i,i+1);
				}
				
				for(int i = 0;i<4;i++) {
					for(int j=0;j<4;j++) {
						if(userArr[i].equals(comArr[j])) {
							ball++;
						}
					}
					if(userArr[i].equals(comArr[i])) {
						ball--;
						strike++;
					}
				}
				if(strike==4) {
					System.out.println("축하합니다!\n컴퓨터의 숫자는"+Arrays.toString(comArr)+"이었습니다.\n당신은 꼴랑 숫자 4개를 맞추는데 "+total+"번이나 물어보셨습니다!");
					System.exit(0);
				}
				System.out.println(strike+"s "+ball+"b");
			}
		}
		
		System.out.println("승리!");
	}
	
	public String[] comNumber() {
		ArrayList<String> arr1 = new ArrayList<>();
		for(int i = 0;i<10;i++) {
			String a = Integer.toString(i);
			arr1.add(a);
		}
		
		String[] arr2 = new String[4];
		
		for(int i = 0;i<arr2.length;i++) {
			int com = (int)(Math.random()*(10-i));
			arr2[i] = arr1.get(com);
			arr1.remove(com);
		}

		return arr2;
	}
}
