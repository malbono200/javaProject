package exam;

public class WhileEx1 {

	public static void main(String[] args) {
		int i = 1;
        int sum = 0;
        while (i <= 100) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        System.out.println("1~100 짝수의 합 : " + sum);

	}

}
