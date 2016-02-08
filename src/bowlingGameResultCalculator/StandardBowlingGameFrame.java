package bowlingGameResultCalculator;

public class StandardBowlingGameFrame implements BowlingGameFrame {

	private Integer firstRoll = 0;
	private Integer secondRoll = 0;
	private Integer attemps = 0;
	private BowlingGameFrame nextFrame = null;

	public StandardBowlingGameFrame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setScore(Integer numberOfPins) {
		if (attemps.equals(Integer.valueOf(0))) {
			firstRoll = numberOfPins;
		}
		else {
			if (firstRoll + numberOfPins < Integer.valueOf(11)) {
				secondRoll = numberOfPins;
			}
			else {
				throw new IllegalArgumentException("sum of two rolls in frame over 10 ");
			}
		}
		attemps++;		
	}

	@Override
	public Boolean isDone() {
		return (attemps.equals(Integer.valueOf(2)) || attemps.equals(Integer.valueOf(1)) && isStrike());
	}

	@Override
	public Integer getScore() {
		return firstRoll + secondRoll + getBonus();
	}

	private Integer getBonus() {
		Integer bonusPoint = 0;
		if (nextFrame != null) {
			if (isSpare()) {
				bonusPoint = nextFrame.getFirstRoll();
			}
			if (isStrike()) {
				bonusPoint = nextFrame.getStrikeBonus();
			}
		}
		return bonusPoint;
	}

	@Override
	public Boolean isSpare() {
		return (!isStrike() && Integer.valueOf(10).equals(firstRoll+secondRoll));
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
		if (!isStrike()) {
			return firstRoll + secondRoll;
		}
		if (isStrike() && nextFrame != null) {
			return firstRoll + nextFrame.getFirstRoll();
		}
		return firstRoll;
	}

	@Override
	public BowlingGameFrame getNextFrame() {
		return nextFrame;
	}

	@Override
	public void setNextFrame(BowlingGameFrame nextFrame) {
		this.nextFrame = nextFrame;
	}
}