package exam;

public class ForEx1 {

	public static void main(String[] args) {
		int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("1~10 사이 홀수의 합 : " + sum);
        
	}

}
