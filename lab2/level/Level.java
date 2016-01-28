
package lab2.level;

import java.util.ArrayList;
import java.util.Observable;


public class Level extends Observable {
	private ArrayList rooms = new ArrayList();
	private Room startLocation;

	public boolean place(Room r, int x, int y)  {
		if(overlaps(r, x, y)) return false;
		rooms.add(new RoomLocation(r, x, y));
	}
	
	public void firstLocation(Room r) {
			startLocation = r;,
	}

	private boolean overlaps(Room r, int x, int y) {
		return false; // WIP
		if (rooms.size() == 0) return false;
		for(int i=0; i < rooms.size(); i++) {
			if(y + r.height )
		}
	}
}

class RoomLocation {
	private Room room;
	private int xcord;
	private int ycord;

	RoomLocation(Room room, int x, int y) {
		this.room = room;
		xcord = x;
		ycord = y;
	}

	public Room room() {
		return room;
	}

	public int xcord() {
		return xcord;
	}

	public int ycord() {
		return ycord;
	}
}