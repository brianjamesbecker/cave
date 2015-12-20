package cave;

import java.lang.Math;

public class CaveMap {

	private static final double DENSITY = .35;
	private static final int HEIGHT = 32;
	private static final int WIDTH = 32;
	private static final int DELETE = 3;
	private static final int CREATE = 2;
	private boolean[][] map;

	public static void main(String[] args) {
		CaveMap cave = new CaveMap();
		cave.printMap();
		cave.nextPhase();
		cave.printMap();
	}

	public CaveMap() {
		map = genMap();
	}

	public boolean[][] genMap() {
		boolean[][] theMap = new boolean[WIDTH][HEIGHT];
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				theMap[x][y] = Math.random() < DENSITY;
			}
		}
		return theMap;
	}

	public void printMap() {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				if (map[x][y]) System.out.print("0");
				else System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public int neighborCount(int x, int y) {
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				int neighborX = x + i;
				int neighborY = y + j;
				// If we're looking at the middle point
				if (i == 0 && j == 0) {
					//Do nothing, we don't want to add ourselves in!
					continue;
				}
				// In case the index we're looking at it off the edge of the map
				if (neighborX < 0 || neighborY < 0 || neighborX >= map.length || neighborY >= map[0].length) {
					count = count + 1;
				}
				// Otherwise, a normal check of the neighbor
				else if (map[neighborX][neighborY]) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	public void nextPhase() {
		boolean[][] newMap = new boolean[WIDTH][HEIGHT];
		//Loop over each row and column of the map
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[0].length; y++) {
				int neibNum = neighborCount(x, y);
				//The new value is based on our simulation rules
				//First, if a cell is alive but has too few neighbors, kill it.
				if (map[x][y]) {
					newMap[x][y] = neibNum >= DELETE;
				} //Otherwise, if the cell is dead now, check if it has the right number of neighbors to be 'born'
				else {
					newMap[x][y] = neibNum > CREATE;
				}
			}
		}
		map = newMap;
	}
}
