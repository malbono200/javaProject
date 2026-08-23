package exam.algo.parking;

import java.util.Scanner;

public class ParkingMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        LinkedList parkingLot = new LinkedList();
        
        int maxCapacity = 5;
        
        while (true) {
            System.out.println("\n0.주차여부 확인 | 1.자동차 주차 | 2.자동차 출차 | 3.만차여부 | 4.종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();

            if (menu == 0) {
                System.out.print("확인할 차량 번호: ");
                String carId = sc.next();
                
                if (parkingLot.searchNode(carId) != null) {
                    System.out.println("해당 차량은 주차되어 있습니다.");
                } else {
                    System.out.println("해당 차량은 주차장에 없습니다.");
                }
            } else if (menu == 1) {
                if (parkingLot.getSize() >= maxCapacity) {
                    System.out.println("주차장 용량을 초과하여 입차를 제한합니다.");
                } else {
                    System.out.print("주차할 차량 번호: ");
                    String carId = sc.next();

                    if (parkingLot.getSize() == 0) {
                        parkingLot.insertNode(carId);
                        System.out.println("첫 차량 주차 완료.");
                    } else {
                        System.out.print("어느 차량 뒤에 주차하시겠습니까? (마지막 위치면 'last' 입력): ");
                        String position = sc.next();

                        if (position.equals("last")) {
                            parkingLot.insertNode(carId);
                            System.out.println("마지막 위치에 주차 완료.");
                        } else {
                            ListNode preNode = parkingLot.searchNode(position);
                            if (preNode != null) {
                                parkingLot.insertNode(preNode, carId);
                                System.out.println("지정된 위치에 주차 완료.");
                            } else {
                                System.out.println("지정한 차량을 찾을 수 없어 마지막 위치에 주차합니다.");
                                parkingLot.insertNode(carId);
                            }
                        }
                    }
                }
                System.out.print("현재 주차 상태: ");
                parkingLot.printList();

            } else if (menu == 2) {
                System.out.print("출차할 차량 번호: ");
                String carId = sc.next();
                
                if (parkingLot.searchNode(carId) != null) {
                    parkingLot.deleteNode(carId);
                    System.out.println("출차 완료.");
                } else {
                    System.out.println("해당 차량이 주차장에 없습니다.");
                }
                System.out.print("현재 주차 상태: ");
                parkingLot.printList();
                
            } else if (menu == 3) {
                int currentSize = parkingLot.getSize();
                System.out.println("현재 주차 대수: " + currentSize + " / " + maxCapacity);
                if (currentSize >= maxCapacity) {
                    System.out.println("만차 상태입니다. 입차가 불가능합니다.");
                } else {
                    System.out.println("주차 가능합니다.");
                }
                
            } else if (menu == 4) {
                System.out.println("주차관리 프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
        sc.close();

	}

}
