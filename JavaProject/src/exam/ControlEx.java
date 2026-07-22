package exam;

import java.util.Scanner;

public class ControlEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("******* 상품 정보 *******");
        System.out.println("1 노트북 : 1,200,000 원");
        System.out.println("2 디지털카메라 : 400,000 원");
        System.out.println("***************************");
        
        System.out.print("상품번호 입력 : ");
        int num = sc.nextInt();
        
        String name = "";
        int price = 0;
        
        switch(num) {
        	case 1:
        		name = "노트북";
        		price = 1200000;
        		break;
        	case 2:
                name = "디지털카메라";
                price = 400000;
                break;
            default:
                System.out.println("잘못 입력하였습니다. 종료합니다.");
        }
        
        System.out.print("주문 수량 입력 : ");
        int count = sc.nextInt();
        int total = price * count;
        double discount = 0.0;
        
        if (total >= 1000000) {
            discount = 0.10;
        } else if (total >= 500000) {
            discount = 0.05;
        }

        int discountsum = (int) (total * discount);
        int pay = total - discountsum;

        System.out.println("******* 주문 내용 *******");
        System.out.println("상품명 : " + name);
        System.out.println("가격 : " + price + " 원");
        System.out.println("주문 수량 : " + count + " 개");
        System.out.println("주문액 : " + total + " 원");
        System.out.println("할인액 : " + discountsum + " 원");
        System.out.println("총지불액 : " + pay + " 원");
        
        sc.close();
	}

}
