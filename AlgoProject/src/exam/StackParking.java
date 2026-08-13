package exam;

import java.util.Scanner;

public class StackParking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        System.out.println("주차장을 구성합니다");
        System.out.print("주차면을 입력하세요 : ");
        int capacity = sc.nextInt();
        
        String[] park = new String[capacity];
        int last = -1;
        
        System.out.println(capacity + "대를 주차할 수 있는 주차장이 구성되었습니다");
        System.out.println("자동차 주차 프로그램 실행 완료");
        
        while (true) {
            System.out.println("버튼을 눌러주세요.");
            System.out.print("0.주차현황 / 1. 자동차 주차, 2. 자동차 출차, 3. 만차여부, 4. 프로그램 종료 : ");
            String menu = sc.next();
            
            if (menu.equals("1")) {
                if (last == capacity - 1) {
                    System.out.println("만차입니다.");
                } else {
                    System.out.print("주차할 자동차 이름 입력: ");
                    String car = sc.next();
                    park[++last] = car;
                    System.out.println(car + " 자동차 주차 완료");
                }
            } else if (menu.equals("2")) {
                if (last == -1) {
                    System.out.println("주차장이 비어있습니다.");
                } else {
                    System.out.println(park[last--] + " 자동차 출차 완료");
                }
            } else if (menu.equals("3")) {
                int count = last + 1;
                System.out.print("현재 주차장에 자동차 " + count + "대가 주차되어 있습니다. ");
                if (count == capacity) {
                    System.out.println("만차입니다.");
                } else {
                    System.out.println("여유공간이 존재합니다.");
                }
            } else if (menu.equals("4")) {
                break;
            } else if (menu.equals("0")) {
                if (last == -1) {
                    System.out.println("주차장이 비어있습니다.");
                } else {
                    for (int i = last; i >= 0; i--) {
                        System.out.println(park[i]);
                    }
                }
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 재실행 해주세요.");
            }
        }
        sc.close();
        
	}

}
