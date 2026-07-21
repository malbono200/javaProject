package exam;

import java.util.Scanner;

public class MultipleIfElseEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("숫자1 입력 : ");
        int num1 = scanner.nextInt();

        System.out.print("숫자2 입력 : ");
        int num2 = scanner.nextInt();

        System.out.print("숫자3 입력 : ");
        int num3 = scanner.nextInt();

        int max = num1;

        if (num2 > max) {
            max = num2;
        }

        if (num3 > max) {
            max = num3;
        }

        System.out.println("가장 큰 수 : " + max);

        scanner.close();
	}

}
