package exam;

import java.util.Random;

public class ArrayEx2 {

	public static void main(String[] args) {
		int[] lotto = new int[6];
        Random rd = new Random(); 
        
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = rd.nextInt(45) + 1; 
            
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        
        for (int num : lotto) {
            System.out.print(num + " ");
        }

	}

}
