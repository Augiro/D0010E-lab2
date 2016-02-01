
package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,200,200);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
		
			
			addKeyListener(new Listener());
			
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(Room room : lv.rooms) {
				g.setColor(room.floorColor);
				g.fillRect(room.x, room.y, room.length, room.height);
				if(room == lv.currentLocation) {
					g.setColor(Color.MAGENTA);
				}
				else {
					g.setColor(Color.black);
				}
				g.drawRect(room.x, room.y, room.length, room.height);
				arrowDrawer(room,g);
			}
		}
		private void arrowDrawer(Room r, Graphics g) {
			if(r.northRoom != null) {
				drawArrow(g,(r.x+r.length/2),r.length,(r.x+r.height/2),r.height);
			}
		}
		private void drawArrow(Graphics g, int x1, int x2, int y1, int y2){
			g.setColor(Color.CYAN);
			g.drawLine(x1,x2,y1,y2);
		}

	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
	
}
