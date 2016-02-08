package bowlingGameResultCalculator;

public interface BowlingGameFrame {

	void setScore(Integer numberOfPins);
	
	public Integer getScore();

	public Boolean isDone();

	public Boolean isSpare();
	
	public Integer getFirstRoll();

	public Boolean isStrike();
	
	public Integer getStrikeBonus();
	
	public BowlingGameFrame getNextFrame();

	void setNextFrame(BowlingGameFrame nextFrame);
}
