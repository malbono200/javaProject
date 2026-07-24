package exam;

public class Member {
	String id;
    String name;
    int age;
    String phone;
    String address;

    public Member(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public void showMember() {
        System.out.println("-----회원 정보 출력-----");
        System.out.println("ID : " + this.id);
        System.out.println("성명 : " + this.name);
        System.out.println("나이 : " + this.age);
        System.out.println("전화 : " + this.phone);
        System.out.println("주소 : " + this.address);
    }
}
