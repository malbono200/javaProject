package exam.constructor_ex;

public class CarAutomobile {

	public static void main(String[] args) {
		Automobile auto = new Automobile("01가1234", "아반떼", "현대", 2022, "자동");
		
        System.out.println("차량 번호: " + auto.carNo);
        System.out.println("차종 : " + auto.carName);
        System.out.println("제조사 : " + auto.carMaker);
        System.out.println("연식 : " + auto.carYear);
        System.out.println("기어변속 : " + auto.autoManual);
        
	}

}
