package com.spring_aop.annotationex;

public class Circle {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void showResult() {
        System.out.println("반지름: " + radius);
        System.out.println("원의 면적: " + String.format("%.2f", (Math.PI * radius * radius)));
        System.out.println("원의 둘레: " + String.format("%.2f", (Math.PI * (radius * 2))));
    }
}
