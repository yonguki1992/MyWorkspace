package com.kyu.algorithmEx;

public class AnimalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int pNum = 0, pLeg = 4; // 강아지
		int cNum = 0, cLeg = 2; // 병아리
		int sum = 25, sumLeg = 80; // 각각 개체, 다리 수 합계
		//int sum = new ScannerFunctions().inputNumber();
		//int sumLeg = new ScannerFunctions().inputNumber(); // 각각 개체, 다리 수 합계
		
		while (true) {
			


			if ( (sumLeg-(4*pNum+2*cNum) <= 0) )
				break;
			
			if (sumLeg <= 0)
				break;
			
			pNum++;
			cNum++;
		}

		if ((sum < 0 && sumLeg < 0) || (sum > 0 && sumLeg > 0))
			System.out.println(0);
		else
			System.out.println("강아지" + pNum + "병아리" + cNum);
		
	}

}
