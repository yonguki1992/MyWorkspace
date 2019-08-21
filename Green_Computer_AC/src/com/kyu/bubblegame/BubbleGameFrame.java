package com.kyu.bubblegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleGameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BubbleGameFrame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir")+"\\images\\bubble.jpg");

		new BubbleGameFrame();
	}
}

class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamePanel() {
		setLayout(null);
		NameLabel nlabel = new NameLabel(0, 0);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new Thread(new BubbleThread(e.getX(), e.getY())).start();
				nlabel.extendingSize();
				
				
			}
		});
	}

	class NameLabel{
		private JLabel nameTag;
		private int fontSize = 15;
		private Font font = new Font("돋움", Font.PLAIN, fontSize);
		public NameLabel(int pointX, int pointY) {
			// TODO Auto-generated constructor stub
			
			nameTag = new JLabel("김용욱");
			nameTag.setSize(100, 100);
			nameTag.setLocation(pointX, pointY);
			nameTag.setFont(font);
			add(nameTag);
		}
		
		public void extendingSize() {
			nameTag.setFont(new Font("돋움", Font.PLAIN, fontSize++));
			if(fontSize > 33) {
				nameTag.setSize(nameTag.getSize().width++, nameTag.getSize().height++);
			}
		}
		
	}
	class BubbleThread implements Runnable {
		private JLabel bubble;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon(System.getProperty("user.dir")+"\\images\\bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(), img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); // GamePanel에 add()
			repaint();
		}

		public void run() {
			while (true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5;
				if (y < -(bubble.getSize().height)) {
					remove(bubble);
					repaint();
					return; // thread ends
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) { }
			}
		}
	}
}
