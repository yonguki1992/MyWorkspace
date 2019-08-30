package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;

import MyLib.ScannerFunctions;

public class SendThread implements Runnable{
	
	private Socket socket;

	public SendThread(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		ScannerFunctions sf = new ScannerFunctions();
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			while(true) {
				System.out.println("보낼 내용 입력 : ");
				String msg = sf.inputText();
				if(StringUtils.equalsIgnoreCase(msg, "bye")) 
					break;
				pw.write(msg);
				pw.flush();
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sf.finalize();
		}
		

	}
}
