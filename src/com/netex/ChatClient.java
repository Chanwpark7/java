package com.netex;
//클라이언트의 서버 접속 및 서버와의 데이터 입출력 정의

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	public void connect() throws Exception{
		socket = new Socket("192.168.0.225",50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[client] is connected to server");
	}
	
	//서버의 데이터 get 메소드 정의
	public void receive() {
		Thread thread = new Thread(() -> {
			try {
				while(true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<"+chatName+"@"+clientIp+">"+message);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		thread.start();
	}
	
	public void send(String json) throws Exception{
		dos.writeUTF(json);
		dos.flush();
	}
	
	public void disConnect() throws Exception{
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("대화명 입력 : ");
			chatClient.chatName = sc.nextLine();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);
			
			chatClient.receive();
			
			System.out.println("============");
			System.out.println("메시지 입력 : ");
			System.out.println("채팅 종료시 q 입력");
			System.out.println("============");

			while(true) {
				String message = sc.nextLine();
				if(message.equalsIgnoreCase("q"))break;
				else {
					jsonObject = new JSONObject();
					jsonObject.put("command","message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			sc.close();
			chatClient.disConnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
