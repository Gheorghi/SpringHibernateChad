package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all our related advices for logging
	
	// let's start with an @Before advice
	

<<<<<<< HEAD
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
=======
	@Before("execution(* add*(..))")
>>>>>>> a807590cb13c5d68d2b5b714e01a142caea0ca89
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>>> Executing @Before advice on method");
		
	}
}
