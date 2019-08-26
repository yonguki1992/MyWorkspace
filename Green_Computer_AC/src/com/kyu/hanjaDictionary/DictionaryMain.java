package com.kyu.hanjaDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import Ch11.HanjaVo;
import MyLib.ScannerFunctions;

public class DictionaryMain {

	public static void main(String[] args) {

		ScannerFunctions io = new ScannerFunctions("", "");
		Map<String, HanjaVo> map = loadChunja();

		while (true) {
			System.out.print("한자를 입력해 주세요 > ");
			String hanja = io.inputText();
			if (StringUtils.equals(hanja, "0")) {
				System.out.println("종료합니다.");
				break;
			}
			if (map.containsKey(hanja)) {
				System.out.println("찾은 한자 : " + map.get(hanja));
			} else {
				System.out.println(hanja + "는 천자문에 없다.");
			}
		}
		io.finalize();
	}

	private static Map<String, HanjaVo> loadChunja() {
		Map<String, HanjaVo> hanjaMap = new TreeMap<>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(System.getProperty("user.dir") + "\\etc\\chunja.txt"));
			while (scan.hasNextLine()) {
				String[] hanja = scan.nextLine().split("\\|");
				// System.out.println(hanja[0] +"."+hanja[1]+"("+hanja[3]+")");
				HanjaVo vo = new HanjaVo();
				vo.setIdx(hanja[0]);
				vo.setH(hanja[1]);
				vo.setK(hanja[2]);
				vo.setM(hanja[3]);
				hanjaMap.put(vo.getH(), vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			scan.close();
		}

		return hanjaMap;
	}
}
