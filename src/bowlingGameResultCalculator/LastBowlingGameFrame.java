package bowlingGameResultCalculator;

public class LastBowlingGameFrame implements BowlingGameFrame {

	private Integer firstRoll = 0;
	private Integer secondRoll = 0;
	private Integer thirdRoll = 0;
	private Integer attemps = 0;

	public LastBowlingGameFrame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setScore(Integer numberOfPins) {
		if (attemps.equals(Integer.valueOf(0))) {
			firstRoll = numberOfPins;
		} else {
			if (firstRoll + numberOfPins < Integer.valueOf(11)) {
				secondRoll = numberOfPins;
			} else {
				throw new IllegalArgumentException("two rolls over 10 ");
			}
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
	public Integer getStrikeBonus() {
		return firstRoll + secondRoll;
	}

	@Override
	public BowlingGameFrame getNextFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNextFrame(BowlingGameFrame nextFrame) {
		// TODO Auto-generated method stub
		
	}
}
