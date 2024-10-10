package com.ioex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileInOutEx {
	private static final String SOURCE = 
			"E:\\front_Workspace\\myJava\\src\\com\\langex\\lambda\\stream\\FilterStreamEx.java";
	
	private static final String BACKUP = "D:\\ioRoot\\FilterStreamEx.back";
	
	public static void main(String[] args) {
		byte readArr[] = new byte[1000];
		InputStream fileInput = null;
		OutputStream fileOutput = null;
		
		try {
			fileInput = new FileInputStream(SOURCE);
			fileOutput = new FileOutputStream(BACKUP);
			int readData = 0;
			
			fileInput.transferTo(System.err);
			fileInput = new FileInputStream(SOURCE);
			
			fileInput.transferTo(fileOutput);
			
//			while((readData = fileInput.read(readArr)) != -1) {
//				System.out.println("읽은 갯수 : " + readData);
//				for(byte b : readArr) {
//					System.out.print((char)b);
//				}
//				
//				//읽은 내용을 그대로 쓰기
//				fileOutput.write(readArr);
//			}
			
			
			fileInput.close();
			fileOutput.close();
			
			System.out.println("작업 끄읕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
