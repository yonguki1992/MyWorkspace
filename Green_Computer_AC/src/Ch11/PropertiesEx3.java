package Ch11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/*
 * Properties : map<Object, Object>. 프로그램 환경 설정에 많이 사용됨.
 */
public class PropertiesEx3 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "admin");
		prop.setProperty("pw", "1234");
		prop.put("DB", "Oracle");
		
		
		System.out.println(prop.get("user"));
		System.out.println(prop.getProperty("pw"));
		
		//저장
		try {
			/*
			 * properties 파일은 유니코드로 저장되어야 한다. 한글이 유니코드로 변경된다.
			 * jdk에 들어있는 native2ascii.exe 를 이용하여 변환을 해줘야 함.
			 */
			prop.store(new PrintWriter(System.getProperty("user.dir")+"\\db.txt"), "DBMS 설정정보");
			prop.storeToXML(new FileOutputStream(System.getProperty("user.dir")+"\\db.xml"), "DBMS설명");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
