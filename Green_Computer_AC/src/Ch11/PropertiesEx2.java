package Ch11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class PropertiesEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("USAGE : java PropertiesEx2 INPUTFILENAME.");
			System.exit(0);
		}
		
		Properties prop = new Properties();
		
		String inputFile = args[0];
		
		try {
			prop.load(new FileInputStream(inputFile));
		} catch (IOException ie) {
			// TODO: handle exception
			System.out.println("지정된 파일을 찾을 수가 없습니다.");
			System.exit(0);
		}
		
		String name = prop.getProperty("name");
		try {
			//String.getBytes(charSet) : String을 charSet 으로 인코딩한 후 byte[] 로 저장, 
			//new String(byte[], charSet) : charSet 으로 byte[]를 디코딩함
			name = new String(name.getBytes("ISO-8859-1"), "EUC-KR"); //.txt가 ANSI일 때 정상(EUC-KR은 ANSI를 확장 한 것)	
			//name = new String(name.getBytes("ISO-8859-1"), "UTF-8");	// .txt가 UTF-8 일 때 정상
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] data = prop.getProperty("data").split(",");
		
		int max = 0, min = 0;
		int sum = 0;
		
		for(int i = 0; i < data.length; ++i) {
			int intValue = Integer.parseInt(data[i]);
			if(i==0) {
				max = min = intValue;
			}
			if (max < intValue) {
				max = intValue;
			} else if (min > intValue) {
				min = intValue;
			}
			sum += intValue;
		}
		System.out.println("이름 : " + name);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum*100.0/data.length)/100);
	}

}
