package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JumpCoach implements Coach {
		
	@Value("${fortuneDetail")
	private String fortuneDetail;
	
	@Autowired
	@Qualifier("basicFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Jump Every Day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
