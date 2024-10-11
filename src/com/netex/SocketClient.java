package com.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	public MultiChatServer multiChatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	
	public String chatName;
	public String clientIp;

	public SocketClient(MultiChatServer multiChatServer, Socket socket) {
		//서버로 온 연결을 이 클라이언트에게 넘기기 때문에, 서버로부터 Socket 생성
		try {
			this.multiChatServer = multiChatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			
			InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//소켓으로부터 메시지 get
	public void receive() {
		multiChatServer.threadPool.execute(() -> {
			try {
				while(true) {
					String receiveJson = dis.readUTF();
					
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");
					
					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						multiChatServer.sendToAll(this,"Enter");
						multiChatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						multiChatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (Exception e) {//클라이언트가 나가면, EOF 예외 발생. 때문에 여기로 로직이 이동. 따라서 해당 클라이언트 삭제
				System.out.println(e.getMessage());
				multiChatServer.sendToAll(this, "Quit");
				multiChatServer.removeSocketClient(this);
			}
		});
	}
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		try {
			socket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
