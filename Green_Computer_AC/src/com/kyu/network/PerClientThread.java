package com.kyu.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

//접속자마다 생길 스레드
public class PerClientThread implements Runnable {
	//모든 접속자가 공유해야하므로 static을 사용 동기화가 가능한 리스트를 만든다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket		socket;
	PrintWriter	pw;
	String		name;
	

	//socket을 넘겨받는 생성자
	public PerClientThread(Socket socket) {
		super();
		this.socket = socket;
		try {
			pw = new PrintWriter(this.socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//모든 사용자에게 메시지 보내기
	private void sendAll(String msg) {
		for(PrintWriter pw : list) {
			pw.write(msg+"\n");
			pw.flush();
		}
	}
	
	@Override
	public void run() {
		
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			
			// 첫번째 전송은 이름이라고 친다.
			name = sc.nextLine();
			sendAll("#"+name+"님이 입장했습니다.");
			
			// 다음부터는 메시지다.
			while(true) {
				String msg = sc.nextLine();
				if(StringUtils.equals(msg, null))	break;
				sendAll(name +" > "+msg);
			}
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
