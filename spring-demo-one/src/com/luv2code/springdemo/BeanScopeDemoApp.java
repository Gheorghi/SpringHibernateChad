package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach= context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach= context.getBean("myCoach", Coach.class);

		theCoach.getDailyFortune();
		alphaCoach.getDailyWorkout();
		
		//check if the are the same
		boolean result = (theCoach==alphaCoach);
		
		//print the results
		System.out.println("Print to the same object: "+ result);
		System.out.println("Memory location for theCoach: "+ theCoach);
		System.out.println("Memory location for alphaCoach: "+ alphaCoach);
		

		
		context.close();
	}

}
