package exam.finalalgoex;

import java.util.Scanner;

public class StorageMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTreeStorage<Product> storage = new BinarySearchTreeStorage<>();
		
		while (true) {
			System.out.println("=====메뉴=====");
            System.out.println("1. 새 품목 등록");
            System.out.println("2. 재고 품목 반출");
            System.out.println("3. 종료");
            System.out.print("선택 : ");
            int menu = sc.nextInt();
            
            if (menu == 1) {
                System.out.print("품목명: ");
                String name = sc.next();
                System.out.print("재고수량: ");
                int stock = sc.nextInt();
                
                storage.add(new Product(name, stock));
                System.out.println("등록 완료.");
                
            } else if (menu == 2) {
                System.out.print("반출 품목명: ");
                String name = sc.next();
                System.out.print("반출 수량: ");
                int quantity = sc.nextInt();

                System.out.println("재고 반출: " + name + " " + quantity);
                int resTemp = storage.updateStock(new Product(name), quantity);
                System.out.println("재고 반출 결과: " + resTemp);

                if (resTemp == 0) {
                    System.out.println("재고가 없는 품목이므로 재고 품목에서 삭제합니다");
                    storage.remove(new Product(name));
                } else if (resTemp == -1) {
                    System.out.println("반출수량만큼 재고가 없습니다");
                } else if (resTemp > 0) {
                    System.out.println("재고 반출 완료");
                } else {
                    System.out.println("반출하려는 품목이 창고에 없습니다");
                }
                
                System.out.print("재고 확인: ");
                storage.preorder();
                System.out.println();
                
            } else if (menu == 3) {
                break;
            }
		}
		sc.close();
	}

}
