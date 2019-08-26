package com.kyu.pallette;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class ColorPalletteMain {

	public static void main(String[] args) {
		Pallette p = new Pallette();
		Gson gs = new Gson();
		
		getJson(gs);

	}

	private static void getJson(Gson gs) {
		Pallette p;
		try(FileReader fr = new FileReader(System.getProperty("user.dir")+"\\etc\\json\\colors.json")) {
			p = gs.fromJson(fr, Pallette.class);
			for(Colors arr : p.getColors()) {
				System.out.println(arr.getColor());
				System.out.println(arr.getCategory());
				System.out.println(arr.getType());
				System.out.println(Arrays.toString(arr.getCode().getRgba()));		
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
