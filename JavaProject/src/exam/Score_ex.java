package exam;

import java.util.Scanner;

public class Score_ex {

	public static void main(String[] args) {
		int student = 0;
        int[] score = null;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	System.out.println("-----------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("-----------------------------------------------");
            System.out.print("선택> ");
            int num = sc.nextInt();
            
            if (num == 1) {
                System.out.print("학생수> ");
                student = sc.nextInt();
                score = new int[student];
            } else if (num == 2) {
                for (int i = 0; i < score.length; i++) {
                    System.out.print("scores[" + i + "]> ");
                    score[i] = sc.nextInt();
                }
            } else if (num == 3) {
                for (int i = 0; i < score.length; i++) {
                    System.out.println("scores[" + i + "]: " + score[i]);
                }
            } else if (num == 4) {
                int max = 0;
                int sum = 0;
                for (int i = 0; i < score.length; i++) {
                    if (score[i] > max) {
                        max = score[i];
                    }
                    sum += score[i];
                }
                double avg = (double) sum / score.length;
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);
            } else if (num == 5) {
            	break;
            }
        }
        
        System.out.println("프로그램 종료");
        sc.close();

	}

}
