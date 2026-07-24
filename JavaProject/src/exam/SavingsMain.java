package exam;

public class SavingsMain {

	public static void main(String[] args) {
		Savings savings = new Savings();
        savings.setName();
        savings.setBalance();

        System.out.println("예금주 : " + savings.getName());
        System.out.println("입금전 잔액 : " + savings.getBalance());
        
        savings.inputDeposit();
        
        System.out.println("이자 : " + savings.getInterest());
        System.out.println("최종 잔액 : " + savings.getBalance());
        
	}

}
