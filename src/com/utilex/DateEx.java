package com.utilex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);
		System.out.println(now.getTime());
		
		/*
		 * 특정 포맷형식으로 날짜, 데이터를 지정하는 Format 인터페이스의 하위 타입을 이용해서 날짜 출력을 포맷 해봅시다.
		 * 대표적으로 사용되는 날짜 포매터는 SimpleDateFormat 클래스 입니다.
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String formDate = sdf.format(now);
		
		System.out.println(formDate);
	}
}
