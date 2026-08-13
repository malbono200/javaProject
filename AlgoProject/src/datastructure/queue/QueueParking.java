package datastructure.queue;

import java.util.Scanner;

public class QueueParking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("주차가능 대수를 입력하세요 : ");
        int capacity = sc.nextInt();

        MyQueueMove queue = new MyQueueMove(capacity);

        System.out.println(capacity + "대를 주차할 수 있는 주차장이 구성되었습니다.");

        while (true) {
        	System.out.println();
            System.out.println("메뉴:");
            System.out.println("0. 주차여부 확인");
            System.out.println("1. 자동차 주차");
            System.out.println("2. 자동차 출차");
            System.out.println("3. 만차여부");
            System.out.println("4. 종료");
            System.out.print("선택 : ");
            String menu = sc.next();

            if (menu.equals("0")) {
                System.out.print("확인할 차량 고유 문자 입력: ");
                char car = sc.next().charAt(0);
                if (queue.contains(car) != -1) {
                    System.out.println(car + " 차량은 주차되어 있습니다.");
                } else {
                    System.out.println(car + " 차량은 주차장에 없습니다.");
                }
            } else if (menu.equals("1")) {
                if (queue.isFull()) {
                    System.out.println("만차입니다. 주차할 수 없습니다.");
                } else {
                    System.out.print("주차할 차량 고유 문자 입력: ");
                    char car = sc.next().charAt(0);
                    queue.enqueue(car);
                    System.out.println(car + " 자동차 주차 완료");
                }
            } else if (menu.equals("2")) {
                if (queue.isEmpty()) {
                    System.out.println("주차장이 비어있습니다.");
                    continue;
                }
                
                System.out.print("출차할 차량 고유 문자 입력: ");
                char car = sc.next().charAt(0);

                if (queue.contains(car) == -1) {
                    System.out.println(car + " 차량은 주차장에 없습니다.");
                    continue;
                }

                System.out.print("주차시간이 1시간 경과했습니까? (Y/N) : ");
                String timePassed = sc.next();

                if (timePassed.equalsIgnoreCase("Y")) {
                    if (queue.peek() == car) {
                        queue.dequeue();
                        System.out.println(car + " 자동차 출차 완료");
                    } else {
                        System.out.println("먼저 주차된 차가 있어 패널티가 적용됩니다. 출차 순서가 마지막으로 밀립니다.");
                        int currentSize = queue.size();
                        for (int i = 0; i < currentSize; i++) {
                            char temp = queue.dequeue();
                            if (temp != car) {
                                queue.enqueue(temp);
                            }
                        }
                        queue.enqueue(car);
                    }
                } else {
                    if (queue.peek() == car) {
                        queue.dequeue();
                        System.out.println(car + " 자동차 출차 완료");
                    } else {
                        System.out.println("1시간이 경과되지 않았으며, 먼저 주차된 차가 있어 출차할 수 없습니다.");
                    }
                }
            } else if (menu.equals("3")) {
                if (queue.isFull()) {
                    System.out.println("현재 주차장은 만차입니다.");
                } else {
                    System.out.println("현재 주차장에 여유 공간이 있습니다. (현재 주차 대수: " + queue.size() + ")");
                }
            } else if (menu.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
            }
        }
        sc.close();

	}

}
