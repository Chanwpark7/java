package com.utilex.collection;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/*
 * Properties 객체 : .properties 로 저장된 파일에 key = value 로 정보를 저장하고
 * 특정 클래스가 이 정보가 필요할때, 객체를 생성 후 정보를 활용할때 주로 사용함.
 * 이 파일을 읽을 때는 일반적으로 InputStream 객체가 연결되어야하는데,
 * load()에서 스트립을 연결함.
 * 연결된 이후에는 getter 를 통해 key에 해당하는 정보를 얻어내면 끝.
 */
public class PropertiesExam {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		
		//properties file load. 같은 경로에 있을 때는 class.get...() 를 이용해서 얻어낼 수 있음.
		prop.load(PropertiesExam.class.getResourceAsStream("db.properties"));
		
		//Iterator의 이전번전의 내부순환객체인 Enumeration 을 이용해서 각 키를 얻어냄.
		Enumeration enumer = prop.keys();
		while(enumer.hasMoreElements()) {
//			System.out.println(enumer.nextElement());
			String key = (String)enumer.nextElement();
			String value = prop.getProperty(key);
			
			System.out.println(key+"="+value);
		}
	}
}
