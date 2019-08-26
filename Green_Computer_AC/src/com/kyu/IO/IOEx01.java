package com.kyu.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * 문자 단위 입출력 : Reader/Writer 라는 조상 클래스가 있다.
 */
public class IOEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 입출력기 준비
		Writer wr = null;
		try {
			// 2. 열기
			wr = new FileWriter(System.getProperty("user.dir")+"\\etc\\IOEx01.txt");
			// 3. 사용
			wr.append("Hello World\n")
			  .append("Hello World\n");
			System.out.println("저장 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			try {
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
