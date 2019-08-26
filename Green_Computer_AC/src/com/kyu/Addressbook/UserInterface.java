package com.kyu.Addressbook;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

import org.apache.commons.lang3.StringUtils;

public class UserInterface {
	private static UserInterface uiInstance;
	static boolean isRunOnce = true;
	static boolean flag = true;

	private int imenu = 0;
	private Addressbook addBook = new Addressbook();

	private UserInterface() {
		UIinit();
	}

	// UI는 하나만 존재함
	public static UserInterface getUiInstance() {
		if (uiInstance == null) {
			uiInstance = new UserInterface();
		}
		return uiInstance;
	}

	public void createUI() {

		DataInputStream dis = new DataInputStream(System.in);
		int cnt = 0;
		while (flag) {
			// 언어선택
			selectLanguage();
			if (addBook != null) {
				addBook.displayMenu();
			}
		}
	}

	// 언어 선택
	public void selectLanguage() {
		DataInputStream dis = new DataInputStream(System.in);
		// 최초 실행시만 실행
		if (isRunOnce) {
			if (imenu != -1) {
				System.out.print("사용할 언어를 선택해 주세요.(0)한국어 (1)영어 >  ");
			}
			try {
				// cnt++;
				imenu = Integer.parseInt(dis.readLine());

			} catch (Exception e) {
				System.out.print("올바른 언어를 입력해 주세요.(0)한국어 (1)영어 > ");
				imenu = -1;
				return;
			}

			// 0 : 한국어, 1 : 영어
			switch (imenu) {
			case 0:
				addBook = new AddressbookKor();
				isRunOnce = false;
				break;
			case 1:
				addBook = new AddressbookEng();
				isRunOnce = false;
				break;
			default:
				System.out.print("올바른 언어를 입력해 주세요.(0)한국어 (1)영어 > ");
				imenu = -1;
				break;
			}

		}
	}

	private void UIinit() {
//		String str =addBook.getFilePath();
//		if(StringUtils.equals(str,null)) {
//			System.out.println("비어있음");
//			return;
//		}
//		System.out.println(addBook.getFilePath());
		try {
			// 파일 객체 생성
			File file = new File(addBook.getFilePath());
			FileReader reader = new FileReader(file);

			int cursor = 0;
			String str = "";
			//reader.read();
			while ((cursor = reader.read()) != -1) {
				str += (char)cursor;
			}
			System.out.print(str);
			System.out.println();
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}

	}

	// 프로그램 초기화
	void resetAddBook() {
		isRunOnce = true;
	}

}
