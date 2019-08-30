package com.kyu.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

public class WinServer extends JFrame implements ActionListener, Runnable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4531043375727229364L;
	JTextArea	ta;
	JTextField	tf;
	JButton 	sndBtn;
	Socket		socket;
	PrintWriter pw;
	
	public WinServer() {
		setSize(500, 700);
		setTitle("허접한 채팅");
		setLocationRelativeTo(null);	// 화면 중앙에 배치
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		ta = new JTextArea(20,40);
		ta.setEditable(false);		//수정 불가
		JScrollPane centerPane = new JScrollPane(ta);	// 텍스트 영역에 스크롤바 만들기
		add(centerPane, BorderLayout.CENTER);	//중앙에 텍스트 영억 붙이기
		
		JPanel bottomPane = new JPanel();	//하단 판넬
		tf = new JTextField(37);			//입력 영역
		sndBtn = new JButton("전송");		// 버튼
		
		tf.addActionListener(this);
		sndBtn.addActionListener(this);
		
		bottomPane.add(tf);					//하단에 입력 영역 붙이기	
		bottomPane.add(sndBtn);				// 하단 영역에 버튼 붙이고
		
		add(bottomPane, BorderLayout.SOUTH);
		
		setVisible(true);
		tf.setEnabled(false);
		sndBtn.setEnabled(false);
	}

	public static void main(String[] args) {
		WinServer ws = new WinServer();
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
			ws.ta.append("1004번 포트를 열어서 서버를 시작합니다.\n");
			ws.ta.append("클라이언트의 접속을 기다리는 중...\n");
			ws.socket = serverSocket.accept();
			ws.ta.append("접속 성공 : "+ws.socket+"\n");
			ws.pw = new PrintWriter(ws.socket.getOutputStream());
			//접속에 성공하면 받는 스레드 시작
			Thread th = new Thread(ws);
			th.setDaemon(true); // 데몬 스레드로 만듦
			th.start();
			
			ws.tf.setEditable(true);
			ws.tf.setEnabled(true);
			ws.sndBtn.setEnabled(true);
			ws.tf.requestFocus();				//커서를 옮김
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void run() {
		//	내용을 받아서 TA에 출력....
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			while(true) {
				String msg = sc.nextLine();
				if(StringUtils.equals(msg, null)) break;
				ta.append("너 > "+msg+"\n");
			}
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//전송 버튼 눌렀을 때 동작 구현

		String msg = tf.getText();
		
		if(msg.trim().length() > 0) {
			ta.append("나 > "+msg.trim()+"\n");
			pw.write(msg.trim()+"\n");
			pw.flush();
		}
		tf.setText("");
		tf.requestFocus();
	}

}
