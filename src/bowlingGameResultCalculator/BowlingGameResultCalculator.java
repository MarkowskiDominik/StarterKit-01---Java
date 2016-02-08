package bowlingGameResultCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class BowlingGameResultCalculator implements BowlingGameResultCalculatorInterface {

	private static Logger logger = Logger.getLogger("BowlingGameResultCalculator");
	private static final Integer MAX_FRAME = 10;
    private static final Integer MAX_PINS = 10;
	private List<BowlingGameFrame> bowlingGameFrames;
	private Integer gameScore = 0;
	private Integer frameCounter = 0;
	
	public BowlingGameResultCalculator() {
		bowlingGameFrames = new LinkedList<BowlingGameFrame>();
		
		for (int i = 0; i < MAX_FRAME; i++) {
			bowlingGameFrames.add(new StandardBowlingGameFrame());
		}
	}
	
	public void roll(Integer numberOfPins) {
		if (numberOfPins > MAX_PINS || numberOfPins < Integer.valueOf(0)) {
			throw new IllegalArgumentException("illegal argument " + numberOfPins);
		}
		
		BowlingGameFrame currentFrame = getCurrentFrame();
		currentFrame.setScore(numberOfPins);
		
		logger.fine(numberOfPins.toString());
	}
	
	private BowlingGameFrame getCurrentFrame() {
		
		BowlingGameFrame currentFrame = bowlingGameFrames.get(frameCounter);
		
		if (currentFrame.isDone()) {
			currentFrame.setNextFrame(bowlingGameFrames.get(++frameCounter));
			currentFrame = currentFrame.getNextFrame();
		}
		return currentFrame;
	}

	public Integer score() {
		for (BowlingGameFrame bowlingGameFrame : bowlingGameFrames) {
			gameScore += bowlingGameFrame.getScore();
		}
		return gameScore;
	}

	public Boolean isFinished() {
		return Boolean.TRUE;
	}

}
