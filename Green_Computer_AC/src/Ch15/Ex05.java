package Ch15;

import org.apache.commons.lang3.StringUtils;

import MyLib.*;

public class Ex05 {
	/*
	 * 1. 각자리에 각각 234567892345 를 곱한 합을 구함
	 * 2. 합을 11로 나눈 나머지를 구함
	 * 3. 나머지를 11에서 뺀다
	 * 4. 3의 결과를 10으로 나눈 나머지를 구함
	 * 5. 4의 결과와 13번째 자리가 같으면 맞는 주민번호
	*/
	
	
	public static void main(String[] args) {
		ScannerFunctions io = new ScannerFunctions("","");
		
		String idNum = io.inputText();

		//실패한 소스코드 (오버플로우 발생)
//		long tmp = Long.parseLong(idNum);
//		
//		tmp += 234567892345L*tmp;	// 오버플로우
//		tmp %= 11;
//		tmp = 11L - tmp;
//		tmp /= 10;
//		
//		System.out.println(tmp);
//		System.out.println(Long.parseLong(idNum.substring(12, 13)));
//		
//		if(StringUtils.equals(idNum.substring(12, 13), String.valueOf(tmp)) ) {
//			System.out.println("올바름");
//		} else {
//			System.out.println("틀림");
//		}
		
		int sum = 0;
		
		for(int i = 0; i<12; ++i) {
			sum +=( idNum.charAt(i)-'0' )*(i%8+2);
		}
		sum = (11 - (sum%11)) % 10;
		System.out.println((sum+'0'==idNum.charAt(12) ? "맞음" : "틀림"));
		
		io.finalize();
	}
	
}


