package com.ioex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	private static final String SOURCE = 
			"E:\\front_Workspace\\myJava\\src\\com\\langex\\lambda\\stream\\FilterStreamEx.java";
	
	private static final String BACKUP = "D:\\ioRoot\\FileWriterEx.back";
	
	public static void main(String[] args) {
		File file = null;//파일 객체 선언
		FileWriter fw = null;
		
		String msg = "Hello World";
		
		file = new File(BACKUP.substring(0,BACKUP.lastIndexOf("\\"))+"\\writer.txt");
		System.out.println(file.getAbsolutePath());
		try {
			fw = new FileWriter(file,true);
//			for(int i = 0; i<msg.length();i++) {
//				fw.write(msg.charAt(i));
//			}
			fw.write("\nThis is it");
			System.out.println("파일 작성완료");

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
