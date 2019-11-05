package DIrandomFortune;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public GolfCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Golf time for 3 h";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
