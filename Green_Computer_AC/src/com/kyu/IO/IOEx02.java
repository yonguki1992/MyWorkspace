package com.kyu.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * 문자 단위 입출력 : Reader/Writer 라는 조상 클래스가 있다.
 */
public class IOEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 입출력기 준비 및 열기(try 문 벗어나면 자동으로 닫힘)
		try(Writer wr = new FileWriter(System.getProperty("user.dir")+"\\etc\\IOEx02.txt", true)) {
			// 2. 사용
			wr.append("Hello World\n")
			  .append("Hello World\n")
			  .flush();		// flush : 버퍼를 비움
			
			System.out.println("저장 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
