package theGameOfLife;

import java.util.LinkedList;

public class ConcretObserver implements Observer {

	private LinkedList<Cell> cells;

	public ConcretObserver() {
		cells = new LinkedList<Cell>();
	}

	@Override
	public void updateSubjects(Subject cell) {
		if (((Cell) cell).getCondition().equals(CellCondition.ALIVE)) {
			cells.remove(cell);
		}

		if (((Cell) cell).getCondition().equals(CellCondition.NEIGHBORHOOD)) {
			((Cell) cell).setCondition(CellCondition.ALIVE);
			cells.add((Cell) cell);
		}
	}

	public LinkedList<Cell> getCells() {
		return cells;
	}

	public void setCells(LinkedList<Cell> cells) {
		this.cells = cells;
	}

}
