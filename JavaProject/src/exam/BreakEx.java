package exam;

import java.util.Scanner;

public class BreakEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int balance = 100000;
        
        System.out.println("현재 잔액 : " + balance);
        
        while (true) {
            System.out.print("인출액 입력 : ");
            int withdrawal = sc.nextInt();
            
            if (withdrawal > balance) {
                System.out.println("잔액부족. 현재 잔액 : " + balance);
                break;
            }
            
            balance -= withdrawal;
        }
        
        sc.close();

	}

}
