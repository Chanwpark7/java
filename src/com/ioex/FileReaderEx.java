package com.ioex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FileReaderEx {
	private static final String BACKUP = "D:\\ioRoot\\";
	public static void main(String[] args) {
		File files = null;
		BufferedReader fileReader = null;
		LineNumberReader line = null;
		
		try {
			fileReader = new BufferedReader (new FileReader(BACKUP+"msgLog.log"), 2048);
			line = new LineNumberReader(fileReader);
			InputStream is = new FileInputStream(BACKUP+"msgLog.log");
			InputStreamReader ir = new InputStreamReader(is);
			System.out.println("문자셋 : "+ir.getEncoding());
			
			String data = "";
			while((data=line.readLine())!=null) {
				System.out.println(line.getLineNumber()+"."+data);
			}
			
			//filter 를 사용후엔, 스트림을 닫을 때 역순으로 닫거나, 마지막 스트립의 close만 호출해주면 됨.
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
