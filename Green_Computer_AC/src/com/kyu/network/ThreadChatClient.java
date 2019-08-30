package com.kyu.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadChatClient {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			System.out.println("접속 대기중...");
			socket = new Socket("192.168.0.123", 9999);
			
			System.out.println("접속 성공!!!");
			//스레드 시작
			Thread rThread = new Thread(new ReceiverThread(socket));
			Thread sThread = new Thread(new SendThread(socket));
			
			rThread.start();
			sThread.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
