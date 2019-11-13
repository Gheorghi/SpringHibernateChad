package com.luv2code.springdemo;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicFortuneService implements FortuneService {

	Random randomFortune = new Random();
	
	@Value("${fortuneDetail}")
	private String[] fortunes;
	
	@Override
	public String getFortune() {
		return fortunes[randomFortune.nextInt(fortunes.length)];
	}
	
}
