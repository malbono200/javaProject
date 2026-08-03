package threads.sync;

//공통 객체로 사용할 클래스
public class Calculator2 {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//memory 필드의 수정과 조회가 한번에 발생하는 메소드, 공통사용하는 경우 한 스레드가 메소드 사용이 종료되기 전
	//다른 스레드가 메서드 사용을 진행할 수 있음
	//
	public void setMemory(int memory) {
		this.memory = memory;
		//메모리 설정 후 2초 sleep후 memory 필드 출력
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}
