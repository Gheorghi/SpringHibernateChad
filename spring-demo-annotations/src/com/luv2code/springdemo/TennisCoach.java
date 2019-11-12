package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	/*
	 * @Autowired public void doSomeCrazyStaff(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService;
	 * System.out.println(">> TennisCoach: inside doSomeCrazyStaff"); }
	 */
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
