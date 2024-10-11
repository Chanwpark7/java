package com.netex;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class MultiChatServer {
	
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	
	//클라이언트의 메시지를 저장하는 Map 생성. 단, 동기화의 대상이기 때문에 동기화된 맵을 사용함.
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap());
	
	//서버 start() 정의
	public void start() throws Exception{
		serverSocket = new ServerSocket(50001);
		System.out.println("[Server] Starts");
		
		Thread thread = new Thread(()->{
			try {
				while(true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this,socket);
				}
			} catch (Exception e) {
				System.out.println("Server thread created exception");
				System.out.println(e.getMessage());
			}
		});
		thread.start();
	}
	
	//클라이언트 연결시 SocketClient 추가 메소드 정의
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println(key+"님께서 입장하셨습니다.");
		System.out.println("현재 채팅자 수 : "+chatRoom.size() + "\n");
	}
	
	//클라이언트 채팅 종료시 소켓 제거 메소드 정의
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		//맵에서 제거
		chatRoom.remove(key);
		System.out.println(key+"님께서 퇴장하셨습니다.");
		System.out.println("현재 채팅자 수 : "+chatRoom.size() + "\n");
	}
	
	//서버에 저장된 사용자 메세지를 JSON 형태로 변환 후 연결된 모든 클라이언트에게 전송 메소드 정의
	public void sendToAll(SocketClient client, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", client.clientIp);
		root.put("chatName", client.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		for(SocketClient sc : socketClients) {
			if(sc == client)continue;
			sc.send(json);
		}
	} 
	
	//server stop 정의. 모든 연결된 socket 을 다 닫음
	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdown();
			chatRoom.values().stream().forEach(sc ->sc.close());
			System.out.println("[Server] closed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			MultiChatServer chatServer = new MultiChatServer();
			chatServer.start();
			
			System.out.println("-------------------");
			System.out.println("서버 종료시 q 입력");
			System.out.println("-------------------");
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				String key = sc.nextLine();
				if(key.equalsIgnoreCase("q"))break;
			}
			sc.close();
			chatServer.stop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
