package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import MyLib.ScannerFunctions;

public class EchoClient {

	public static void main(String[] args) {
		/*
		 * 서버에 접속한다. 통신한다.
		 */
		Socket client = null;

		Scanner sc = null;
		PrintWriter pw = null;
		ScannerFunctions sf = new ScannerFunctions();

		try {
			
			// IP 주소와 포트번호로 소켓 객체를 생성하면 서버에 접속이 된다.
			client = new Socket("127.0.0.1", 1004);
			System.out.println("서버에 연결 성공 : " + client);

			// 서버에서 스트림 받아오기
			sc = new Scanner(client.getInputStream());
			String data = sc.nextLine();
			System.out.println("받은 내용 : " + data);

			pw = new PrintWriter(client.getOutputStream());
			pw.write("dd");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pw != null)
					pw.close();
				if (sc != null)
					sc.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
