package threads.sync;

public class User2 extends Thread {
private Calculator calculator; //공통 사용 객체에 대한 필드
	
	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
