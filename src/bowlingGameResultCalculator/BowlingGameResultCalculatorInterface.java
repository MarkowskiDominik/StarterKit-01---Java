package bowlingGameResultCalculator;

public interface BowlingGameResultCalculatorInterface {

	/**
	 * Register a thrown a ball.
	 * @param numberOfPins number of knocked down pins
	 */
	public void roll(Integer numberOfPins);

	/**
	 * @return current game score
	 */
	public Integer score();

	/**
	 * @return true if a game is over, otherwise false
	 */
	public Boolean isFinished();
}
