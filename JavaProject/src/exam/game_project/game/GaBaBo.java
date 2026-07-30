package exam.game_project.game;

import java.util.Scanner;
import java.util.Random;

public class GaBaBo {
	public void play(Scanner sc) {
        System.out.println("**********************************");
        System.out.println("가위바위보 게임");
        System.out.println("**********************************");
        
        Random rand = new Random();
        
        while (true) {
            System.out.print("가위 바위 보 게임 : 1. 가위, 2. 바위, 3. 보\n번호 입력 : ");
            int userChoice = sc.nextInt();
            int computerChoice = rand.nextInt(3) + 1;
            
            String comStr = "";
            if (computerChoice == 1) comStr = "가위";
            else if (computerChoice == 2) comStr = "바위";
            else if (computerChoice == 3) comStr = "보";

            if (userChoice == computerChoice) {
                System.out.println("비겼습니다!");
            } else if ((userChoice == 1 && computerChoice == 3) || 
                       (userChoice == 2 && computerChoice == 1) || 
                       (userChoice == 3 && computerChoice == 2)) {
                System.out.println("당신이 이겼습니다^^");
            } else {
                System.out.println("당신이 졌습니다.");
            }
            System.out.println("컴퓨터는 " + comStr + "입니다.");
            
            System.out.print("계속하시겠습니까? (y): ");
            String continueGame = sc.next();
            if (!continueGame.equalsIgnoreCase("y")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

}
