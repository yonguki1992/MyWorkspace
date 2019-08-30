package com.kyu.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		Scanner sc = null;
		
		try {
			socket = new Socket("127.0.0.1", 1004);
			
			sc = new Scanner(socket.getInputStream());
			String time = sc.nextLine();
			
			System.out.println("받은 시간 : "+time);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
