package cave;

import javax.swing.*;

public class CaveGame {

	public CaveGame() {
		CaveMap cave = new CaveMap();
		JFrame frame = new JFrame("Java Game");
		DrawPanel panel = new DrawPanel(cave);
		frame.getContentPane().add(panel);
		frame.setSize(RESOLUTION, RESOLUTION);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cave.printMap();
		cave.nextPhase();
		cave.printMap();
	}

	private static final int RESOLUTION = 512;

	public static void main(String[] args) {
		new CaveGame();
	}
}


