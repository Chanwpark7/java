package com.utilex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 * Calendar 클래스 : Date 클래스를 대체한 API. 날짜와 시간에 관련된 정보를 다양하게 표현하는 API
 * 객체는 getInstance() 로 얻어내고, 얻어낸 시점에 시스템의 시간정보를 가져와서 모든 필드값을 초기화 시킴.
 * 이후 초기화된 필드의 정보는 get() 을 통해서 얻어내는데, 이때 파라미터로 사용되는 field 는 반드시 Calender.Field로 줘야 함.
 * 도한 Calendar 는 Date 와 호환할 수 있는 메소드를 갖고 있기 때문에 적절히 Date 와 호환성을 유지할 수 있음.
 */
public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		int year = now.get(Calendar.YEAR);
		int mon = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY: strWeek = "월";break;
			case Calendar.TUESDAY: strWeek = "화";break;
			case Calendar.WEDNESDAY: strWeek = "수";break;
			case Calendar.THURSDAY: strWeek = "목";break;
			case Calendar.FRIDAY: strWeek = "금";break;
			case Calendar.SATURDAY: strWeek = "토";break;
			case Calendar.SUNDAY: strWeek = "일";break;
			default : strWeek = "break";break;
		}
		
		int apm=now.get(Calendar.AM_PM);
		String strApm = null;
		if(apm==Calendar.AM) {
			strApm = "AM";
		}else {
			strApm = "PM";
		}
		
		int hour = now.get(Calendar.HOUR);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		
		System.out.println(year+"년 "+mon+"월 "+day+"일 "+strWeek+"요일 "+strApm+" "+hour+"시 "+min+"분 "+sec+"초");
	
		Calendar xMas = Calendar.getInstance();
		xMas.set(2024, 11, 25);
		
		int remain = xMas.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
		System.out.println(remain);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String sdf1 = sdf.format(xMas.getTime());
		System.out.println(sdf1);
		
		String[] tmz = TimeZone.getAvailableIDs();
		for(int i = 0; i<tmz.length;i++) {
			System.out.println(tmz[i]);
		}

		TimeZone win = TimeZone.getTimeZone("US/Central");
		System.out.println(win);
		Calendar now1 = Calendar.getInstance(win);
		int hour1 = now1.get(Calendar.HOUR);
		int apm1 = now1.get(Calendar.AM_PM);
		String strApm1 = null;
		if(apm1==Calendar.AM) {
			strApm1 = "AM";
		}else {
			strApm1 = "PM";
		}
		System.out.println(strApm1+" "+hour1);
	}
}
