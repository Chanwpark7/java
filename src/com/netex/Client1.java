package com.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client1 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.137",10000);
			System.out.println("클라이언트 연결 성공");
			
			//data in-out
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String toServer = "\'유저\'님으로부터 메시지 : 밤길 조심해";
			dos.writeUTF(toServer);
			dos.flush();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fromServer = dis.readUTF();
			System.out.println("\'서버\'님으로부터 메시지 : "+fromServer);
			
			
			
			socket.close();
			System.out.println("클라이언트 연결 종료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
