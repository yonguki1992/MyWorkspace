package Ch09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IOTest {
	
	// 현재 프로젝트 DIR의 절대경로 받아오기
	static final String DEFAULT_PATH = (System.getProperty("user.dir") + "\\").trim();	
	
	/*위 소스코드 하드코딩한 것
	*static final String ABSOLUTE_DIR_PATH = "C:\\Users\\yongu\\Documents\\MyWorkspace\\Green_Computer_AC\\src\\"; 
	*/
	
	//파일명
	static String fileName = "text.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DEFAULT_PATH + fileName);
		File file = new File(new StringBuffer(DEFAULT_PATH+fileName).toString().trim());
		
		String str = "";
		FileReader fr;
		
		try {
			fr = new FileReader(file);
			int cur = 0;
			
			fr.read();	//버퍼 한번 비움 (ex : "﻿100" -> 평범한 100처럼 보이지만 1 왼쪽에 알 수 없는 특문이 하나 더 있옴, 커서 가져다 대보면 암)
			while((cur = fr.read()) != -1) {
				str += (char)cur;
			}
			fr.close();
		} catch (FileNotFoundException fnfe){
			System.out.println(fileName + "을 찾을 수 없습니다.");
			fnfe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringTokenizer st = new StringTokenizer(str, System.getProperty("line.separator"));
		ArrayList<String> strAL = new ArrayList<String>();
		String temp = "";
		int i = 0;
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			strAL.add(st.nextToken().trim());
			temp = strAL.get(i++);
			
			System.out.println(temp);
			
			StringTokenizer tempT = new StringTokenizer(temp, ",");
			while(tempT.hasMoreTokens()) {
				sum += Integer.parseInt(tempT.nextToken().trim());
				System.out.println(sum);
			}
			
			System.out.println();
		}
		
		System.out.println("합계는 : " + sum);
	}

}
