package com.kyu.network;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class ReceiverThread implements Runnable {
	private Socket socket;

	
	public ReceiverThread(Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 데이터가 있으면 받아서 출력한다.
		try( Scanner sc = new Scanner(socket.getInputStream()) ) {
			while (true) {
				String msg = sc.nextLine();
				if(StringUtils.equals(msg, null)) 
					break;
				System.out.println("받은 내용 : "+msg);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
