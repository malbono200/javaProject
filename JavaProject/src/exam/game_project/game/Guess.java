package exam.game_project.game;

import java.util.Scanner;
import java.util.Random;

public class Guess {
	public void play(Scanner sc) {
        System.out.println("**********************************");
        System.out.println("숫자 알아맞히기 게임");
        System.out.println("**********************************");
        
        Random rand = new Random();
        int targetNumber = rand.nextInt(10) + 1; // 1부터 10까지의 숫자
        
        System.out.print("어떤 숫자일까요? 알아 맞혀보세요^^ (1~10)\n숫자 입력: ");
        
        while (true) {
            int userGuess = sc.nextInt();
            
            if (userGuess == targetNumber) {
                System.out.println("드디어 맞혔습니다~ 나의 숫자는 " + targetNumber + "입니다");
                break;
            } else {
                System.out.print("아닙니다. 다시 맞혀보세요^^ 다시 입력 : ");
            }
        }
    }
}
