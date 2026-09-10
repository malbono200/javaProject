package com.spring_aop.annotationex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
                new GenericXmlApplicationContext("classpath:application-config2-2.xml");

        Evaluation evaluation = context.getBean("evaluation", Evaluation.class);
        evaluation.showResult();

        Circle circle = context.getBean("circle", Circle.class);
        circle.showResult();

        context.close();
    }
}
