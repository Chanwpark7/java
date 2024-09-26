package com.clsex;

import java.util.Scanner;

public class GawiBawiBo {
	/*
	 * 가위바위보 게임 : 이 클래스에서 시작을 하고, 최소 3개 이상의 클래스를 정의해서 완성.
	 * 
	 * 게임 룰은 게임 시작 출력 후, ID(Email) 입력을 하라고 하고, 본인 Email과 passwd 가 아니면 게임을 종료.(ID 가 틀림 메시지 출력.)
	 * 만약 인증이 되면, 기존 룰대로 입력을 받고 (가위, 바위, 보) 랜덤한 컴과 승부 후 결과를 출력. ex) 컴 : 가위, 유저 : 보 유저 패배
	 * 이후 계속 게임을 할건지에 대한 질문을 출력하고 y/n 으로 결정.
	 * 게임이 끝나면 총 전적과 승률등을 출력시키고 게임을 종료.
	 */
	public static void main(String[] args) {
		int accNum = 0;
		boolean run = false;
		GameAccount[] accounts = new GameAccount[100];
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디(Email)를 입력하세요.");
		String strX = scanner.nextLine();
		
		System.out.println("비밀번호를 입력하세요.");
		String strY = scanner.nextLine();
		if(accNum == 0) {
			accounts[accNum] = new GameAccount(strX,strY);
			accNum++;
		}
		
		if(accNum>0) {
			System.out.println("아이디(Email)를 입력하세요.");
			String strXX = scanner.nextLine();
			
			System.out.println("비밀번호를 입력하세요.");
			String strYY = scanner.nextLine();
			
			for(int i = 0;i<accNum;i++) {
				if(accounts[i].getID().equals(strXX)&&accounts[i].getPW().equals(strYY)) {
					run=true;
				}else {
					System.out.println("올바른 아이디를 입력하세요.");
					run=false;
				}
			}
			System.out.println("게임 시작\n---------------------\n");
			while(run){
				System.out.println("가위|바위|보");
				String strZ = scanner.nextLine();
				GamePlay game = new GamePlay(Game(strZ));
				System.out.println("---------------------\n계속 하시겠습니까? y|n");
				String strC = scanner.nextLine();
				if("n".equals(strC)) {
					game.GameEnd();
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
			}
		}
	}
	
	public static int Game(String z) {
		if("가위".equals(z)) {
			return 0;
		}
		if("바위".equals(z)) {
			return 1;
		}
		if("보".equals(z)) {
			return 2;
		}
		return 3;
	}
}
