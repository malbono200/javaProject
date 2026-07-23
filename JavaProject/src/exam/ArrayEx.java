package exam;

import java.util.Scanner;

public class ArrayEx {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        
        String[] name = new String[5];
        int[] gram = new int[5];
        int[] list = new int[5];
        int[] read = new int[5];
        
        int count = 0; 

        System.out.println("*** 영어 시험 점수 입력 ***");

        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "번 성명 입력: ");
            name[i] = sc.next();
            System.out.print((i + 1) + "번 문법 점수 입력: ");
            gram[i] = sc.nextInt();
            System.out.print((i + 1) + "번 듣기 점수 입력: ");
            list[i] = sc.nextInt();
            System.out.print((i + 1) + "번 독해 점수 입력: ");
            read[i] = sc.nextInt();
            
            count++;

            if (i < 4) {
                System.out.print("계속 입력하시겠습니까? (y입력하면 계속): ");
                String choice = sc.next();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }

        System.out.println("\n*** 영어 시험 결과 ***");
        
        for (int i = 0; i < count; i++) {
            int total = gram[i] + list[i] + read[i];
            String grade = "";

            switch (total / 100) {
                case 10:
                case 9:
                case 8:
                    grade = "1등급"; 
                    break;
                case 7:
                case 6:
                    grade = "2등급"; 
                    break;
                case 5:
                case 4:
                    grade = "3등급"; 
                    break;
                default:
                    grade = "4등급"; 
                    break;
            }

            System.out.println((i + 1) + "번 " + name[i] + " " + total + " " + grade);
        }

        sc.close();
        
	}

}
