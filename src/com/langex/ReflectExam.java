package com.langex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.clsex.Animal;
import com.clsex.Cat;

import my_lib.userlib.MyClassA;

/*
 * 자바 Reflection : 자바에서는 실행시에 주어진 특정 클래스를 Class 객체로 생성해서 원할시엔 해당 클래스의 내용부를
 * 읽어내로, 호출할 수도 있다.이를 가능하게 하는 클래스가 java.lang 의 Class class임
 * 
 * 위에서처럼 Class 객체를 생성하는 방법은 아래처럼 3개 중 하나를 이용한다.
 * 
 * 1. Class.class 호출
 * 2. Class.forName("패키지를 포함한 클래스명")
 * 3. ref변수.getClass()
 */
public class ReflectExam {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Class cls = null;
		
		cls = ReflectExam.class;
		System.out.println(cls);
		
		cls = Class.forName("com.clsex.Animal");
		System.out.println(cls);
		
		Animal cat = new Cat(null,null);
		cls.getClass();
		System.out.println(cat);
		
		MyClassA a = new MyClassA();
		Class cls2 = Class.forName("my_lib.userlib.MyClassA");
		System.out.println(cls2);
		
		//클래스와 같은 경로에 있는 자원에 대한 path 정보 얻어내기
		Class resCls = ReflectExam.class;
		String imgPath = resCls.getResource("couple.png").getPath();
		System.out.println(imgPath);
		
		File dist = new File("E:\\cast","couple.png");
		InputStream ins = resCls.getResourceAsStream("couple.png");
		FileOutputStream fos = new FileOutputStream(dist);
		int data;
		while((data=ins.read())!=-1) {
			fos.write(data);
		}
		fos.close();
		ins.close();
		
		System.out.println("file 복사 완료");
	}
}
