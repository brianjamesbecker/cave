package cave;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class CaveGame implements KeyListener {

	private static final int RESOLUTION = 64;
	private DrawPanel panel;
	private CaveMap cave;
	public CaveGame() {
		cave = new CaveMap(RESOLUTION, RESOLUTION);
		JFrame frame = new JFrame("Java Game");
		panel = new DrawPanel(cave);
		panel.addKeyListener(this);
		frame.getContentPane().add(panel);
		frame.setSize(RESOLUTION * 10, RESOLUTION * 10);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cave.nextPhase();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			cave.nextPhase();
			panel.repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	public static void main(String[] args) {
		new CaveGame();
	}
}


