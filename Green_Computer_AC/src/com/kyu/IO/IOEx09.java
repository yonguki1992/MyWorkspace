package com.kyu.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOEx09 {
	/*
	 * 사용자가 작성한 객체의 저장
	 * 
	 * 직렬화 : 객체를 스트림으로 만든다.
	 * 역직렬화 : 스트림을 객체로 조립한다.
	 * 
	 * 자바에서는 직렬화/역직렬화를 지원하는 인터페이스가 있다.
	 * 반드시 구현해 주어야만 Object의 입출력이 가능하다.
	 * 
	 * 단!!, 객체가 저장될 때는 인스턴스 멤버 변수만 저장된다.
	 * static 변수나 모든 메서드는 저장 되지 않는다. -> 모든 객체가 공유하는 값은 저장할 필요가 없다.
	 * 인스턴스 변수 중에서 저장하고 싶지 않은 변수가 있을 때는.
	 *  변수 선언 시 앞에 keyword로 transient 를 추가 
	 */
	public static void main(String[] args) {
		objectDateIO();
	}

	private static void objectDateIO() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\etc\\person.dat"));
			oos.writeObject(new PersonVO());
			oos.writeObject(new PersonVO("김용욱", 28, true));
			oos.writeObject(new PersonVO("진유경", 27, false));
			oos.flush();
			
			System.out.println("저장 완료!!");
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\etc\\person.dat"));
			PersonVO vo1 = (PersonVO)ois.readObject();
			PersonVO vo2 = (PersonVO)ois.readObject();
			PersonVO vo3 = (PersonVO)ois.readObject();
			
			System.out.println(vo1);
			System.out.println(vo2);
			System.out.println(vo3);
			ois.close();
			
		} catch (IOException e) {
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
