package com.ioex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamFinalEx {
	public static void main(String[] args) throws Exception{
		File file = new File("fatherAndSon.png");
		System.out.println(file.getName());
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("copy.png");
		int data;
		while((data = fis.read())!=-1) {
			System.out.println(data);
			fos.write(data);
		}
		System.out.println("작업 끄ㅌ");
		fos.close();
		fis.close();
	}
}
