package com.kyu.boxoffice;
/*
 *  "boxofficeType": "일별 박스오피스",
 *  "showRange": "20190822~20190822",
 *  "dailyBoxOfficeList": 
 */
public class BoxOfficeResult {
	private String boxofficeType;
	private String showRange;
	private DailyBoxOfficeList[] dailyBoxOfficeList;
	public String getBoxofficeType() {
		return boxofficeType;
	}
	public void setBoxofficeType(String boxofficeType) {
		this.boxofficeType = boxofficeType;
	}
	public String getShowRange() {
		return showRange;
	}
	public void setShowRange(String showRange) {
		this.showRange = showRange;
	}
	public DailyBoxOfficeList[] getDailyBoxOfficeList() {
		return dailyBoxOfficeList;
	}
	public void setDailyBoxOfficeList(DailyBoxOfficeList[] dailyBoxOfficeList) {
		this.dailyBoxOfficeList = dailyBoxOfficeList;
	}
	
	
}
