package com.spring_aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

/*
 * 공통기능
 * 공통기능 메소드 포함
 * 시작시간 종료시간 출력의 기능을 핵심기능의 공통사항 가정
 * Gugudan 클래스와 Rect클래스의 핵심기능메소드 수행 전/후에 시간 출력
 */

// 공통기능 메소드 포함 (proxy의 절차를 구성하게 됨)
public class PerfomanceAspect {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature s = joinPoint.getSignature(); //joinpoint의 정보 추출
		String methodName = s.getName(); //핵심기능 메소드 이름 추출
		
		System.out.println("--------------------------------");
        System.out.println("[LOG]Before:"+methodName+"() :실행 시작");
        System.out.println("--------------------------------");
        
        long startTime = System.nanoTime();
        Object result = null;
        
        try {
        	result = joinPoint.proceed(); //핵심기능 수행
        } catch(Exception e) {
        	System.out.println("[LOG]Exception: "+methodName);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("--------------------------------");
        System.out.println("[LOG]After:"+methodName+"() :실행 종료");
        System.out.println("[LOG]:"+methodName+"() 실행시간:"+(endTime-startTime)+"ns");
        System.out.println("--------------------------------");
        
        return result;
	} 
}
