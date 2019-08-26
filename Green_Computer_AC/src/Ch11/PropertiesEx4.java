package Ch11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx4 {
	public static void main(String[] args) {
		// properties 파일 읽기
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(new File(System.getProperty("user.dir")+"\\etc\\db.txt" )));
			System.out.println(prop.getProperty("user"));
			System.out.println(prop.getProperty("pw"));
			System.out.println(prop.getProperty("DB"));
			
			prop.loadFromXML(new FileInputStream(new File(System.getProperty("user.dir")+"\\etc\\db.xml" )));
			System.out.println(prop.getProperty("user"));
			System.out.println(prop.getProperty("pw"));
			System.out.println(prop.getProperty("DB"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
