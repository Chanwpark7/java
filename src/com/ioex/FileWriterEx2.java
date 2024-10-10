package com.ioex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileWriterEx2 {
//	private static final String SOURCE = 
//			"E:\\front_Workspace\\myJava\\src\\com\\langex\\lambda\\stream\\FilterStreamEx.java";
	
	private static final String BACKUP = "D:\\ioRoot\\FileWriterEx.back";
	private static Date log_date = new Date();
	
	public static void main(String[] args) {
		File file = null;//파일 객체 선언
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		
		file = new File(BACKUP.substring(0,BACKUP.lastIndexOf("\\"))+"\\msgLog.log");
		System.out.println("From now on, all the messages will be saved");
		
		String msg = null;
		try {
			fw = new FileWriter(file,true);
			while(true) {
				System.out.println("type a message");
				msg = sc.nextLine();
				//입력된 문자열 분석
				if(msg.equalsIgnoreCase("q")||msg.equals("종료")) {
					//이 시점에 모든 기록을 종료하고 빠져나감
					//혹시 모르니 기존의 내용은 flush();
					fw.write(msg+" : "+log_date.toLocaleString());
					fw.flush();
					break;
				}else {
					//여기서부터 파일에 모두 저장
					fw.write(msg+" : "+log_date.toLocaleString()+"\n\r");
					fw.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
