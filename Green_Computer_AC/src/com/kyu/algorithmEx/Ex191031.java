package com.kyu.algorithmEx;

public class Ex191031 {
/*
 * 군 기간 단축은 2017년 1월 3일 입대자부터 단계적으로 적용된다.
단축 이전의 복무일은 21개월, 단축 이후의 복무일은 18개월이다. 
당신의 군 복무 기간은 남은 기간에 비례하여 2주에 1일씩 감소한다.

문제는 당신이 짬이 안되서 선임들의 제대일도 함께 계산해야한다는 것이다. 
이 문제를 해결할 알고리즘을 작성하시오.
Input			Output            
20170103		20181001          
20170817		20190429          
20171202		20190808          
20180110		20190912          
20180210		20191011          
2020/06/16 부터 적용
단 Date 관련 함수나 메서드는 사용을 금지한다.
*/
	public static boolean isLeapYear(int year) {
		return ((year%4 == 0) && (year%100 != 0) || (year%400 ==0));
	}
	
	public static void main(String[] args) {
		
		//미완성
		String codStart = "20120531";
		int yy = Integer.parseInt(codStart)/10000;
//		int[] days = {31, !isLeapYear(yy)?28:29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31 };
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31 };
		int mm = Integer.parseInt(codStart)%10000/100;
		int dd = Integer.parseInt(codStart)%100;
		

		
		if(codStart.compareTo("20120103")<0) {
			//이전은 21개월
			mm += 21;
			yy += mm/12;
			mm %= 12;
			dd--;
			if(dd == 0) {
				mm--;
				if(mm==0) {
					yy--;
					mm=12;
				}
				dd=days[mm-1];
			}
			if(mm==0) {
				yy--;
				mm=12;
			}
			System.out.println(String.format("%4d-%02d-%02d", yy, mm, dd));
			
		} else if(codStart.compareTo("20200616")<0) {
			// 단축 구간 2주 -> -1일
			//StringBuilder sb = new StringBuilder();
			int endMM = mm+21;
			int endYY = yy+endMM/12;
			endMM %= 12;
			int endDD = dd-1;
			
			if(endDD==0) {
				endMM--;
				if(endMM==0) {
					endYY--;
					endMM=12;
				}
				endDD=days[endMM-1];
			}			
			if(endMM==0) {
				endYY--;
				endMM=12;
			}
			System.out.println(String.format("%4d-%02d-%02d", yy, mm, dd));
			System.out.println(String.format("%4d-%02d-%02d",endYY, endMM, endDD));
			/*
			 *  31 + 10 = 41 일
			 *   2014  01  01
			 * - 2012  04  02(의 윤달 여부 기준)
			 * ---------------
			 * 	    2 -03 -01
			 *     730 - (303) - 21 = 41
			 *     31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
			 *      
			 */
			
			int yearToDay = yearToDay(yy, endYY);
			//System.out.println(yearToDay);
			int monthToDay = monthToDay(days, endMM>mm?mm:endMM, endMM>mm?endMM:mm);
			//System.out.println(monthToDay);
			int totalDay = yearToDay + (endMM>mm?monthToDay:-1*monthToDay) + (endDD-dd);
			
			//System.out.println("총 : "+ yearToDay);
			System.out.println("총 : "+( endMM>mm?monthToDay:-1*monthToDay ));
			System.out.println("총 : "+(endDD-dd));
			System.out.println("총 : "+totalDay);
			
		} else {
			// 18개월
			mm += 18;
			yy += mm/12;
			mm %= 12;
			dd--;
			if(dd == 0) {
				mm--;
				if(mm==0) {
					yy--;
					mm=12;
				}
				dd=days[mm-1];
			}
			if(mm==0) {
				yy--;
				mm=12;
			}
			System.out.println(String.format("%4d-%02d-%02d", yy, mm, dd));
		}
			
		//System.out.println(days[0]);
		String codEnd = "";
	}

	private static int yearToDay(int yy, int endYY) {
		int yearToDay = 0;
		for(int i = 0; i < endYY-yy;++i) {
//			yearToDay+=(!isLeapYear(yy+i)?365:366);
			yearToDay+=365;
		}
		return yearToDay;
	}

	private static int monthToDay(int[] days, int start, int end) {
		
		int monthToDay = 0;
		for(int i = start-1; i < end-1; i++) {
			//System.out.println(days[i]);
			monthToDay += days[i];
		}
		return monthToDay;
	}

	
/*
문제 2] 피보나치 시저 암호
당신은 실력있는 A국의 스파이다. 어느 날 당신은 옆 나라 B국이 첨단 무기를 만들려 한다는 사실을 알게 되었고
당국은 당신에게 그 문서를 훔쳐오라고 말했다. 막상 거기에 도착해보니 경비가 매우 삼엄해 당신은 도움이 필요했다.
그러나 주위에 있는건 노트북 뿐, 메일로 통신을 하게 되면 인터넷을 감시하고 있는 B국이 그 사실을 알게 된다.
일반 시저 암호도 들키게 될 위험이 크므로 당신은 피보나치 시저 암호를 고안해 만들기로 했다.
문제- 피보나치 시저 암호를 만드시오
맨 처음 줄에는 정수인 암호키가 주어진다. (0 < N < 10000 )
그 다음 줄에는 변환하고 싶은 문자열이 주어진다.
문자열의 길이만큼 피보나치 수로 바꿔 문자열을 바꾸시오.
(예를 들어 암호키가 4 라면 수열은 1,4,5,9 . . . 로 되어 그 숫자만큼 문자열을 돌린다.)
입력에 소문자는 들어가 있지않으며 기호나 숫자가 들어가 있을 시 그대로 둔다. ( 공백 포함)
(시작은 무조건 1이다.)
입력)			출력)
1
AAAAA			BBCDF
1
HELLO, WORLD!		IFNOT, EMBTG!
3
ABCDE			BEGKP

문제 3] 폴더 복사하기
내부에 파일이 몇개 담긴 폴더 ex) 직박구리 가 있습니다.
이 폴더를 같은 디렉토리에 통째로 복사하려고 하는데 복사를 진행할때마다 사본, 사본_1, 사본_2 .....처럼 이름을 지으려고 합니다.
만약 사본이라는 폴더가 이미 있으면 사본_1 을,
사본 과 사본_1, 사본_2 가 모두 있다면 사본_3을,
사본 과 사본_2, 사본_3 이 있다면 비어있는 사본_1 을
생성하는 코드를 작성하세요.

 */
}
