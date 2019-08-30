package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSever {

	public static void main(String[] args) {
		ServerSocket sv = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");

		try {
			
			while (true) {
				Socket client = sv.accept();
				System.out.println("접속 : "+client);
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.write(sdf.format(new Date()) + "\n");
				pw.close();
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
