package lawn;

public class Cell {
	private volatile boolean busy;
	private final int x;
	private final int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public synchronized void setBusy(boolean busy) {
		this.busy = busy;
	}

	public synchronized boolean isBusy() {
		return busy;
	}

	@Override
	public String toString() {
		return "Cell [busy=" + busy + ", x=" + x + ", y=" + y + "]";
	}

}
