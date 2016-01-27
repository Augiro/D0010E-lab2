
package lab2.level;

import java.util.ArrayList;
import java.util.Observable;


public class Level extends Observable {
	private ArrayList rooms = new ArrayList();
	public boolean place(Room r, int x, int y)  {
		if(overlaps(r)) return false;
		rooms.add(r);
	}
	
	public void firstLocation(Room r) {
			
	}

	private boolean overlaps(Room r) {
		if (rooms.size() == 0) return false;
		for(int i=0; i < rooms.size(); i++) {
			if(rooms.get(i))
		}
	}
}
