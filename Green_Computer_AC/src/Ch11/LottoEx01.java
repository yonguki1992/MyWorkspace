package Ch11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import MyLib.*;

public class LottoEx01 {

	public static void main(String[] args) {
		Excercise01 ex = new Excercise01();
		ScannerFunctions io = new ScannerFunctions("", "");

		runLotto(ex, io);
	}

	private static void runLotto(Excercise01 ex, ScannerFunctions io) {
		System.out.print("게임 수 입력 > ");
		int game = io.inputNumber();
		String number = io.inputText();
		for (int i = 0; i < game; ++i)
			ex.creatLottoWithCF(number);
	}

}

class Excercise01 {
	void creatLottoWithSort() {
		int[] lotto = new int[6];
		Random rnd = new Random();
		for (int i = 0; i < lotto.length; ++i) {
			lotto[i] = rnd.nextInt(45) + 1;
			for (int j = 0; j < i; ++j)
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
		}

		System.out.println("생성 번호 : " + Arrays.toString(lotto));

		Arrays.sort(lotto);
		System.out.println("생성 번호 : " + Arrays.toString(lotto));
	}

	void creatLottoWithCF(String number) {
		Set<Integer> lotto;
		Random rnd = new Random();
		/**
		 * lotto = new HashSet<Integer>(); // 중복 잡고 정렬되지 않음 lotto.clear();
		 * 
		 * while(lotto.size() < 6){ lotto.add(rnd.nextInt(45)+1); }
		 *
		 * System.out.println("생성 번호 : "+lotto);
		 */

		lotto = new TreeSet<Integer>(); // 중복 잡고, 자동으로 정렬함
		lotto.clear();
		while (lotto.size() < 6) {
			lotto.add(rnd.nextInt(45) + 1);
		}
		System.out.println("생성 번호 : " + lotto);
		String[] tmp = number.split(",");
		List<String> list = Arrays.asList();
		TreeSet<String> correctN = new TreeSet<String>(list);
		System.out.println("당첨 번호 : " + correctN);
		// 당첨번호와 같은지 찾는 문장 작성할 것.
	}

	void creatLottoWithoutSort() {
		int[] lotto = new int[45];
		Random rnd = new Random();

		for (int i = 0; i < 6; ++i) {
			int tmp = 0;
			do {
				tmp = rnd.nextInt(lotto.length); // 0 ~ 44 사이의 난수 생성
			} while (lotto[tmp] != 0);
			lotto[tmp] = 1; // 0인 위치를 찾았으면 숫자 1로 변경
		} // 종료되면 6군데만 숫자 1이고 나머지는 모두 0 이다.

		System.out.print("생성 번호 : ");

		for (int i = 0; i < lotto.length; ++i) // 배열 중 숫자가 1인 위치값 출력
			if (lotto[i] == 1)
				System.out.print(String.format("%3d", i + 1));

		System.out.println();
	}

	void shuffleCard() {
		int[] card = new int[52];
		Random rnd = new Random();

		String[] kind = "♠,◇,♣,♡".split(",");
		String[] num = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");

		for (int i = 0; i < card.length; ++i) {
			int tmp = 0;
			do {
				tmp = rnd.nextInt(card.length); // 0 ~ 44 사이의 난수 생성
			} while (card[tmp] != 0);
			card[tmp] = i; // 0인 위치를 찾았으면 숫자 i로 변경
		} // 종료되면 숫자 0~51 까지의 숫자가 중복없이 저장.

		System.out.println("셔플 종료 : ");

		for (int i = 0; i < card.length; ++i) {
			// kind[card[i]/13] : 13으로 나눈 몫 -> 카드 무늬
			// num[card[i]%13] : 13으로 나눈 나머지 -> 숫자
			System.out.print(String.format("%1s%-2s", kind[card[i] / 13], num[card[i] % 13]));
			if ((i + 1) % 13 == 0)
				System.out.println();
		}

		System.out.println();
	}

	void shuffleHwaToo() {
		int[] card = new int[48];
		Random rnd = new Random();

		String[] num = "1,2,3,4,5,6,7,8,9,10,11,12".split(",");
		String[] kind = "<min>,<line>,<twin>,<kwan>".split(",");

		for (int i = 0; i < card.length; ++i) {
			int tmp = 0;
			do {
				tmp = rnd.nextInt(card.length); // 0 ~ 44 사이의 난수 생성
			} while (card[tmp] != 0);
			card[tmp] = i; // 0인 위치를 찾았으면 숫자 i로 변경
		} // 종료되면 숫자 0~51 까지의 숫자가 중복없이 저장.

		System.out.println("셔플 종료 : ");

		for (int i = 0; i < card.length; ++i) {
			// kind[card[i]/13] : 13으로 나눈 몫 -> 카드 무늬
			// num[card[i]%13] : 13으로 나눈 나머지 -> 숫자
			System.out.print(String.format("%1s%-2s", kind[card[i] % 4], num[card[i] / 4]));
			if ((i + 1) % 4 == 0)
				System.out.println();
		}

		System.out.println();
	}

}