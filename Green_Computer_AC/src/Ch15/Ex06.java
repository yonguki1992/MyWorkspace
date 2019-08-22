package Ch15;

import org.apache.commons.lang3.StringUtils;

import MyLib.IOFunctions;

public class Ex06 {
	public static void main(String[] args) {
		IOFunctions io = new IOFunctions("","");
		String id = "";
		while(true){
			id = io.inputText();
			if(StringUtils.equals(id, "0")) {
				break;
			}
			if(id.length() != 10) {
				System.out.println("10자리 숫자입니다.");
				continue;
			}
			
			/*
			 * 1. 9자리에 각각 137 137 135 를 곱한 합을 구함
			 * 2. 합에 9번째 자리에 5를 곱하고 10으로 나눈 몫을 더함
			 * 3. 10으로 나눈 나머지를 구함
			 * 4. 3을 10에서 뺌
			 * 5. 4의 결과와 10번째 자리가 같으면 맞는 사업자 번호 
			 */
			int sum = 0;
			String checkNum = "137137135";	//체크하는 번호
			for(int i = 0; i<9; ++i) {
				sum +=( id.charAt(i)-'0' )*(checkNum.charAt(i)-'0');
			}
			sum +=(id.charAt(8)-'0') * 5 / 10;
			sum = 10 - (sum %10);
			System.out.println((sum+'0'==id.charAt(9) ? "맞음" : "틀림"));
			
			
		}
		io.finalize();
	}
}
