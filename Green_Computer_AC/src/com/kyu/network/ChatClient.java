package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import MyLib.ScannerFunctions;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		PrintWriter pw = null;
		Scanner sf1 = null;
		ScannerFunctions sf2 = new ScannerFunctions();

		try {
			System.out.println("서버에 접속합니다.");
			socket = new Socket("127.0.0.1", 9999);
			System.out.println("접속 성공 : " + socket);
			sf1 = new Scanner(socket.getInputStream());
			pw = new PrintWriter(socket.getOutputStream());
			String msg = "";
			do {
				
				msg = sf1.nextLine();
				System.out.println("받은 내용 : "+msg);
				
				if(StringUtils.equalsIgnoreCase(msg, "Exit")) continue;
				
				System.out.print("보낼 내용 입력 : ");
				msg = sf2.inputTextLine();
				pw.write(msg + "\n");
				pw.flush();
				
			} while(!StringUtils.equalsIgnoreCase(msg, "Exit"));

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				sf1.close();
				sf2.finalize();
				if(pw != null)
					
					pw.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
