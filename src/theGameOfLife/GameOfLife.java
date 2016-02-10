package theGameOfLife;

public class GameOfLife {

	private Universe universe;	

	public GameOfLife() {
		universe = new Universe();
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

}
