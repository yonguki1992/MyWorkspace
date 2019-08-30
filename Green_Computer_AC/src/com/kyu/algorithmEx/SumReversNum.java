package com.kyu.algorithmEx;

public class SumReversNum {

	public static void main(String[] args) {
		int num = 1; //251
		int nTmp = 0;
		int nTmp2 = num;
		int times = 10;
		int cnt = 0;
		
		while (true) {
			int tmp = 0;
			if(times == 0) break;
			for (int i = num; i > 0; i /= 10) {
				cnt++;
//				System.out.println("i="+i);
	
			}
//			System.out.println("cnt="+cnt);
			for (int i = cnt; i > 0; --i) {
				nTmp += nTmp2 % 10;
				for (int j = i-1; j > 0; --j) {
					nTmp *= 10;
					//System.out.println("i="+i+" nTmp="+nTmp);
				}
				tmp += nTmp;
				nTmp = 0;
				nTmp2 /= 10;
				
			}
			System.out.println(num+"->"+tmp);
			times--;
			System.out.println((10-times)+" : "+ (num+tmp));
			
			
			num += tmp;
			nTmp = 0;
			nTmp2 = num;
			cnt = 0;
		}
		
	}

}
