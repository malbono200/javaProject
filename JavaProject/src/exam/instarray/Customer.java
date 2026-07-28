package exam.instarray;

import java.util.Scanner;

public class Customer {
	
	int customerNo;
    String name;
    String phone;
    String job;
    String gender;
    int age;

    public Customer(int customerNo, String name, String phone, String job, String gender, int age) {
        this.customerNo = customerNo;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.gender = gender;
        this.age = age;
    }

    public void showCustomerInfo() {
        System.out.println(customerNo + " " + name + " " + phone + " " + job + " " + gender + " " + age);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Customer[] customers = new Customer[3];

        System.out.println("****고객 정보 입력****");
        for (int i = 0; i < customers.length; i++) {
            System.out.print("고객번호 : ");
            int customerNo = sc.nextInt();
            System.out.print("고객명 : ");
            String name = sc.next();
            System.out.print("전화번호 : ");
            String phone = sc.next();
            System.out.print("직업 : ");
            String job = sc.next();
            System.out.print("성별 : ");
            String gender = sc.next();
            System.out.print("나이 : ");
            int age = sc.nextInt();

            customers[i] = new Customer(customerNo, name, phone, job, gender, age);
        }

        System.out.println("***고객 정보 출력***");
        for (int i = 0; i < customers.length; i++) {
            customers[i].showCustomerInfo();
        }
        
        sc.close();

	}

}
