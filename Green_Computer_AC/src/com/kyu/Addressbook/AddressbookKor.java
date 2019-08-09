package com.kyu.Addressbook;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class AddressbookKor extends Addressbook {
	
	public AddressbookKor() {

	}

	
	// 벡터 비었는지 확인
	private boolean isEmpty() {
		return vecRs.size() == 0;
	}

	// 문자열 입력받음
	String inputString() {
		String str = "";
		try {
			str = new String(dis.readLine().getBytes("8859_1"), "UTF-8");
		} catch (Exception e) {
			System.out.print("올바른 값을 입력해 주세요.");
		}
		
		return str;
	}
	
	@Override
	public void addRecord() {
		Record item = new Record();
		System.out.println("새 주소를 추가합니다.");
		try {
			System.out.print("이름 > ");
			item.setName(new String(dis.readLine().getBytes("8859_1"), "UTF-8"));
			System.out.print("P.H > ");
			item.setPhNum(new String(dis.readLine().getBytes("8859_1"), "UTF-8"));
			System.out.print("주소 > ");
			item.setAddress(new String(dis.readLine().getBytes("8859_1"), "UTF-8"));
			vecRs.add(item);
		} catch (Exception e) {

		}
	}
	
	public String searchByType(String searchType, Record record) {
		int cnt = 0;
		if(StringUtils.equals(searchType, "0")) {
			return record.getName();
		} else {
			return record.getPhNum();
		}
		
	}
	
	@Override
	public void getRecord() {
		if (isEmpty()) {
			System.out.println("주소록이 비었습니다.");
			return;
		}
		
		
		System.out.println("[ 조회 옵션 선택 : ] ");
		System.out.print("(0) 이름");
		System.out.println(" (1) 폰번호");
		
		String searchType = inputString();
		
		switch(searchType) {
		case "0":
			System.out.println("[ 이름으로 검색 : ] ");
			System.out.print("이름 : ");
			break;
		case "1":
			System.out.println("[ 폰번호로 검색 : ] ");
			System.out.print("폰번호 : ");
			break;
		default :
			return;
		}
		
		String str = inputString();
		
		int cnt = 0;
		System.out.println("=="+str+"검색 결과==");
		for (int i = 0; i < vecRs.size(); ++i) {
			Record recs = (Record) vecRs.get(i);
			if (StringUtils.equals(str, searchByType(searchType, recs))) {
				System.out.println(++cnt + ")");
				System.out.println("이   름 : " + recs.getName());
				System.out.println("폰번호 : " + recs.getPhNum());
				System.out.println("주   소 : " + recs.getAddress());
			}
		}
		if (cnt == 0) {
			System.out.println("검색 결과가 없습니다...\n");
		}

	}

	@Override
	public void delRecord() {
		if (isEmpty()) {
			System.out.println("주소록이 비었습니다.");
			return;
		}
		
		System.out.println("[ 조회 옵션 선택 : ] ");
		System.out.print("(0) 이름");
		System.out.println(" (1) 폰번호");
		
		String searchType = inputString();
		
		switch(searchType) {
		case "0":
			System.out.println("[ 이름으로 삭제 : ] ");
			System.out.print("이름 : ");
			break;
		case "1":
			System.out.println("[ 폰번호로 삭제 : ] ");
			System.out.print("폰번호 : ");	
			break;
		default :
			return;
		}
		
		String str = inputString();

		int cnt = 0;
		System.out.println("=="+str+"삭제 결과==");
		for (int i = 0; i < vecRs.size(); ++i) {
			Record recs = (Record) vecRs.get(i);
			if (StringUtils.equals(str, searchByType(searchType, recs))) {
				cnt++;
				System.out.println("이   름 : " + recs.getName());
				System.out.println("폰번호 : " + recs.getPhNum());
				System.out.println("주   소 : " + recs.getAddress());
				System.out.println("삭제 성공");
				vecRs.remove(i);
			}
		}
		if (cnt == 0) {
			System.out.println("검색 결과가 없습니다...\n");
		}

		// return new Record();
	}

	@Override
	public void displayMenu() {
		System.out.println("==============");
		System.out.println("메뉴를 선택해 주세요.");
		System.out.println(" (0) 주소록에 추가");
		System.out.println(" (1) 주소 확인");
		System.out.println(" (2) 주소 삭제");
		System.out.println(" (3) 주소록 열람");
		System.out.println(" (9) 프로그램 종료");
		System.out.println("==============");

		try {
			// cnt++;
			imenu = Integer.parseInt(dis.readLine());

		} catch (Exception e) {
			System.out.print("올바른 메뉴를 입력해 주세요.");
			return;
		}

		switch (imenu) {
		case 0:
			addRecord();
			break;
		case 1:
			getRecord();
			break;
		case 2:
			delRecord();
			break;
		case 3:
			System.out.println("[ 전체 주소록  조회 결과 ] ");
			System.out.println(searchAddbook());
			break;
		case 9:
			System.out.println("프로그램 종료...");
		
			saveAddressBook(searchAddbook());
			UserInterface.flag = false;
			break;

		}
	}

	// 주소록 전체 조회
	public String searchAddbook() {
		if (isEmpty()) {
			return "주소록이 비었습니다.";
		}
		String addressToSave = "";
		for (int i = 0; i < vecRs.size(); ++i) {
			Record recs = (Record) vecRs.get(i);
			addressToSave += String.format("%d)\n이   름 : %s\n폰번호 : %s\n주   소 : %s\n", 
					i+1, recs.getName(), recs.getPhNum(), recs.getAddress());
		}
		
		return addressToSave;
	}

}
