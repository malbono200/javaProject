package exam;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int balance = 0;
        
        out: while (true) {
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.print("선택> ");
            int num = sc.nextInt();
            
            switch (num) {
                case 1:
                    System.out.print("예금액>");
                    balance += sc.nextInt();
                    break;
                case 2:
                    System.out.print("출금액>");
                    int amount = sc.nextInt();
                    if (amount <= balance) {
                        balance -= amount;
                    } else {
                        System.out.println("잔고가 부족합니다.");
                    }
                    break;
                case 3:
                    System.out.println("잔고>" + balance);
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    break out;
                default:
                    break;
            }
        }
        
        sc.close();
	}

}
