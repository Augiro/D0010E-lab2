
package lab2.level;

import java.util.Observable;
import java.util.Vector;


public class Level extends Observable {
	//private Rooms rooms = new Rooms();
	private Room startLocation;
	private Room currentLocation;
	private Vector<Room> rooms = new Vector<Room>();

	public boolean place(Room r, int x, int y)  {
		if(overlaps(x, y) || x < 0 || y < 0) return false;
		rooms.addElement(r);
		return true;
	}
	
	public void firstLocation(Room r) {
			startLocation = r;
	}

	private boolean overlaps(int x1, int y1, int x2, int y2) {
		boolean xoverlap;
		boolean yoverlap;

		for(Room curRoom : rooms) {
			if(curRoom.x < x1 && x1 < ())
		}
		return false;

		/*while(tempRooms.nextRoom != null) {
			System.out.println(tempRooms.nextRoom == null);
			xoverlap = yoverlap = false;
			if(x < tempRooms.room.x && x < (tempRooms.room.x + tempRooms.room.length-1))
				xoverlap = true;
			if(xoverlap && (y < tempRooms.room.y && y < (tempRooms.room.y + tempRooms.room.length-1)))
				yoverlap = true;
			if(xoverlap && yoverlap) return true;
			tempRooms = tempRooms.nextRoom;
		}*/
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