package com.kyu.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonEx01 {
	public static void main(String[] args) {
		String data = "[11,22,33,4,5,55]";

		Gson gson = new Gson();
		// 읽을 때는 fromJson(자료, 리턴 타입), 저장할 때는 toJson(객체)
		int ar2[] = gson.fromJson(data, int[].class);
		
		System.out.println(Arrays.toString(ar2));
		
		String data2 = gson.toJson(ar2);
		System.out.println(data2);
		
		//json을 리스트에 저장
		List<Integer> list = gson.fromJson(data2, new TypeToken<List<Integer>>() {}.getType());
		System.out.println(list);
		
		//
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\etc\\json\\testJson.json");
			gson.toJson(ar2,fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
