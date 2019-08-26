package com.kyu.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOEx10 {

	public static void main(String[] args) {
		new SomeVoWrite().voWrite();
		new SomeVoRead().voRead();
	}

}
class SomeVoWrite {
	public void voWrite() {
		ObjectOutputStream oos = null;
		SomeVO sVO = new SomeVO();
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "\\etc\\IOEx10.dat"));
			sVO.data = 11;
			
			oos.writeObject(sVO);
			oos.flush();

			System.out.println("저장 완료!!");

		} catch (IOException e) {
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

class SomeVoRead {
	public void voRead() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "\\etc\\IOEx10.dat"));
			SomeVO vo1 = (SomeVO) ois.readObject();

			System.out.println(vo1.getData());
			ois.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
}

