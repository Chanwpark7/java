package com.clsex;

import java.util.Scanner;

public class GameUser {
	Scanner scanner = new Scanner(System.in);
	boolean run = true;
	
	public void gameUser() {
		System.out.println("게임 시작\n---------------------\n");
		while(run){
			System.out.println("가위|바위|보");
			String strZ = scanner.nextLine();
			GamePlay game = new GamePlay();
			game.gamePlay(game.user(strZ));
			
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
