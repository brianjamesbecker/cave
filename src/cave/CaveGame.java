package cave;

import javax.swing.*;

public class CaveGame {

	private static final int RESOLUTION = 64;

	public CaveGame() {
		CaveMap cave = new CaveMap(RESOLUTION, RESOLUTION);
		JFrame frame = new JFrame("Java Game");
		DrawPanel panel = new DrawPanel(cave);
		frame.getContentPane().add(panel);
		frame.setSize(RESOLUTION * 10, RESOLUTION * 10);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cave.printMap();
		cave.nextPhase();
		cave.printMap();
	}

	public static void main(String[] args) {
		new CaveGame();
	}
}


