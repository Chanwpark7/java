package com.ioex;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("D:\\ioRoot\\bwriter.txt");
			bw = new BufferedWriter(fw);
			
			String msg = "This is message";
			
			bw.write(msg);
			bw.newLine();
			bw.write("This might be a message");
			
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
