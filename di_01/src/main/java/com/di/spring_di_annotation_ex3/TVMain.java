package com.di.spring_di_annotation_ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context3_1.xml");

        TV tv = ctx.getBean(TV.class);
        tv.volumeUp();
        tv.volumeDown();

        ctx.close();

	}

}
