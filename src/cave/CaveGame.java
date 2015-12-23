package cave;

import javax.swing.JFrame;

public class CaveGame {
	private static final int RESOLUTION = 512;
	public static void main(String[] args) {
		CaveMap cave = new CaveMap();
		JFrame frame = new JFrame("Java Game");
		DrawPanel panel = new DrawPanel(cave);
		frame.getContentPane().add(panel);
		frame.setSize(RESOLUTION, RESOLUTION);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cave.printMap();
		cave.nextPhase();
		cave.printMap();
	}
}


