package Ch11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TodayHanja {

	public static void main(String[] args) {
		todayHanja();
		todaySentence();
	}

	private static void todaySentence() {
		List<HanjaVo> list = chunjamoonSentence();
		
		Set<Integer> todayHanja = new HashSet<>();
		
		Random rnd = new Random();
		
		while(todayHanja.size() < 4) {
			todayHanja.add(rnd.nextInt(250));
		}
		for(int idx : todayHanja) {
			HanjaVo vo = list.get(idx);
			System.out.println(vo);
		}
	}
	
	private static void todayHanja() {
		List<HanjaVo> list = chunjamoon();
		
		Set<Integer> todayHanja = new HashSet<>();
		
		Random rnd = new Random();
		
		while(todayHanja.size() < 4) {
			todayHanja.add(rnd.nextInt(1000));
		}
		for(int idx : todayHanja) {
			HanjaVo vo = list.get(idx);
			System.out.println(vo);
		}
	}
	private static List<HanjaVo> chunjamoonSentence() {
		List<HanjaVo> list = new ArrayList<>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(System.getProperty("user.dir")+"\\etc\\chunja2.txt"));
			while(scan.hasNextLine()) {
				String hanja[] = scan.nextLine().split("\\|");
				//System.out.println(hanja[0] +"."+hanja[1]+"("+hanja[3]+")");
				HanjaVo vo = new HanjaVo();
				vo.setIdx(hanja[0]);
				vo.setH(hanja[1]);
				vo.setK(hanja[2]);
				vo.setM(hanja[3]);
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
		return list;
	}
	
	private static List<HanjaVo> chunjamoon() {
		List<HanjaVo> list = new ArrayList<>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(System.getProperty("user.dir")+"\\etc\\chunja.txt"));
			while(scan.hasNextLine()) {
				String hanja[] = scan.nextLine().split("\\|");
				//System.out.println(hanja[0] +"."+hanja[1]+"("+hanja[3]+")");
				HanjaVo vo = new HanjaVo();
				vo.setIdx(hanja[0]);
				vo.setH(hanja[1]);
				vo.setK(hanja[2]);
				vo.setM(hanja[3]);
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
		return list;
	}
}
