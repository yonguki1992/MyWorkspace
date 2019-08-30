package com.kyu.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadChatSever {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			System.out.println("서버 시작");
			serverSocket = new ServerSocket(9999);
			System.out.println("접속을 기다리는중...");
			socket = serverSocket.accept();
			
			System.out.println("접속 성공!!!");
			//스레드 시작
			Thread rThread = new Thread(new ReceiverThread(socket));
			Thread sThread = new Thread(new SendThread(socket));
			
			rThread.start();
			sThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
