package interfaceex;

public class RemoteControlMain {

	public static void main(String[] args) {
		// 인터페이스도 다형성 사용 가능
		// 인터페이스 참조 변수
		IRemoteControl rc = null;
		
		// 구현클래스 Television객체를 인터페이스 참조변수에 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(10);
		rc.SetMute(true); //재정의 하지 않음(디폴트 메소드 호출)
		rc.SetMute(false);
		rc.turnoff();
		
		System.out.println("-----------------------------");
		//구현클래스 Audio 객체를 인터페이스 참조변수에 대입
		rc = new Audio(); //다형성
		rc.turnOn();
		rc.setVolume(12);
		rc.SetMute(true); //재정의한 메소드 호출
		rc.turnoff();
		
		IRemoteControl.changeBattery(); //static 메소드 호출
	}

}
