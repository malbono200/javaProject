package exam.collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        
        map.put("apple", "사과");
        map.put("summer", "여름");
        map.put("candy", "사탕");
        map.put("school", "학교");
        map.put("water", "물");

        while (true) {
            System.out.print("찾고 싶은 단어는? ");
            String word = sc.next();
            
            if (word.equals("exit")) {
                System.out.println("종료합니다...");
                break;
            }

            String meaning = map.get(word);
            if (meaning == null) {
                System.out.println(word + "는 없는 단어 입니다.");
            } else {
                System.out.println(meaning);
            }
        }
        sc.close();
        
	}

}
