package com.langex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class ExceptionExam2 {
	private static final String MEMBER_PATH = "E:\\member";
	private static boolean isMade = false;
	private static boolean isNew = false;
	private static String userId = null;
	private static String userPassword = null;
	
	private static boolean makeDir() {
		File dir = new File(MEMBER_PATH);
		return dir.mkdir();
	}
	
	private static void checkMember(File user) throws IOException{
		if(!user.exists()) {//존재 하지 않으면 신규 유저 파일 생성하는 메소드 호출
			creatUser(user);
		}
	}
	
	private static void creatUser(File user){
		//파일에 데이터를 쓰는 Stream 을 이용하여 신규 유저의 파일을 생성.
		FileWriter fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileWriter(user);
			fis = new FileInputStream(user);
			Date reg_date = new Date();
			
			fos.write("암호 : "+userPassword+"\r\n가입일 : "+reg_date.getTime());
			fos.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {//예외 발생 여부와 상관없이 무조건 실행되는 코드
			System.out.println("finally 실행한다아아아아아아아");
		}
		
		System.out.println("파일 확인 좀요");
	}
	
	public static void main(String[] args) throws IOException{
		
		//System.out.println("ID(Email)와 Password 입력하세요");
		String id = JOptionPane.showInputDialog("ID(Email) 입력");
		String pw = JOptionPane.showInputDialog("Password 입력");
		
		//위의 사용자를 관리하는 폴더가 있는지를 확인.
		//만약 없다면 새로 생성.
		File dir = new File(MEMBER_PATH);//얘는 파일에 관련된 모든 일을 함.
		//단, 파일에 데이터 입출력은 불가. 파일에 대한 정보와 빈 파일, 폴더 생성 가능한 아이.
		
		//폴더내에 사용자 ID에 해당하는 파일이 존재하는지 여부와 그 이후(읽고, 쓰고)의 대상이 되는 파일 객체 생성
		File user = new File(dir, id+"com");
		
		if(!dir.exists()) {
			//폴더 생성
			isMade = makeDir();
			if(isMade) {
				System.out.println("폴더가 생겼을지도?");
			}
		}else {//폴더가 존재 한다면 입력된 id의 파일이 존재하는지 확인.
			//System.out.println(checkMember(user));
			//userId = id;
			userPassword = pw;
			checkMember(user);
		}
		
	}
}
