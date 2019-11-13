package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings 
	private String[] data = {
		"Bawre og the wolf in sheeps's clothying",
		"Dilligence is the mother if tgiid luck",
		"The journey is the reward"
	};
	
	// Crete a random number generator
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}
