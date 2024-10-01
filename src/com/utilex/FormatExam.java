package com.utilex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 형식 클래스 : 문자열, 숫자, 날짜 등을 특정 포맷으로 설정해서 출력 또는 사용하고자 할 때 사용되는 클래스 집단
 * 최상위 클래스 Formatter, 자식으로 각각의 대상에 따라서 Message, Number, Date 로 상송이 이뤄짐.
 * 우리가 사용하는 클래스는 위 중간 클래스의 최종 자식 클래스나 인터페이스를 사용함.
 */
public class FormatExam {
	public static void main(String[] args) {
		
		double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#,###");
		
		df = new DecimalFormat("#,###.0");
		
		System.out.println(df.format(number));
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 a HH시 mm분");
		System.out.println(sdf.format(now));
		
		 int planet = 7;
		 String event = "a disturbance in the Force";

		 String result = MessageFormat.format(
		     "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
		     planet, new Date(), event);
		 System.out.println(result);
		 
		 int fileCount = 1273;
		 String diskName = "MyDisk";
		 Object[] testArgs = {new Long(fileCount), diskName};

		 MessageFormat form = new MessageFormat(
		     "The disk \"{1}\" contains {0} file(s).");

		 System.out.println(form.format(testArgs));
		 
		 
//		 Locale[] locales = NumberFormat.getAvailableLocales();
//		 double myNumber = -1234.56;
//		 NumberFormat form;
//		 for (int j = 0; j < 4; ++j) {
//		     System.out.println("FORMAT");
//		     for (int i = 0; i < locales.length; ++i) {
//		         if (locales[i].getCountry().length() == 0) {
//		            continue; // Skip language-only locales
//		         }
//		         System.out.print(locales[i].getDisplayName());
//		         switch (j) {
//		         case 0:
//		             form = NumberFormat.getInstance(locales[i]); break;
//		         case 1:
//		             form = NumberFormat.getIntegerInstance(locales[i]); break;
//		         case 2:
//		             form = NumberFormat.getCurrencyInstance(locales[i]); break;
//		         default:
//		             form = NumberFormat.getPercentInstance(locales[i]); break;
//		         }
//		         if (form instanceof DecimalFormat) {
//		             System.out.print(": " + ((DecimalFormat) form).toPattern());
//		         }
//		         System.out.print(" -> " + form.format(myNumber));
//		         try {
//		             System.out.println(" -> " + form.parse(form.format(myNumber)));
//		         } catch (ParseException e) {}
//		     }
//		 }
	}
}
