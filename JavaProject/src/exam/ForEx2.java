package exam;

import java.util.Scanner;

public class ForEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("단 수 입력: ");
        int num = sc.nextInt();
        
        for (int i = 1; i <= 9; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        sc.close();

	}

}
