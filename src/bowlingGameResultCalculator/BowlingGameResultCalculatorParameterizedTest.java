package bowlingGameResultCalculator;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingGameResultCalculatorParameterizedTest {
	enum Type {LEGAL_ARGUMENT, ILLEGAL_ARGUMENT};

	private BowlingGameResultCalculator bowlingGameresultCalculator;
	private Type type;
	private Integer numberOfZeroRolls;
	private List<Integer> listOfRolls;
	private Integer expectedResult;
	private Logger logger = Logger.getLogger("BowlingGameResultCalculatorParameterizedTest");

	@Before
	public void initializeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = new BowlingGameResultCalculator();
	}

	@After
	public void finalizeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = null;
	}

	public BowlingGameResultCalculatorParameterizedTest(Type type, Integer numberOfZeroRolls,
			List<Integer> listOfRolls, Integer expectedResult) {
		this.type = type;
		this.numberOfZeroRolls = numberOfZeroRolls;
		this.listOfRolls = listOfRolls;
		this.expectedResult = expectedResult;
	}

	@Parameters
	public static Collection testedRolls() {
		return Arrays.asList(new Object[][] {
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(0), 0 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(9), 9 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(1, 1), 2 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(9, 1, 9), 28 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(10, 8, 1), 28 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(10, 10, 5), 45 },
			{ Type.LEGAL_ARGUMENT, 0, Arrays.asList(10, 10, 10), 60 },
			{ Type.LEGAL_ARGUMENT, 18, Arrays.asList(10, 5, 4), 19 },
			{ Type.LEGAL_ARGUMENT, 18, Arrays.asList(9, 1, 2), 12 },
			{ Type.LEGAL_ARGUMENT, 18, Arrays.asList(7, 2), 9 },
			{ Type.ILLEGAL_ARGUMENT, 0, Arrays.asList(-1), 0 },
			{ Type.ILLEGAL_ARGUMENT, 0, Arrays.asList(11), 0 },
			{ Type.ILLEGAL_ARGUMENT, 0, Arrays.asList(6, 6), 0 },
			{ Type.ILLEGAL_ARGUMENT, 20, Arrays.asList(0), 0 }
		});
	}

	@Test
	public void testBowlnigGameResultCalculator_OnlyLegalArgument() {
		Assume.assumeTrue(type == Type.LEGAL_ARGUMENT);
		// given
		
		// when
		for (int i = 0; i < numberOfZeroRolls; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		for (Integer roll : listOfRolls) {
			bowlingGameresultCalculator.roll(roll);
		}
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(expectedResult, result);
		logger.info("rolls: 0x" + numberOfZeroRolls + listOfRolls.toString() + " result: " + expectedResult);
	}

	@Test
	public void testBowlnigGameResultCalculator_IllegalArgument() {
		Assume.assumeTrue(type == Type.ILLEGAL_ARGUMENT);
		// given
		Boolean exception = Boolean.FALSE;
		String exceptionMessage = null;
		
		// when
		for (int i = 0; i < numberOfZeroRolls; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		try {
			for (Integer roll : listOfRolls) {
				bowlingGameresultCalculator.roll(roll);
			}
		} catch (IllegalArgumentException e) {
			exception = Boolean.TRUE;
			exceptionMessage = e.toString();
		}

		// then
		assertTrue(exception);
		logger.info("rolls: 0x" + numberOfZeroRolls + listOfRolls.toString() + " result: " + exceptionMessage);
	}
}
