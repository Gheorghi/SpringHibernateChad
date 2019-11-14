package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//load spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrive bean from spring config file
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theAlpha = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result = (theCoach==theAlpha);
		
		System.out.println("\nPointinf to the same object: "+ result);
		System.out.println("\nMemory location for the coach: "+ theCoach);
		System.out.println("\nMemory location for the alphaCoach: "+ theAlpha);
		
		//close the context
		context.close();
	}

}
