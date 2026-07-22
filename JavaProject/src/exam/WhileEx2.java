package exam;

import java.util.Scanner;

public class WhileEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("학생 수 입력: ");
        int student = sc.nextInt();
        
        int total = 0;
        int i = 1;
        while (i <= student) {
            System.out.print("학생" + i + " 점수 입력 : ");
            int score = sc.nextInt();
            total += score;
            i++;
        }
        
        double average = (double) total / student;
        System.out.println("평균 : " + average);
        
        sc.close();
	}

}
