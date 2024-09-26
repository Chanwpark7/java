package com.clsex;

public class GamePlay {
	private static double counter;
	private static int win;
	private static int lose;
	private static int draw;
	private static int total;

	public GamePlay(int comp) {
		int ran = (int)(Math.random()*3);
		if(ran==0) {
			if(comp==1) {
				win++;
				total++;
				System.out.println("당신 : 바위\n컴퓨터 : 가위\n승리!");
			}
			if(comp==2) {
				lose++;
				total++;
				System.out.println("당신 : 보\n컴퓨터 : 가위\n패배..");
			}
			if(comp==0) {
				draw++;
				total++;
				System.out.println("당신 : 가위\n컴퓨터 : 가위\n무승부");
			}
		}
		if(ran==1) {
			if(comp==2) {
				win++;
				total++;
				System.out.println("당신 : 보\n컴퓨터 : 바위\n승리!");
			}
			if(comp==0) {
				lose++;
				total++;
				System.out.println("당신 : 가위\n컴퓨터 : 바위\n패배..");
			}
			if(comp==1) {
				draw++;
				total++;
				System.out.println("당신 : 바위\n컴퓨터 : 바위\n무승부");
			}
		}
		if(ran==2) {
			if(comp==0) {
				win++;
				total++;
				System.out.println("당신 : 가위\n컴퓨터 : 보\n승리!");
			}
			if(comp==1) {
				lose++;
				total++;
				System.out.println(total);
				System.out.println("당신 : 바위\n컴퓨터 : 보\n패배..");
			}
			if(comp==2) {
				draw++;
				total++;
				System.out.println("당신 : 보\n컴퓨터 : 보\n무승부");
			}
		}
	}
	
	public void GameEnd() {
		System.out.println("총 전적 : "+total+"\n승 : "+win+"\n패 : "+lose+"\n무승부 : "+draw+"\n승률 : "+(int)(win*100/(double)total)+"%");
	}
}
