package com.kyu.network;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MultiChatServer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1719496572062650969L;

	JTextArea	ta;

	public MultiChatServer() {
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
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		MultiChatServer mcs = new MultiChatServer();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
			mcs.ta.append("9999포트를 열었습니다.\n ");
			
			while (true) {
				Socket socket = serverSocket.accept();
				mcs.ta.append("접속 성공 :" +socket+"\n");
//				String name = JOptionPane.showInputDialog("이름을 입력하세요");
				Thread th =  new Thread(new PerClientThread(socket));
				th.start();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Override
//	public void run() {
//		//	내용을 받아서 TA에 출력....
//		try {
//			Scanner sc = new Scanner(socket.getInputStream());
//			while(true) {
//				String msg = sc.nextLine();
//				if(StringUtils.equals(msg, null)) break;
//				ta.append("너 > "+msg+"\n");
//			}
//			sc.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		//전송 버튼 눌렀을 때 동작 구현
//
//		String msg = tf.getText();
//		
//		if(msg.trim().length() > 0) {
//			ta.append("나 > "+msg.trim()+"\n");
//			pw.write(msg.trim()+"\n");
//			pw.flush();
//		}
//		tf.setText("");
//		tf.requestFocus();
//	}

}
