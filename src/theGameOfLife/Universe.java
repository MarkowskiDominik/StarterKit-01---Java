package theGameOfLife;

import java.util.LinkedList;

public class Universe {

	private LinkedList<Cell> aliveCells;
	private LinkedList<Cell> neighborhood;

	public Universe() {
		neighborhood = new LinkedList<Cell>();
	}

	public void symulationOfCellsLife(LinkedList<Cell> aliveCells) {
		this.aliveCells = new LinkedList<Cell>(aliveCells);
		
		for (Cell cell : aliveCells) {
			addNeighborhoodOfAliveCell(cell);
			setNumberOfNeighborhood(cell);
		}
		for (Cell cell : neighborhood) {
			setNumberOfNeighborhood(cell);
		}
		
		notifyObserver();		
	}

	private void addNeighborhoodOfAliveCell(Cell cell) {
		Integer row = cell.getRow();
		Integer column = cell.getColumn();

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				Cell tmp = new Cell(row + i, column + j, CellCondition.NEIGHBORHOOD, cell.getObservers());
				if (!aliveCells.contains(tmp) && !neighborhood.contains(tmp)) {
					neighborhood.add(tmp);
				}
			}
		}
	}

	private void setNumberOfNeighborhood(Cell cell) {
		Integer numberOfNeighborhood = 0;
		Integer cellRow = cell.getRow();
		Integer cellColumn = cell.getColumn();

		for (Cell tmp : getAliveCells()) {
			Integer tmpRow = tmp.getRow();
			Integer tmpColumn = tmp.getColumn();
			if (cellRow - 2 < tmpRow && tmpRow < cellRow + 2 && cellColumn - 2 < tmpColumn && tmpColumn < cellColumn + 2
					&& !(tmpRow == cellRow && tmpColumn == cellColumn)) {
				numberOfNeighborhood++;
			}
		}
		cell.setNumberOfNeighborhood(numberOfNeighborhood);
	}
	
	public void notifyObserver() {
		for (Cell cell : aliveCells) {
			cell.notifyObserver();
		}
		for (Cell cell : neighborhood) {
			cell.notifyObserver();
		}
	}
	
	public LinkedList<Cell> getAliveCells() {
		return aliveCells;
	}

	public void setAliveCells(LinkedList<Cell> aliveCells) {
		this.aliveCells = aliveCells;
	}

	public LinkedList<Cell> getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(LinkedList<Cell> neighborhood) {
		this.neighborhood = neighborhood;
	}
}
