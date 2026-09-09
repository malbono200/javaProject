package com.di.spring_di_xml_setter_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context2_1.xml");

        TV tv = ctx.getBean("tv", TV.class);
        tv.volumeUp();
        tv.volumeDown();

        ctx.close();

	}

}
