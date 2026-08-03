package threads.sync;

//공통 객체로 사용할 클래스
public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//이 객체가 공용 객체로 사용이 될때 쓰레드 사용 시작 후 점유해서 사용가능하도록 동기화
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		//메모리 설정 후 2초 sleep후 memory 필드 출력
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}
