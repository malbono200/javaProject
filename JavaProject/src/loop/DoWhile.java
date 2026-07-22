package loop;

public class DoWhile {

	public static void main(String[] args) {
		
		int i=0;
		while(i <= 10) {
			System.out.println("최소 0번 수행");
			System.out.println(i);
			i++;
		}
		
		i=100;
		do {
			System.out.println("최소 1번 수행");
			System.out.println(i);
			i++;
		} while(i <= 10);

	}

}
