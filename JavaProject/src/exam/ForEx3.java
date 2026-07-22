package exam;

import java.util.Scanner;

public class ForEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("start 입력: ");
        int start = sc.nextInt();
        System.out.print("end 입력 : ");
        int end = sc.nextInt();
        
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        
        System.out.println(start + "~" + end + "의 합:" + sum);
        
        sc.close();

	}

}
