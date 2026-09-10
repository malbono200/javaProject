package com.spring_aop.xml2;

public class Evaluation {
	private int kor;
    private int eng;
    private int math;
    
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
    
	public void showResult() {
        int total = kor + eng + math;
        double avg = total / 3.0;
        System.out.println("국어: " + kor + ", 영어: " + eng + ", 수학: " + math);
        System.out.println("총점: " + total);
        System.out.println("평균: " + String.format("%.2f", avg));
    }
}
