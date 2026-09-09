package com.di.spring_di_xml_constructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVmain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context1_1.xml");

        TV tv = ctx.getBean("tv", TV.class);
        tv.volumeUp();
        tv.volumeDown();

        ctx.close();

	}

}
