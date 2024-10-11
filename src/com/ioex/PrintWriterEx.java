package com.ioex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterEx {
	public static void main(String[] args) throws Exception{
		String filePath = "D:\\ioRoot\\FilterStreamEx.back";
		BufferedReader br = null;

		br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		bw = new BufferedWriter(new FileWriter("writerTest.java"));
		pw = new PrintWriter(bw,true);
		String str;
		while((str = br.readLine()) != null) {
			System.out.println(str);
			pw.println(str);
		}
		
		pw.close();
		br.close();
		
	}
}
