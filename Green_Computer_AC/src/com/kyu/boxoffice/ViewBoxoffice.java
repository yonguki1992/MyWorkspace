package com.kyu.boxoffice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class ViewBoxoffice {
	static final String URL_ADD = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20190822";
	public static void main(String[] args) {
		try {
			URL url = new URL(URL_ADD);
			Gson gson = new Gson();
			InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
			Boxoffice bo = gson.fromJson(isr,  Boxoffice.class);
			
			System.out.println(bo.getBoxOfficeResult().getBoxofficeType());
			System.out.println(bo.getBoxOfficeResult().getShowRange());
			for(DailyBoxOfficeList dbo : bo.getBoxOfficeResult().getDailyBoxOfficeList()) {
				System.out.println(dbo.getRank());
				System.out.println(dbo.getMovieNm());
				System.out.println(dbo.getOpenDt());
			}
				
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
