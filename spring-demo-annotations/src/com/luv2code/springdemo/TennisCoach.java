package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("basicFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff");
	}

	// define my init method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
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
