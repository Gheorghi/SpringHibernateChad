package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JumpCoach.class);
		
		//get the bean from the spring container
		Coach theCoach = context.getBean("swimmCoach", JumpCoach.class);
		
		//call method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get a daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}
}
