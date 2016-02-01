
package lab2.level;

import java.util.Observable;
import java.util.Vector;


public class Level extends Observable {
	//private Rooms rooms = new Rooms();
	Room startLocation;
	Room currentLocation;
	Vector<Room> rooms = new Vector<Room>();

	public boolean place(Room r, int x, int y)  {
		if(overlaps(x, y, x+r.length, y+r.height)) return false;
		r.x = x;
		r.y = y;
		rooms.addElement(r);
		return true;
	}
	
	public void firstLocation(Room r) {
			startLocation = r;
	}

	private boolean overlaps(int rectBX1, int rectBY1, int rectBX2, int rectBY2) {
		for(Room curRoom : rooms) {
			int rectAX1 = curRoom.x;
			int rectAX2 = curRoom.x+curRoom.length;
			int rectAY1 = curRoom.y;
			int rectAY2 = curRoom.y + curRoom.height;
			if(rectAX1 < rectBX2 && rectAX2 > rectBX1 &&
					rectAY1 < rectBY2 && rectAY2 > rectBY1) {
				return true;
			}
		}
		return false;
	}

	/*private class Rooms {
		Rooms() {}
		Rooms(Room room) {
			this.room = room;
		}
		Room room;
		Rooms nextRoom = null;
	}*/
}