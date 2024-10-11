package com.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * InetAddress : 인터넷의 URL 정보나 로컬 IP에 대한 정보를 관리하는 객체
 * 포트정보, 호스트 정보등을 얻어낼 수 있음.
 */

class Server1{
	private static ServerSocket serverSocket = null;
	
	public static void StartServer() {
		//tcp 서버 시작
		Thread thread = new Thread(() -> {
			try {
				serverSocket = new ServerSocket(10000);
				System.out.println("[Server] started");
				while(true) {//서버 소켓이 시작되었으니 이젠 각 요청이 오는 클라이언트를 accept()로 대기하다가 Socket을 생성
					System.out.println("Server is waiting for connection from client");
					
					Socket socket = serverSocket.accept();
					
					//연결된 소켓으로부터 클라이언트 정보를 얻어내는 InetSocketAddress 를 이용
					InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
					System.out.println("[Server] "+isa.getAddress()+"is connected");
					
					//연결된 소켓을 이용해서 데이터를 주고 받는 영역
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					String msg = dis.readUTF();
					
					System.out.println("client message : "+msg);
					
					//이번엔 서버가 메세지를 보냄
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					dos.writeUTF("\'서버\'님으로부터 메시지 : 바보 같은 녀석");
					dos.flush();
					
					socket.close();
					System.out.println("[Server] "+isa.getHostName()+"is disconnected");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		thread.start();
	}
	
	void readyServer() throws Exception{
		System.out.println("---------------------");
		System.out.println("q or Q 입력 시 서버 종료.");
		System.out.println("---------------------");
		
		StartServer();
		
		//Scanner 로부터 입력받기
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String key = sc.nextLine();
			if(key.equalsIgnoreCase("q"))
				break;
		}
		sc.close();
		stopServer();
	}
	
	public static void stopServer() {
		try {
			if(serverSocket != null) {
				serverSocket.close();
				System.out.println("Server closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class InetExam {
	public static void main(String[] args) throws Exception{
		//로컬 정보 얻어내
//		InetAddress local = InetAddress.getLocalHost();
//		System.out.println("My IP : "+local);
//		
//		InetAddress[] addres = InetAddress.getAllByName("www.naver.com");
//		for(InetAddress inet : addres) {
//			System.out.println(inet.getHostAddress());
//			System.out.println(inet.getHostName());
//		}
		
		Server1 server = new Server1();
		server.readyServer();
	}
}
