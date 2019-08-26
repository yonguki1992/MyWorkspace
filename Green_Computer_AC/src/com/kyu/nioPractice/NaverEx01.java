package com.kyu.nioPractice;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc;
		try {
			doc = Jsoup.connect("http://www.naver.com/").get();
			System.out.println(doc.title());
			Elements lis = doc.select("div.ah_roll_area ul li");
			System.out.println(lis.size() + "개");
			for (Element e : lis)
				System.out.println(e.text());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}