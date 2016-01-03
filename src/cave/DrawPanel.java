package cave;


import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel  {

	private CaveMap cave;

	public DrawPanel(CaveMap cave){
		this.cave = cave;
	}

	public void paint(Graphics g){
		super.paint(g);
		for (int y = 0; y < cave.getHeight(); y++) {
			for (int x = 0; x < cave.getWidth(); x++) {
				if (cave.getMap(x, y)) g.fillRect(x * 10, y * 10, 10, 10);
			}
		}
	}
}
