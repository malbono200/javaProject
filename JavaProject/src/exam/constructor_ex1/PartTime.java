package exam.constructor_ex1;

public class PartTime extends Worker {
	int hours;
    int unitPrice;
    
    public PartTime(String joominNo, String name, int unitPrice, int hours) {
        super(joominNo, name);
        this.unitPrice = unitPrice;
        this.hours = hours;
    }
    
    public int calculatePay() {
        return hours * unitPrice;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n시급 : " + unitPrice + "원\n근무시간: " + hours + " 시간\n총지불액 : " + calculatePay() + " 원";
    }
}
