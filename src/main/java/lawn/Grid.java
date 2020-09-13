package lawn;

import java.util.Arrays;

public class Grid {
	private final Cell[][] field;
	private final int borderX;
	private final int borderY;

	public Grid(int borderX, int borderY) {
		this.borderX = borderX;
		this.borderY = borderY;
		this.field = new Cell[borderX][borderY];
		drawGrid();
	}

	private void drawGrid() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				int x = j;
				int y = borderY - i - 1;
				field[i][j] = new Cell(x, y);
			}
		}
		for (int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
		}
	}

	public Cell[][] getField() {
		return field;
	}
	
	public int getBorderX() {
		return borderX;
	}
	
	public int getBorderY() {
		return borderY;
	}

	@Override
	public String toString() {
		return "Grid [field=" + Arrays.toString(field) + "]";
	}

}
