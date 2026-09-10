package com.spring_aop.xml2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerfomanceAspect {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature s = joinPoint.getSignature(); // joinpoint의 정보 추출
        String methodName = s.getName(); // 핵심기능 메소드 이름 추출

        System.out.println("--------------------------------");
        System.out.println("[LOG]Before:" + methodName + "() :실행 시작");
        System.out.println("--------------------------------");

        long startTime = System.nanoTime();
        Object result = null;

        try {
            result = joinPoint.proceed(); // 핵심기능 수행
        } catch (Exception e) {
            System.out.println("[LOG]Exception: " + methodName);
        }

        long endTime = System.nanoTime();

        System.out.println("--------------------------------");
        System.out.println("[LOG]After:" + methodName + "() :실행 종료");
        System.out.println("[LOG]:" + methodName + "() 실행시간:" + (endTime - startTime) + "ns");
        System.out.println("--------------------------------");

        return result;
    }
}
