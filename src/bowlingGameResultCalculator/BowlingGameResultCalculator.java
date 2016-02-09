package bowlingGameResultCalculator;

import java.util.LinkedList;
import java.util.logging.Logger;

public class BowlingGameResultCalculator implements BowlingGameResultCalculatorInterface {

	private static Logger logger = Logger.getLogger("BowlingGameResultCalculator");
	private static final Integer MAX_FRAME = 10;
	private static final Integer MAX_PINS = 10;
	private LinkedList<BowlingGameFrame> bowlingGameFrames;
	private Integer gameScore = 0;
	private Integer frameCounter = 0;

	public BowlingGameResultCalculator() {
		bowlingGameFrames = new LinkedList<BowlingGameFrame>();
	}

	public void roll(Integer numberOfPins) {
		if (numberOfPins > MAX_PINS || numberOfPins < Integer.valueOf(0)) {
			throw new IllegalArgumentException("illegal argument " + numberOfPins);
		}

		BowlingGameFrame currentFrame = getCurrentFrame();
		if (currentFrame == null) {
			throw new IllegalArgumentException("to many rolls");
		}
		currentFrame.addScore(numberOfPins);

		//logger.info("frame: " + frameCounter + " | roll: " + numberOfPins.toString());
	}

	private BowlingGameFrame getCurrentFrame() {
		BowlingGameFrame currentFrame = null;

		if (!isFinished()) {
			if (!bowlingGameFrames.isEmpty()) {
				currentFrame = bowlingGameFrames.getLast();
			}
	
			if (currentFrame == null || currentFrame.isDone()) {
				bowlingGameFrames.add(BowlingGameFrameFactory.getBowlingGameFrame(++frameCounter));
			}
			
			if (currentFrame instanceof StandardBowlingGameFrame) {
				StandardBowlingGameFrame tmp = (StandardBowlingGameFrame) currentFrame;
				tmp.setNextFrame(bowlingGameFrames.getLast());
			}
			
			currentFrame = bowlingGameFrames.getLast();
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
		return (frameCounter.equals(MAX_FRAME) && bowlingGameFrames.getLast().isDone());
	}
}
