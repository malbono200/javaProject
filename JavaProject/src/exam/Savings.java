package exam;

import java.util.Scanner;

public class Savings {
	private String name;
    private int deposit;
    private int interest;
    private int balance;

    public void setName() {
        this.name = "홍길동";
    }

    public void setBalance() {
        this.balance = 10000;
    }

    public String getName() {
        return name;
    }

    public void inputDeposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("예금액 입력 : ");
        this.deposit = sc.nextInt();
        this.balance += this.deposit;
        sc.close();
    }

    public int getInterest() {
        this.interest = (int)(this.balance * 0.1);
        this.balance += this.interest;
        return this.interest;
    }

    public int getBalance() {
        return this.balance;
    }
}
