package theGameOfLife;

import java.util.LinkedList;

public class Cell implements Subject {
	private Integer row;
	private Integer column;
	private Integer numberAliveNeighborhood = 0;
	private CellCondition condition;
	private LinkedList<ConcretObserver> observers;

	public Cell(Integer row, Integer column, CellCondition condition, LinkedList<ConcretObserver> observers) {
		this.row = row;
		this.column = column;
		this.condition = condition;
		this.observers = observers;
	}

	public Cell(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public void addObserver(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add((ConcretObserver)observer);
		}
	}

	@Override
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		if (cellChangeCondition()) {
			for (ConcretObserver observer : observers) {
				observer.updateSubjects(this);
			}
		}
	}

	private Boolean cellChangeCondition() {
		if (condition.equals(CellCondition.ALIVE) && !(numberAliveNeighborhood.equals(Integer.valueOf(2))
				|| numberAliveNeighborhood.equals(Integer.valueOf(3)))) {
			return Boolean.TRUE;
		}
		if (condition.equals(CellCondition.NEIGHBORHOOD) && numberAliveNeighborhood.equals(Integer.valueOf(3))) {
			return Boolean.TRUE;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.row.equals(((Cell) obj).getRow()) && this.column.equals(((Cell) obj).getColumn()));
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColums(Integer column) {
		this.column = column;
	}

	public LinkedList<ConcretObserver> getObservers() {
		return observers;
	}

	public void setObservers(LinkedList<ConcretObserver> observers) {
		this.observers = observers;
	}

	public Integer getNumberOfNeighborhood() {
		return numberAliveNeighborhood;
	}

	public void setNumberOfNeighborhood(Integer numberOfNeighborhood) {
		this.numberAliveNeighborhood = numberOfNeighborhood;
	}

	public CellCondition getCondition() {
		return condition;
	}

	public void setCondition(CellCondition condition) {
		this.condition = condition;
	}
}
