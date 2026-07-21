package exam;

import java.util.Scanner;

public class TimeCalculation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("시간 입력 (초) : ");
        int Time = scanner.nextInt();
        
        int hour = Time / 3600;
        int minute = (Time % 3600) / 60;
        int second = Time % 60;
        
        System.out.println(Time + "초는 " + hour + "시간, " + minute + "분, " + second + "초입니다.");
        
        scanner.close();

	}

}
