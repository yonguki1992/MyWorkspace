package com.kyu.librarian;

import static java.lang.System.*;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bFlag = true;
		BookRecordSet brs = new BookRecordSet(100);
		CustomIterator cit = null;
		BookRecord br = null;
		String strTitle = null;		//책 제목
		String strAuthor = null;	//저자
		int iQuantity = 0;			//책 권수
		
		Scanner sc = new Scanner(in);
		
		while(bFlag) {
			int iMenu = 0;
			out.println("===============");
			out.println(" 1. 도서 목록 추가");
			out.println(" 2. 도서 목록 검색");
			out.println(" 3. 종료");
			out.println("===============");
			try {
				iMenu = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				sc.next();//스캐너 비우기. 비우지 않으면 다음 입력때 \n이 자동으로 들어갈 수 있음.
				out.println("올바른 메뉴의 번호를 입력해주세요.");
				continue;
			}
			
			switch(iMenu) {
				//새 도서 객체를 추가	
				case 1:
					out.println("----------------");
					
					try {
						out.print(" 도서명을 입력하세요. > ");
						strTitle = sc.next();
					} catch (Exception e) {
						// TODO: handle exception
						sc.next();//스캐너 비우기. 비우지 않으면 다음 입력때 \n이 자동으로 들어갈 수 있음.
						out.println("도서명은 비워둘 수 없습니다.");
						continue;
					}			
					
					try {
						out.print(" 저자를 입력하세요. > ");
						strAuthor = sc.next();
					} catch(Exception e) {
						// TODO: handle exception
						sc.next();//스캐너 비우기. 비우지 않으면 다음 입력때 \n이 자동으로 들어갈 수 있음.
						out.println("저자 명을 비워둘 수 없습니다.");
						continue;
					}
					
					out.print(" 책 권수를 입력하세요. > ");
					try {
						iQuantity = sc.nextInt();
						
					} catch(Exception e) {
						// TODO: handle exception
						sc.next();//스캐너 비우기. 비우지 않으면 다음 입력때 \n이 자동으로 들어갈 수 있음.
						out.println("올바른 숫자를 입력해 주십시오.");
						continue;
					}
					
					brs.appendBookRecord(new BookRecord(strTitle, strAuthor, iQuantity));
					break;
					
				//열거자를 얻어옴	
				case 2:
					cit = brs.customIterator();
					out.println("----------------");
					
					out.print(" 도서명을 입력하세요. > ");
					try {
						strTitle = sc.next();
					} catch (Exception e) {
						// TODO: handle exception
						sc.next();//스캐너 비우기. 비우지 않으면 다음 입력때 \n이 자동으로 들어갈 수 있음.
						out.println("도서명은 비워둘 수 없습니다.");
						continue;
					}
					int cnt = 0;
					while(cit.hasNext()) {
						br = (BookRecord)cit.next();
						if(StringUtils.equals(strTitle, br.getStrTitleh())) {
							out.println(br.toString());
							cnt = 0;
							break;
						}
						cnt++;
					}
					if(cnt != 0) {
						out.println(strTitle + "을(를) 찾을 수 없었습니다.");
					}
					break;
				//프로그램 종료	
				case 3:
					bFlag = false;
					break;
			}
		}
	}

}
