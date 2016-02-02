
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
			
			setBackground(Color.BLACK);
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
			}
			for(Room room : lv.rooms) {
				arrowDrawer(room,g);
			}
		}
		private void arrowDrawer(Room r, Graphics g) {
			int startX;
			int startY;
			int endX;
			int endY;
			if(r.northRoom != null) {
				startX = r.x+r.length/2;
				startY = r.y;
				endX = r.northRoom.x+r.northRoom.length/2;
				endY = r.northRoom.y+r.northRoom.height/2;
				drawArrow(g,startX, endX, startY, endY);
			}

			if(r.eastRoom != null) {
				startX = r.x+r.length;
				startY = r.y+r.height/2;
				endX = r.eastRoom.x+r.eastRoom.length/2;
				endY = r.eastRoom.y+r.eastRoom.height/2;
				drawArrow(g, startX, endX, startY, endY);
			}

			if(r.southRoom != null) {
				startX = r.x+r.length/2;
				startY = r.y+r.height;
				endX = r.southRoom.x+r.southRoom.length/2;
				endY = r.southRoom.y+r.southRoom.height/2;
				drawArrow(g, startX, endX, startY, endY);
			}

			if(r.eastRoom != null) {
				startX = r.x;
				startY = r.y+r.height/2;
				endX = r.eastRoom.x+r.eastRoom.length/2;
				endY = r.eastRoom.y+r.eastRoom.height/2;
				drawArrow(g, startX, endX, startY, endY);
			}
		}
		private void drawArrow(Graphics g, int x1, int x2, int y1, int y2){
			g.setColor(Color.CYAN);
			g.drawLine(x1,y1,x2,y2);
			g.setColor(Color.yellow);
			g.fillOval(x2-3, y2-3, 6, 6);
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
