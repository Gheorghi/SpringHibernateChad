package DIrandomFortune;

import java.util.Random;

public class VeryHappyFrotuneService implements FortuneService {

	String[] randomValues = { "You are happy GUY", "Try next TIME", "Free cheese in a hole" };

	@Override
	public String getFortune() {
		return randomValues[new Random().nextInt(randomValues.length)];
	}
}
