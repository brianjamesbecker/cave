package cave;

import java.lang.Math;

public class CaveMap {

	public static final double DENSITY = .35;
	public static final int HEIGHT = 32;
	public static final int WIDTH = 32;
	public static final int DELETE = 3;
	public static final int CREATE = 2;
	public static final boolean[][] map = new boolean[WIDTH][HEIGHT];

	public static void main(String[] args) {
		CaveMap cave = new CaveMap();
		cave.genMap();
		cave.printMap(map);
		cave.printMap(cave.nextPhase(map));
	}

	public void genMap() {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				map[x][y] = Math.random() < DENSITY;
			}
		}
	}

	public void printMap(boolean[][] inputMap) {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				if (inputMap[x][y]) System.out.print("0");
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
				//If we're looking at the middle point
				if (i == 0 && j == 0) {
					//Do nothing, we don't want to add ourselves in!
				}
				//In case the index we're looking at it off the edge of the map
				else if (neighborX < 0 || neighborY < 0 || neighborX >= map.length || neighborY >= map[0].length) {
					count = count + 1;
				}
				//Otherwise, a normal check of the neighbor
				else if (map[neighborX][neighborY]) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	public boolean[][] nextPhase(boolean[][] inputMap) {
		boolean[][] newMap = new boolean[WIDTH][HEIGHT];
		//Loop over each row and column of the map
		for (int x = 0; x < inputMap.length; x++) {
			for (int y = 0; y < inputMap[0].length; y++) {
				int neibNum = neighborCount(x, y);
				//The new value is based on our simulation rules
				//First, if a cell is alive but has too few neighbors, kill it.
				if (inputMap[x][y]) {
					newMap[x][y] = neibNum >= DELETE;
				} //Otherwise, if the cell is dead now, check if it has the right number of neighbors to be 'born'
				else {
					newMap[x][y] = neibNum > CREATE;
				}
			}
		}
		return newMap;
	}
}
