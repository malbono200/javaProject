package exam.instarray;

import java.util.Scanner;

public class Course {
	String name;
    String professor;
    int year;
    int credit;

    public void input(Scanner sc) {
        System.out.print("과목명 : ");
        this.name = sc.next();
        System.out.print("교수 : ");
        this.professor = sc.next();
        System.out.print("학년 : ");
        this.year = sc.nextInt();
        System.out.print("이수 학점 : ");
        this.credit = sc.nextInt();
    }

    public void output() {
        System.out.println(name + " " + professor + " " + year + "학년 " + credit + "학점");
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[3];

        System.out.println("****과목 정보 입력****");
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course();
            courses[i].input(sc);
        }

        System.out.println("****과목 정보 출력****");
        for (int i = 0; i < courses.length; i++) {
            courses[i].output();
        }
        
        sc.close();

	}

}
