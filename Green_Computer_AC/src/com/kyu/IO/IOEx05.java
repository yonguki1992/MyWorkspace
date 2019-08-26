package com.kyu.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


import MyLib.ScannerFunctions;

public class IOEx05 {
	public static void main(String[] args) {
//		fileOutput();
//		
//		fileInput(); 
		
		/*
		 * 텍스트가 아닌 파일들은 byte 단위 입출력으로 R/W 해야함
		 * 	ex) 음악, jpg 등등
		 */
		String inFile =System.getProperty("user.dir")+"\\etc\\";
		String outFile = System.getProperty("user.dir")+"\\etc\\";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		ScannerFunctions scf = new ScannerFunctions();
		System.out.println("복사할 파일명을 입력");
		inFile += scf.inputText();
		
		System.out.println("저장할 파일명을 입력");
		outFile += scf.inputText();
		
		int n;
		
		byte[] data = new byte[1024];
		try {
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			while((n=fis.read(data))>0) {
				fos.write(data,0,n);
				fos.flush();
			}
			System.out.println(inFile+" -> "+outFile+"copy completed!!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void fileInput() {
		byte[] bA = new byte[10];
		try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\etc\\ex01.dat")){
			System.out.println(fis.read());
			System.out.println(fis.read());
			fis.read(bA);
			System.out.println(Arrays.toString(bA));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void fileOutput() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"\\etc\\ex01.dat");
			fos.write(1);
			fos.write(2);
			fos.write(3);
			fos.write(4);
			fos.write(new byte[] {1,2,3,4,5,6,7,8,9,0});
			fos.flush(); // 버퍼를 강제로 비우기
			System.out.println("저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) fos.close();
			} catch (Exception e2) {

			}
		}
	}
}
