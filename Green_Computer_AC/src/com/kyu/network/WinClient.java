package com.kyu.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

public class WinClient extends JFrame implements ActionListener, Runnable{
	
	private static final long serialVersionUID = -8798013992048224734L;
	JTextArea	ta;
	JTextField	tf;
	JButton 	sndBtn;
	Socket		socket;
	PrintWriter pw;
	
	public WinClient() {

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
		
	}

	public static void main(String[] args) {
		WinClient wc = new WinClient();
		try {
			String ip = JOptionPane.showInputDialog("접속할 서버의 ip를 입력하세요");
			wc.ta.append(ip+"의 9999 포트에 접속합니다.\n");
			wc.socket = new Socket(ip,9999);
			wc.ta.append("서버에 접속했습니다."+wc.socket+"\n");
			wc.pw = new PrintWriter(wc.socket.getOutputStream());			
			//첫번째 전송은 이름(name)
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			wc.pw.write(name+"\n");
			wc.pw.flush();
			
			wc.pw = new PrintWriter(wc.socket.getOutputStream());
			
			Thread th = new Thread(wc);
			th.setDaemon(true);
			th.start();
			
			wc.tf.requestFocus();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				ta.append(msg+"\n");
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
//			ta.append("나 > "+msg.trim()+"\n");
			pw.write(msg.trim()+"\n");
			pw.flush();
		}
		tf.setText("");
		tf.requestFocus();
	}

}
