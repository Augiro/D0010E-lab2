
package lab2.level;

import java.util.Observable;


public class Level extends Observable {
	private Rooms rooms = new Rooms();
	private Room startLocation;
	private Room currentLocation;

	public boolean place(Room r, int x, int y)  {
		if(overlaps(x, y) || x < 0 || y < 0) return false;
		Rooms roomNode = rooms;
		while(roomNode.nextRooms != null) {
			roomNode = roomNode.nextRooms;
		}
		rooms.nextRooms = new Rooms(r);
		return true;
	}
	
	public void firstLocation(Room r) {
			startLocation = r;
	}

	private boolean overlaps(int x, int y) {
		Rooms tempRooms = rooms;
		boolean xoverlap;
		boolean yoverlap;
		while(tempRooms.nextRooms != null) {
			xoverlap = yoverlap = false;
			if(x < tempRooms.room.x && x < (tempRooms.room.x + tempRooms.room.length-1))
				xoverlap = true;
			if(xoverlap && (y < tempRooms.room.y && y < (tempRooms.room.y + tempRooms.room.length-1)))
				yoverlap = true;
			if(xoverlap && yoverlap) return true;
			tempRooms = tempRooms.nextRooms;
		}
		return false;
	}

	private class Rooms {
		Rooms() {}
		Rooms(Room room) {
			this.room = room;
		}
		Room room;
		Rooms nextRooms = null;
	}

	// May or may not be necessary, depending on whether specific coordinates are required for the player
	/*private class Player {
		private int x;
		private int y;
		private Room currentRoom;
	}*/
}