package com.kyu.hanjaDictionary2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HanjaDictionary {

	public static void main(String[] args) {
		Gson gs = new Gson();
		List<HanjaVO> hj = new ArrayList<>();
		try(FileReader fr = new FileReader(System.getProperty("user.dir")+"\\etc\\json\\chunja.json")) {
			
			hj = gs.fromJson(fr, new TypeToken<List<HanjaVO>>() {}.getType());
			System.out.println(hj.size()+"개");

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(HanjaVO list : hj) {
			System.out.println(list);
		}
		
		try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\etc\\json\\Bakup.json")){
			gs.toJson(hj, fw);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(HanjaVO list : hj) {
			System.out.println(list);
		}
	}

}
