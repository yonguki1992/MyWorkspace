package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import MyLib.ScannerFunctions;

public class ChatSever {
	public static void main(String[] args) {
		ServerSocket sSocket = null;
		Socket socket = null;
		PrintWriter pw = null;

		Scanner sf1 = null;
		ScannerFunctions sf2 = new ScannerFunctions();

		try {
			System.out.println("서버를 시작했습니다.");
			sSocket = new ServerSocket(9999);
			System.out.println("접속을 기다리는중...");
			socket = sSocket.accept();
			System.out.println("접속 성공 !! : " + socket);
			pw = new PrintWriter(socket.getOutputStream());
			sf1 = new Scanner(socket.getInputStream());

			String msg = "";
	
			do {
				System.out.print("보낼 내용 입력 : ");
				msg = sf2.inputTextLine();
				pw.write(msg + "\n");
				pw.flush();
				
	
				if (StringUtils.equalsIgnoreCase(msg, "Exit")) {
					continue;
				}
				msg = sf1.nextLine();
				System.out.println("받은 내용 : "+msg);
				
			} while (!StringUtils.equalsIgnoreCase(msg, "Exit"));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if(sf1!=null)
					sf1.close();
				sf2.finalize();
				if (pw != null)
					pw.close();
				if (socket != null)
					socket.close();
				if (sSocket != null)
					sSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
