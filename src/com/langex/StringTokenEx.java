package com.langex;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * StringTokenizer : 문자열 내의 특정 구분자(Delimiter)로 문자열을 구분해서 리턴해주는 객체.
 * 
 */
public class StringTokenEx {
	public static void main(String[] args) {
		String str = "아닌데? 하나도 안졸린데?";
		
		StringTokenizer st = new StringTokenizer(str,"?");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			String sk = st.nextToken();
			System.out.println(sk);
		}
		
		String data1 = "jason&dave&jake";
		String[] data2 = data1.split("&|,");
		System.out.println(Arrays.toString(data2));
	}
}
