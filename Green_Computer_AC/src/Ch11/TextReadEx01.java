package Ch11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// list 만들고
// set 에서 난수 돌려서
// 
public class TextReadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chunjamoon();
		chunjamoon2();
	}

	private static void chunjamoon() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(System.getProperty("user.dir")+"\\etc\\chunja.txt"));
			while(scan.hasNextLine()) {
				String hanja[] = scan.nextLine().split("\\|");
				System.out.println(hanja[0] +"."+hanja[1]+"("+hanja[3]+")");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
	}
	
	private static void chunjamoon2() {
		try {
			// 파일 객체 생성
			File file = new File(System.getProperty("user.dir")+"\\etc\\chunja.txt");
			FileReader reader = new FileReader(file);

			int cursor = 0;
			String str = "";
			//reader.read();
			while ((cursor = reader.read()) != -1) {
				str += (char)cursor;
			}
			
			List<String> list = Arrays.asList(str.split("\\|"));
	
			Iterator<String> it = list.iterator();
			while(it.hasNext()) {
				System.out.print(it.next());
			}
			System.out.println();
			reader.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}

	

}
