package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PinpongCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "5 hors per day is OK!!! Practice your backhand";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
