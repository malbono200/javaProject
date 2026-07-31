package exception.trycatch;

public class CatchOrderEx2 {

	public static void main(String[] args) {
		// catch부문이 여러번 있을 때 catch 순서에 따라 상위 클래스가 먼저 나타면 해당 catch 실행하고 나머지 catch는 점프
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			System.out.println("args[0]:"+data1);
			System.out.println("args[1]:"+data2);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다"); 
		}catch(Exception e) { //예외처리 클래스 중 최상위 클래스
			System.out.println("실행에 문제가 있습니다");
		}finally {
			System.out.println("다시 실행");
		}
	}

}
