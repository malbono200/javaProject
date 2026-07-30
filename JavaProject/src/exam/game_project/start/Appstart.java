package exam.game_project.start;

//import를 통해 다른 패키지에 있는 클래스 사용 가능
import exam.game_project.game.*;
import exam.game_project.info.*;

import java.util.Scanner;


public class Appstart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        System.out.println("**********************************");
        System.out.println("** ★★게임에 오신 것을 환영합니다^^ **");
        System.out.println("**********************************");
        
        while (true) {
            System.out.println("\n**** 메뉴 ****");
            System.out.println("1. 애플리케이션 정보");
            System.out.println("2. 가위바위보 게임");
            System.out.println("3. 숫자 알아맞히기 게임");
            System.out.println("4. 종료");
            System.out.print("메뉴 번호 입력 : ");
            
            int menu = sc.nextInt();
            
            if (menu == 1) {
                AppInfo appInfo = new AppInfo();
                appInfo.showInfo();
            } else if (menu == 2) {
                GaBaBo gaBaBo = new GaBaBo();
                gaBaBo.play(sc);
            } else if (menu == 3) {
                Guess guess = new Guess();
                guess.play(sc);
            } else if (menu == 4) {
                System.out.println("******************************");
                System.out.println("종료합니다!");
                System.out.println("******************************");
                break;
            }
        }
        
        sc.close();

	}

}
