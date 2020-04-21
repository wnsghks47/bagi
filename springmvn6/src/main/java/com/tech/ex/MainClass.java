package com.tech.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String classpath="classpath:appCtx.xml";
		AbstractApplicationContext ctx=new GenericXmlApplicationContext(classpath);
		
		MyInfo myInfo=ctx.getBean("myInfo",MyInfo.class);
		myInfo.getInfo();
		
		
		ctx.close();
		
	}

}