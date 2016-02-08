package bowlingGameResultCalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameResultCalculatorTest {

	private BowlingGameResultCalculator bowlingGameresultCalculator;

	@Before
	public void initializeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = new BowlingGameResultCalculator();
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
			exception = Boolean.TRUE;
		}

		// then
		assertTrue(exception);
	}

	@Test
	public void shouldReturn_2_ForRolls_2_2() {
		// given
		// when
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		bowlingGameresultCalculator.roll(Integer.valueOf(1));
		Integer result = bowlingGameresultCalculator.score();

		// then
		assertEquals(Integer.valueOf(2), result);
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
	
	@After
	public void finalizeBowlingGameResultCalculator() {
		bowlingGameresultCalculator = null;
	}
}