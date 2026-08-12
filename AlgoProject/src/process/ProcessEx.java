package process;

public class ProcessEx {

	public static void main(String[] args) {
		//순서도 활용
		int i=1;
		int sum = 0;
		
		while(i <= 100) {
			if(i % 2 == 1) {
				sum = sum +i;
			} else {
				sum=sum-i;
			}
			i = i+1;
		}
		System.out.println("1-2+3-4.... +99-100의 합 : "+ sum);
	}

}
