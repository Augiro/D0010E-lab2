package lab2;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

import java.awt.*;

public class Driver {

	public void run() {
		// Create 3 rooms and "connect" them together
		Room r1 = new Room(50, 50, Color.blue);
		Room r2 = new Room(50, 50, Color.red);
		Room r3 = new Room(50, 50, Color.green);
		r1.connectSouthTo(r2);
		r2.connectNorthTo(r1);
		r2.connectSouthTo(r3);
		r3.connectNorthTo(r2);
		Level l1 = new Level();
		l1.place(r1, 200, 0)
		l1.place(r2, 150, 100);
		l1.place(r3, 100, 200);
		l1.firstLocation(r1);
		LevelGUI gui = new LevelGUI(l1, "XXX pr0n g4m");
	}

}