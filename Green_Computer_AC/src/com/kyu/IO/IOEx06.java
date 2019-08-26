package com.kyu.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx06 {

	public static void main(String[] args) {
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		dataOutput(dos);
		
		try {
			dis = new DataInputStream(new FileInputStream(System.getProperty("user.dir")+"\\etc\\data.dat"));
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static void dataOutput(DataOutputStream dos) {
		try {
			dos = new DataOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\etc\\data.dat"));
			dos.writeByte(1);
			dos.writeChar('C');
			dos.writeInt(1);
			dos.writeDouble(3.14);
			dos.writeUTF("문자열!!");
			
			dos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("saved complete!!");
	}

}
