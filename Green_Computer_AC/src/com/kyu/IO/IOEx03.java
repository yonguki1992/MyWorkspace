package com.kyu.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 *  문자 단위 입력 : Reader 객체가 최고 조상
 */

public class IOEx03 {
	public static void main(String[] args) {
		Reader fr = null;
		
		try {
			fr = new FileReader(System.getProperty("user.dir")+"\\etc\\IOEx02.txt");
//			char ch = ' ';
//			while(( ch = (char)fr.read() ) != -1){
//				System.out.print(ch);
//			}
//			
//			int ch2 = 0;
//			while((ch2 = fr.read()) != -1){
//				System.out.print((char)ch2);
//			}
			int n = 0;
			char[] data = new char[1024];
			while( ( n=fr.read(data) ) > 0 ) {
				System.out.println(new String(data,0,n));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
