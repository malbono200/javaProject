package exam;

import java.util.Scanner;

public class ForEx5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("학생 수 입력: ");
        int student = sc.nextInt();
        
        int total = 0;
        for (int i = 1; i <= student; i++) {
            System.out.print("학생" + i + " 점수 입력 : ");
            int score = sc.nextInt();
            total += score;
        }
        
        double average = (double) total / student;
        System.out.println("평균: " + average);
        
        sc.close();
	}

}
