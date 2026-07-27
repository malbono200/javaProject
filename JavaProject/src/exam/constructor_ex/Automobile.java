package exam.constructor_ex;

public class Automobile extends Car {
	String autoManual;
	
	public Automobile(String carNo, String carName, String carMaker, int carYear, String autoManual) {
        super(carNo, carName, carMaker, carYear);
        this.autoManual = autoManual;
    }

}
