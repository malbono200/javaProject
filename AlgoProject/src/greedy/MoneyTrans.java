package greedy;

import java.util.Scanner;

public class MoneyTrans {

	public static void main(String[] args) {
		// 금액 큰 단위 지불
		Scanner sc = new Scanner(System.in);

		int[] unit = {5000, 1000, 500, 100, 50, 10};
		
        System.out.print("금액 입력 : ");
        int money = sc.nextInt();


        for (int i=0; i<unit.length; i++) {
        	System.out.println(unit[i] + "원: " + money / unit[i]); 
            money %= unit[i];
        }

        System.out.println("나머지 : " + money);
        
        sc.close();
	}

}
