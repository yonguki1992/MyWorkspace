package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import MyLib.ScannerFunctions;

public class EchoServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		PrintWriter pw = null;
		Scanner sc = null;
		ScannerFunctions sf = new ScannerFunctions();
		/*
		 * 서버는 소켓을 열어 클라이언트의 접속을 기다리고 접속하면 클라이언트 소켓을 리턴 통신은 클라이언트 소켓끼리 통신
		 */

		try {
			System.out.println("127.0.0.1의 1004번 포트를 열어 서버를 시작.");
			// 포트 번호를 패러미터로 받아서 포트를 연다. 0 ~ 2^16 -1
			server = new ServerSocket(1004);
			// 클라이언트의 접속을 무한정 대기함.
			client = server.accept();
			// 연결 되면 통신
			System.out.println("연결 성공 : " + client);

			// 클라이언트에 문자를 전송
			pw = new PrintWriter(client.getOutputStream());
			String sendData = sf.inputText();
			System.out.println(sendData);
			pw.write(sendData);
			pw.flush();
			while (true) {
				sc = new Scanner(client.getInputStream());
				String data = sc.nextLine();
				System.out.println("받은 내용 : " + data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				sf.finalize();
				if (sc != null)
					sc.close();
				if (pw != null)
					pw.close();
				if (client != null)
					client.close();
				if (server != null)
					server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
