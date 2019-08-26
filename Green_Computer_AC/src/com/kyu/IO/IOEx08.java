package com.kyu.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOEx08 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		ObjectOutputStream oos = null;
		dateIO(sdf, oos);
	}

	private static void dateIO(SimpleDateFormat sdf, ObjectOutputStream oos) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\etc\\object.dat"));
			oos.writeObject(new Date());
			oos.flush();
			
			System.out.println("저장 완료!! 3초후에 출력됩니다.");
			Thread.sleep(3000);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\etc\\object.dat"));
			Date time = (Date)ois.readObject();
			ois.close();
			System.out.println("읽은 시간 : "+sdf.format(time));
			System.out.println("현재 시간 : "+sdf.format(new Date()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
