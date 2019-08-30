package com.kyu.network;

import java.io.IOException;
import java.util.Scanner;

public class ExecEx02 {
	// 실행 결과를 자바로 가져오기
	public static void main(String[] args) {
		//ProcessBuilder pb = new ProcessBuilder("calc.exe");
		ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "dir", "/w");
		try {
			//윈도우 프로그램 실행
			//pb.start();	
			
			//외부 명령어의 결과를 받아서 사용하고자 한다면.
			Process p = pb2.start();
			Scanner sc = new Scanner(p.getInputStream(), "MS949");
			
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
