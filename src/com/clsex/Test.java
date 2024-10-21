package com.clsex;

import java.io.File;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		File[] files = new File("E:"+File.separator+"user").listFiles();
		
		GameRanking gr = new GameRanking();
		System.out.println(gr.winRateRankAsc(files));
	}
}
