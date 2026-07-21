package exam;

import java.util.Scanner;

public class InputEx {

	public static void main(String[] args) {
		
		Scanner sc;
		sc = new Scanner(System.in);
		
		String name;
		int year;
		float score;
		String grade;
		
		System.out.print("성명 입력 : "); name = sc.next();
		System.out.print("학년 입력 : "); year = sc.nextInt();
		System.out.print("점수 입력 : "); score = sc.nextFloat();
		System.out.print("학점 입력 : "); grade = sc.next();
		
		System.out.println("============================");
		
		System.out.println("성명 : " + name);
		System.out.println("학년 : " + year);
		System.out.println("점수 : " + score);
		System.out.println("학점 : " + grade);
		
		sc.close();
	}

}
