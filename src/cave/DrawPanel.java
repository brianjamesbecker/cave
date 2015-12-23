package cave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel implements ActionListener{
	private CaveMap cave;
	public DrawPanel(CaveMap cave){
		this.cave = cave;
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int y=0;y<32;y++){
			for(int x=0;x<32;x++){
				if(cave.getMap(x, y)) g.fillRect(x*10, y*10, 10, 10);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
