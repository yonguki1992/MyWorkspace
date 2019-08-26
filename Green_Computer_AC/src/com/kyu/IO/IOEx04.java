package com.kyu.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//텍스틔 파일을 읽어서 리스트에 넣고
//석차 구하고
// 석차 까지

public class IOEx04 {

	public static void main(String[] args) {
		List<ScoreVO> list = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\etc\\score.txt"))) {
			while (sc.hasNext()) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str, "\t");
				if (st.hasMoreTokens()) {
					ScoreVO sv = new ScoreVO();
					sv.setName(st.nextToken());
					sv.setKor(Integer.parseInt(st.nextToken()));
					sv.setEng(Integer.parseInt(st.nextToken()));
					sv.setMath(Integer.parseInt(st.nextToken()));
					sv.setEdps(Integer.parseInt(st.nextToken()));
					list.add(sv);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//선택 정렬로 석차 구하기
		for (int i = 0; i < list.size() - 1; ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				if (list.get(i).getTot() > list.get(j).getTot()) {
					list.get(j).setRank(list.get(j).getRank() + 1);
				} else if (list.get(i).getTot() < list.get(j).getTot()) {
					list.get(i).setRank(list.get(i).getRank() + 1);
				}
			}
		}

		System.out.println(list);

		// 파일로 출력
		try (FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\etc\\result.txt")) {
			for (ScoreVO vo : list) {
				fw.append(vo.toString() + "\n");
				fw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
