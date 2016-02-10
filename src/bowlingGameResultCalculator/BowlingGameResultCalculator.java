package bowlingGameResultCalculator;

import java.util.LinkedList;
import java.util.logging.Logger;

public class BowlingGameResultCalculator implements BowlingGameResultCalculatorInterface {

	private static final Integer MAX_FRAME = 10;
	private static final Integer MAX_PINS = 10;
	private LinkedList<Frame> bowlingGameFrames;
	private Integer gameScore = 0;
	private Integer frameCounter = 0;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger("BowlingGameResultCalculator");

	public BowlingGameResultCalculator() {
		bowlingGameFrames = new LinkedList<Frame>();
	}

	public void roll(Integer numberOfPins) throws IllegalArgumentException {
		if (numberOfPins > MAX_PINS || numberOfPins < Integer.valueOf(0)) {
			throw new IllegalArgumentException("illegal argument " + numberOfPins);
		}

		Frame currentFrame = getCurrentFrame();
		if (currentFrame == null) {
			throw new IllegalArgumentException("to many rolls");
		}
		currentFrame.addScore(numberOfPins);

		//logger.info("frame: " + frameCounter + " | roll: " + numberOfPins.toString());
	}

	private Frame getCurrentFrame() {
		Frame currentFrame = null;

		if (!isFinished()) {
			if (!bowlingGameFrames.isEmpty()) {
				currentFrame = bowlingGameFrames.getLast();
			}
	
			if (currentFrame == null || currentFrame.isDone()) {
				bowlingGameFrames.add(FrameFactory.getBowlingGameFrame(++frameCounter));
			}
			
			if (currentFrame instanceof StandardFrame) {
				StandardFrame tmp = (StandardFrame) currentFrame;
				tmp.setNextFrame(bowlingGameFrames.getLast());
			}
			
			currentFrame = bowlingGameFrames.getLast();
		}
		return currentFrame;
	}

	public Integer score() {
		for (Frame bowlingGameFrame : bowlingGameFrames) {
			gameScore += bowlingGameFrame.getScore();
		}
		return gameScore;
	}

	public Boolean isFinished() {
		return (frameCounter.equals(MAX_FRAME) && bowlingGameFrames.getLast().isDone());
	}
}
