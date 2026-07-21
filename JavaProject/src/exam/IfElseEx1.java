package exam;

import java.util.Scanner;

public class IfElseEx1 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }

        scanner.close();
	}

}
