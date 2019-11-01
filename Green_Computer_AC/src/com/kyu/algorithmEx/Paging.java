package com.kyu.algorithmEx;

public class Paging {
	// 받아오는 변수
	private int totalCount;		// 전체 갯수
	private int currentPage;	// 현재 페이지
	private int pageSize;		// 페이지 사이즈
	private int blockSize;		// 하단에 표시될 페이지 갯수
	
	// 계산하는 변수
	private int totalPage;		// 전체 페이지 수
	private int startNo;		// 시작 글 번호
	private int endNo;			// 끝 글 번호
	private int startPage;		// 시작 페이지 번호
	private int endPage;		// 끝 페이지 번호
	
	// 생성자
	public Paging(int totalCount, int currentPage, int pageSize, int blockSize) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calc();
	}
	
	//계산해주는 메서드
	private void calc() {
		// 갯수가 0 이면 굳이 계산할 필요 없음
		if(totalCount > 0 && currentPage > 0) {
			totalPage = (totalCount - 1)/pageSize + 1;
			// mariaDB : idx가 0부터 시작(1페이지 : 0 ~ 9, 5페이지 : 40 ~ 49)
			startNo = (currentPage-1)*pageSize;
			// Oracle : rowNum이 1부터 시작(1페이지 : 1 ~ 10, 5페이지 : 41 ~ 50)
			//startNo = (currentPage)*pageSize + 1;
			//endNo = startNo + pageSize;
			endNo = startNo + pageSize - 1;
			if(endNo > totalCount) {
				endNo = totalCount - 1;		//엔드 넘버는 Oracle 에서만 사용할 것.
			}
			
			startPage = (currentPage - 1)/blockSize * blockSize + 1;
			//endPage = startPage + blockSize;
			endPage = startPage + blockSize - 1;
			if(endPage > totalPage) {
				endPage = totalPage;
			}
			
		}
	}
	
	// getter 만 만들음(read only)
	public int getTotalCount() {
		return totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	// 메서드 추가
	public String getPageInfo() {
		return "전체 : "+totalCount+"개("+currentPage+"/"+totalPage+"Page)";
	}
	
	public String getPage() {
		return startNo+"~"+endNo;
	}
	
	public String getPageList() {
		StringBuilder sb = new StringBuilder();
		
		//이전 페이지가 존재함
		if(startPage > 1) {
			sb.append("[이전] ");
		}
		for(int i = startPage; i <= endPage; ++i) {
			if(i == currentPage) {
				// 현재 페이지 색상 파란색으로
				//System.out.println( "\u001B[34m [" + i + "] \u001B[0m" );
				sb.append( "["+"\u001B[32m" + i + "\u001B[0m"+"]" );
				continue;
			}
			sb.append("["+i+"]");
		}
		if(endPage < totalPage) {
			sb.append(" [다음]");
		}
		return sb.toString();
	}
	
	// 테스트
	// 추가 과제 현재 페이지가 항상 페이지 리스트 중앙에 오도록 할 것.
	public static void main(String[] args) {
		Paging paging = new Paging(123, 13, 10, 5);
		
		System.out.println(paging.getPageInfo());
		System.out.println(paging.getPage());
		System.out.println(paging.getPageList());

		
	}
}
