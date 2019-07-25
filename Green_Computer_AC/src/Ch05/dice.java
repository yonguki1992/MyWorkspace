package Ch05;

import java.util.Random;

import java.util.Scanner;

public class dice {

	public static void main(String[] args) {

		Random random = new Random();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			int firstDice = (int) (Math.random() * 6) + 1;

			int secondDice = (int) (Math.random() * 6) + 1;

			int user = 0;

			int com = 0;

			int select = 0;

			System.out.println("[1]주사위 [2]주사위 중 하나를 선택하세요. (종료는 [0])");

			String tmp = scanner.nextLine();

			select = Integer.parseInt(tmp);

			switch (select) {

			case 1:

				user = firstDice;

				com = secondDice;

				System.out.println("[" + select + "]번 주사위를 선택하셨습니다.");

				System.out.printf("당신이 선택한 주사위의 숫자는 %d 입니다.\n", user);

				System.out.printf("컴퓨터가 선택한 주사위의 숫자는 %d 입니다.\n", com);

				if (user > com) {

					System.out.printf("%d점 차로 당신이 승리하였습니다.\n", user - com);

				} else if (user < com) {

					System.out.printf("%d점 차로 컴퓨터가 승리하였습니다.\n", com - user);

				} else if (user == com) {

					System.out.printf("동점입니다.\n");

				}

			case 2:

				user = secondDice;

				com = firstDice;

				System.out.println("[" + select + "]번 주사위를 선택하셨습니다.");

				System.out.printf("당신이 선택한 주사위의 숫자는 %d 입니다.\n", user);

				System.out.printf("컴퓨터가 선택한 주사위의 숫자는 %d 입니다.\n", com);

				if (user > com) {

					System.out.printf("%d점 차로 당신이 승리하였습니다.\n", user - com);

				} else if (user < com) {

					System.out.printf("%d점 차로 컴퓨터가 승리하였습니다.\n", com - user);

				} else if (user == com) {

					System.out.printf("동점입니다.\n");

				}

			case 0:
				if (select == 0) {

					System.out.println("프로그램을 종료합니다.");
					
					System.exit(0);

				}

			default:

				if (!(1 <= select && select <= 2)) {

					System.out.println("주사위를 잘못 선택하셨습니다.\n(종료는 [0])");

					continue;

				}

			}

		}

	}

}
