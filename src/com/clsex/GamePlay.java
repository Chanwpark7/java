package com.clsex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.json.JSONObject;

public class GamePlay {
	private static int win;
	private static int lose;
	private static int draw;
	private static int total;

	public JSONObject isPlayed(JSONObject file, File origin) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위|바위|보");
		String strZ = sc.nextLine();
		GamePlay game = new GamePlay();

		FileReader fr = new FileReader(origin);
		BufferedReader br = new BufferedReader(fr);
		JSONObject json = new JSONObject(br.readLine());
		
		this.total = (int)json.get("total");
		this.win = (int)json.get("win");
		this.lose = (int)json.get("lose");
		this.draw = (int)json.get("draw");
		
		return gamePlay(file,game.user(strZ));
		
	}
	
	public JSONObject gamePlay(JSONObject file, int comp) {
		int ran = (int)(Math.random()*3);
		if(ran==0) {
			if(comp==1) {
				win++;
				total++;
				file.put("win", win);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 바위\n컴퓨터 : 가위\n승리!");
				return file;
			}
			if(comp==2) {
				lose++;
				total++;
				file.put("lose", lose);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 보\n컴퓨터 : 가위\n패배..");
				return file;
			}
			if(comp==0) {
				draw++;
				total++;
				file.put("draw", draw);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 가위\n컴퓨터 : 가위\n무승부");
				return file;
			}
		}
		if(ran==1) {
			if(comp==2) {
				win++;
				total++;
				file.put("win", win);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 보\n컴퓨터 : 바위\n승리!");
				return file;
			}
			if(comp==0) {
				lose++;
				total++;
				file.put("lose", lose);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 가위\n컴퓨터 : 바위\n패배..");
				return file;
			}
			if(comp==1) {
				draw++;
				total++;
				file.put("draw", draw);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 바위\n컴퓨터 : 바위\n무승부");
				return file;
			}
		}
		if(ran==2) {
			if(comp==0) {
				win++;
				total++;
				file.put("win", win);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 가위\n컴퓨터 : 보\n승리!");
				return file;
			}
			if(comp==1) {
				lose++;
				total++;
				file.put("lose", lose);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 바위\n컴퓨터 : 보\n패배..");
				return file;
			}
			if(comp==2) {
				draw++;
				total++;
				file.put("draw", draw);
				file.put("total", total);
				file.put("winrate", (int)(win*100/(double)total));
				System.out.println("당신 : 보\n컴퓨터 : 보\n무승부");
				return file;
			}
		}
		return file;
	}
	
	public int user(String z) {
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
	
	public void GameEnd() {
		System.out.println("총 전적 : "+total+"\n승 : "+win+"\n패 : "+lose+"\n무승부 : "+draw+"\n승률 : "+(int)(win*100/(double)total)+"%");
	}
}
