package com.clsex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = null;
		GameAccount ga = null;
		boolean run = true;
		boolean isStarted = false;
		GameUser gameStart = new GameUser();
		
		//실행시 user 폴더 생성
		File dirs = new File("E:"+File.separator+"user");
		dirs.mkdirs();
		
		while(run) {
			System.out.println("1.로그인\n2.회원가입\n3.비번 변경\n4.내 전적보기\n5.순위 보기");
			String strX = sc.nextLine();
			int intX = Integer.parseInt(strX);
			
			if(intX==1) {
				System.out.println("아이디(Email)를 입력하세요.");
				String id = sc.nextLine();
		
				System.out.println("비밀번호를 입력하세요.");
				String pw = sc.nextLine();
		
				File file = new File("E:"+File.separator+"user"+File.separator+id);
				
				if(file.exists()) {//존재 여부 확인
					ga = new GameAccount(id, pw);
					Calendar now = Calendar.getInstance();
					System.out.println("마지막으로 로그인 한 시각 : "+now.get(Calendar.YEAR)+"년 "+(now.get(Calendar.MONTH)+1)+"월 "+now.get(Calendar.DATE)+"일 "+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND));
					
					isStarted = true;

					System.out.println("1.가위바위보 게임하기\n2.전체 랭크 보기");
					String strY = sc.nextLine();
					int intY = Integer.parseInt(strY);
					if(intY == 1) {
						while(isStarted) {
							gameStart.gameUser();
						}
					}else if(intY == 2) {
						System.out.println(2);
					}
				}else {
					System.out.println(2);
				}
				
			}else if(intX==2) {
				System.out.println("아이디(Email)를 입력하세요.");
				String newId = sc.nextLine();
		
				System.out.println("비밀번호를 입력하세요.");
				String newPw = sc.nextLine();
		
				File file = new File(dirs,newId);
				try {
					if(file.createNewFile()) {//파일 생성 되었다면
						bw = new BufferedWriter(new FileWriter(file));
						
						bw.write("id:"+newId+"\n");
						bw.write("pw:"+newPw);
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(intX==3) {
				
			}else if(intX==4) {
				
			}else if(intX==5) {
				
			}
		}
	}
}
