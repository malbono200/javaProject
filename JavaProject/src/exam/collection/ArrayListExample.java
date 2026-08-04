package exam.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.print("단어를 입력하세요>>");
            String word = sc.nextLine();
            list.add(word);
        }

        System.out.println("---------------------------------");
        for (String w : list) {
            System.out.print(w + " ");
        }

        String longestWord = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > longestWord.length()) {
                longestWord = list.get(i);
            }
        }

        System.out.println();
        System.out.println("가장 긴 단어는 : " + longestWord);
        System.out.println("가장 긴 단어의 길이는 : " + longestWord.length());
        sc.close();
	}

}
