package com.langex;

import java.util.Enumeration;
import java.util.Properties;

public class SystemExam {
	public static void main(String[] args) {
		System.out.println("Hello");
		
		//운영객체의 정보를 get 해보도록 함.
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		
		Properties properties = System.getProperties();
		Enumeration enu = properties.propertyNames();
		
		while(enu.hasMoreElements()) {
			String key = (String)enu.nextElement();
			String value = properties.getProperty(key);
			System.out.printf("%-40s: %s\n",key,value);
		}
	}
}
