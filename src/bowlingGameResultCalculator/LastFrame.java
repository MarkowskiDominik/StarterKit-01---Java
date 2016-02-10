package bowlingGameResultCalculator;

public class LastFrame implements Frame {

	private Integer firstRoll = 0;
	private Integer secondRoll = 0;
	private Integer thirdRoll = 0;
	private Integer attemps = 0;

	public LastFrame() {
	}

	@Override
	public void addScore(Integer numberOfPins) throws IllegalArgumentException {
		if (attemps.equals(Integer.valueOf(0))) {
			firstRoll = numberOfPins;
		}
		if (attemps.equals(Integer.valueOf(1))) {
			secondRoll = numberOfPins;
		}
		if (!isStrike() && firstRoll + secondRoll > Integer.valueOf(11)) {
			throw new IllegalArgumentException("two rolls over 10 in last frame");
		}
		if (attemps.equals(Integer.valueOf(2)) && isBonusRoll()) {
			thirdRoll = numberOfPins;
		}
		attemps++;
	}

	@Override
	public Boolean isDone() {
		return (attemps.equals(Integer.valueOf(3)) || attemps.equals(Integer.valueOf(2)) && !isBonusRoll());
	}

	private Boolean isBonusRoll() {
		return (isSpare() || isStrike());
	}

	@Override
	public Integer getScore() {
		return firstRoll + secondRoll + thirdRoll;
	}

	@Override
	public Boolean isSpare() {
		return (!isStrike() && Integer.valueOf(10).equals(firstRoll + secondRoll));
	}

	@Override
	public Integer getFirstRoll() {
		return firstRoll;
	}

	@Override
	public Boolean isStrike() {
		return (firstRoll.equals(Integer.valueOf(10)));
	}

	@Override
	public Integer getStrikeBonusToPreviousFrame() {
		return firstRoll + secondRoll;
	}
}
