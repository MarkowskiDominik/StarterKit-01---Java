package bowlingGameResultCalculator;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameResultCalculatorTest {

	private BowlingGameResultCalculator bowlingGameresultCalculator;
	private Logger logger = Logger.getLogger("BowlingGameResultCalculatorTest");

	@Before
	public void initializeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = new BowlingGameResultCalculator();
	}

	@After
	public void finalizeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = null;
	}
	
	@Test
	public void shouldReturn_0_ForRoll_0() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(0));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(0), result);
	}

	@Test
	public void shouldReturn_9_ForRoll_9() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(9), result);
	}

	@Test
	public void shouldReturn_Exception_ForRoll_Minus1() {
		// given
		Boolean exception = Boolean.FALSE;

		// when
		try {
			bowlingGameresultCalculator.roll(Integer.valueOf(-1));
		} catch (IllegalArgumentException e) {
			logger.info(e.toString());
			exception = Boolean.TRUE;
		}

		// then
		assertTrue(exception);
	}

	@Test
	public void shouldReturn_Exception_ForRoll_11() {
		// given
		Boolean exception = Boolean.FALSE;

		// when
		try {
			bowlingGameresultCalculator.roll(Integer.valueOf(11));
		} catch (IllegalArgumentException e) {
			logger.info(e.toString());
			exception = Boolean.TRUE;
		}

		// then
		assertTrue(exception);
	}

	@Test
	public void shouldReturn_2_ForRolls_1_1() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(2), result);
	}

	@Test
	public void shouldReturn_Exception_ForRoll_6_6() {
		// given
		Boolean exception = Boolean.FALSE;

		// when
		try {
			bowlingGameresultCalculator.roll(Integer.valueOf(6));
			bowlingGameresultCalculator.roll(Integer.valueOf(6));
		} catch (IllegalArgumentException e) {
			logger.info(e.toString());
			exception = Boolean.TRUE;
		}

		// then
		assertTrue(exception);
	}

	@Test
	public void shouldReturn_28_ForRolls_9_1_9() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(28), result);
	}
	
	@Test
	public void shouldReturn_28_ForRolls_10_8_1() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(8));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(28), result);
	}
	
	@Test
	public void shouldReturn_45_ForRolls_10_10_5() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(45), result);
	}
	
	@Test
	public void shouldReturn_60_ForRolls_10_10_10() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(60), result);
	}

	@Test
	public void shouldReturn_19_ForEightenRollsZeroAndLastFrameRolls_10_5_4() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(10));
		bowlingGameresultCalculator.roll(Integer.valueOf(5));
		bowlingGameresultCalculator.roll(Integer.valueOf(4));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(19), result);
	}
	
	@Test
	public void shouldReturn_12_ForEightenRollsZeroAndLastFrameRolls_9_1_2() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(9));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(2));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(12), result);
	}
	
	@Test
	public void shouldReturn_9_ForEightenRollsZeroAndLastFrameRolls_7_2() {
		// given
		// when
		for (int i = 0; i < 18; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		bowlingGameresultCalculator.roll(Integer.valueOf(7));
		bowlingGameresultCalculator.roll(Integer.valueOf(2));
		Integer result = bowlingGameresultCalculator.score();
		
		// then
		assertEquals(Integer.valueOf(9), result);
	}

	@Test
	public void shouldReturn_Exception_ForToManyRolls() {
		// given
		Boolean exception = Boolean.FALSE;

		// when
		for (int i = 0; i < 20; i++) {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		}
		try {
			bowlingGameresultCalculator.roll(Integer.valueOf(0));
		} catch (IllegalArgumentException e) {
			logger.info(e.toString());
			exception = Boolean.TRUE;
		}

		// then
		assertTrue(exception);
	}
}