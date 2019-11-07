package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring conf file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// call our set literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		CricketCoach alphaCoach= context.getBean("myCricketCoach", CricketCoach.class);

		theCoach.getDailyFortune();
		alphaCoach.getDailyWorkout();
		
		//check if the are the same
		boolean result = (theCoach==alphaCoach);
		
		System.out.println("Print to the same object: "+ result);
		System.out.println("Memory location for theCoach: "+ theCoach);
		System.out.println("Memory location for alphaCoach: "+ alphaCoach);
		
		// close the context
		context.close();
		
		
	}

}
