package theGameOfLife;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

	private GameOfLife gameOfLife;
	private LinkedList<ConcretObserver> observers;
	private LinkedList<Cell> cells;
	private Logger logger = Logger.getLogger("BowlingGameResultCalculator");

	@Before
	public void initializeBowlingGameResultCalculator() {
		gameOfLife = new GameOfLife();
		observers = new LinkedList<ConcretObserver>();
		observers.add(new ConcretObserver());
		cells = new LinkedList<Cell>();
	}

	@After
	public void finalizeBowlingGameResultCalculator() {
		gameOfLife = null;
	}

	@Test
	public void oneCellDeadInNextRound() {
		// given
		cells.add(new Cell(1, 1, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		observers.getFirst().setCells(cells);
		
		// when
		gameOfLife.getUniverse().symulationOfCellsLife(observers.getFirst().getCells());
		logger.info(((Integer)observers.getFirst().getCells().size()).toString());
		
		// then
		assertEquals(Integer.valueOf(0), ((Integer)observers.getFirst().getCells().size()));
	}
	
	@Test
	public void test() {
		// given
		cells.add(new Cell(1, 1, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		cells.add(new Cell(1, 3, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		cells.add(new Cell(2, 2, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		cells.add(new Cell(3, 3, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		cells.add(new Cell(4, 1, CellCondition.ALIVE, new LinkedList<ConcretObserver>(observers)));
		observers.getFirst().setCells(cells);
		
		// when
		gameOfLife.getUniverse().symulationOfCellsLife(observers.getFirst().getCells());
		logger.info(((Integer)observers.getFirst().getCells().size()).toString());
		for (Cell cell : observers.getFirst().getCells()) {
			logger.info(cell.getRow() + " " + cell.getColumn());
		}
		
		gameOfLife.getUniverse().symulationOfCellsLife(observers.getFirst().getCells());
		logger.info(((Integer)observers.getFirst().getCells().size()).toString());
		
		// then
		assertEquals(Integer.valueOf(7), ((Integer)observers.getFirst().getCells().size()));
	}
}
