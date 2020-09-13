package mower;

import java.util.List;

import lawn.Grid;
import orientations.News;

public class Mower implements Runnable {
	private int x;
	private int y;
	private News o;
	private final Grid grid;
	private final List<Commands> commands;

	public Mower(int x, int y, News o, List<Commands> commands, Grid grid) {
		this.x = x;
		this.y = y;
		this.o = o;
		this.commands = commands;
		this.grid = grid;
	}

	private void turnLeft() {
		o = o.leftOrientation();
	}

	private void turnRight() {
		o = o.rightOrientation();
	}

	private void moveForward() {
		int futureX = x;
		int futureY = y;
		switch (o) {
		case NORTH:
			futureY++;
			break;
		case EAST:
			futureX++;
			break;
		case SOUTH:
			futureY--;
			break;
		case WEST:
			futureX--;
			break;
		}
		if (isNextCellExists(futureX, futureY) && !isNextCellBusy(futureX, futureY)) {
			synchronized (grid.getField()) {
				freeCell(x, y);
				occupieCell(futureX, futureY);
				x = futureX;
				y = futureY;	
			}
		}
	}
	
	private boolean isNextCellBusy(int x, int y) {
		return grid.getField()[x][y].isBusy();
	}
	
	private boolean isNextCellExists(int x, int y) {
		return x >= 0 && x < grid.getBorderX() 
				&& y >= 0 && y < grid.getBorderY();
	}
	
	private void occupieCell(int x, int y) {
		grid.getField()[x][y].setBusy(true);
	}
	
	private void freeCell(int x, int y) {
		grid.getField()[x][y].setBusy(false);
	}
	
	@Override
	public void run() {
		for (Commands command : commands) {
			switch (command) {
			case MOVE_FORWARD:
				moveForward();
				break;
			case TURN_RIGHT:
				turnRight();
				break;
			case TURN_LEFT:
				turnLeft();
				break;
			}
		}
		System.out.println(x + " " + y + " " + o);
	}

}
