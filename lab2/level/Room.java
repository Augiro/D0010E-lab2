
package lab2.level;

import java.awt.Color;


public class Room { 
	Room northRoom, westRoom, southRoom, eastRoom = null;	// Not private because the assignment says so
	Color floorColor;
	int height, length;
	int x, y;


	public Room(int dx, int dy, Color color) {
		length = dx;
		height = dy;
		floorColor = color;
	}

	public void connectNorthTo(Room r) { northRoom = r;	}
	public void connectEastTo(Room r) {
		eastRoom = r;
	}
	public void connectSouthTo(Room r) {
		southRoom = r;
	}
	public void connectWestTo(Room r) { westRoom = r; }
}
