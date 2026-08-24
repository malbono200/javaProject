package datastructure.queue.parking;

import java.util.Scanner;

public class QueueParking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue parking = new MyQueue(5);

        while (true) {
        	System.out.print("Select Menu : ");
        	System.out.println("0. 주차여부 확인 1. 주차 2. 출차 3. 만차 4. 종료 ");
        	String sel = sc.nextLine();
        	
        	switch(sel) {
        	case "0" :
        		System.out.println("주차한 차량의 고유값을 입력하세요 : ");
        		char carChar = sc.nextLine().charAt(0);
        		int num = parking. contains(Character. toLowerCase(carChar));
        		if(num < 0) {
        			System.out.println("입력하신 차량 정보는 주차 목록에 없습니다");
        		} else {
        			System.out.println("입력하신 차량은" + (num+1) + "번째 출차 가능합니다");
        		}
        		break;
        	case "1" :
        		System.out.println("주차를 진행합니다. 주차할 차량의 고유값을 입력하세요");
        		char chr = sc.nextLine().charAt(0);
        		if(parking.contains(Character.toLowerCase(chr) ==- 1)) {
        			if(parking.enqueue(Character.toLowerCase(chr))) {
        				System.out.println("주차 완료!");
        			} else {
        				System.out.println("주차 불가!");
        			}
        		}
        	}
        }

	}

}
