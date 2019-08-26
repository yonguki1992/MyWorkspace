package com.kyu.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOEx07 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		objectOutput(oos);
		/*
		 * 클래스(Object)를 파일로 저장하려면
		 * OOS와 OIS 를 사용
		 */
		objectInput(ois);
		
	}

	private static void objectInput(ObjectInputStream ois) {
		try {
			ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\etc\\object.dat"));
			System.out.println(ois.readByte());
			System.out.println(ois.readChar());
			System.out.println(ois.readInt());
			System.out.println(ois.readDouble());
			System.out.println(ois.readUTF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void objectOutput(ObjectOutputStream oos) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\etc\\object.dat"));
			oos.writeByte(1);
			oos.writeChar('C');
			oos.writeInt(1);
			oos.writeDouble(3.14);
			oos.writeUTF("문자열!!");
			
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("saved complete!!");
	}

}
