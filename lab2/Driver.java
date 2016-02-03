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
		Room r4 = new Room(100, 30, Color.orange);
		Room r5 = new Room(200, 200, Color.gray);
		r1.connectSouthTo(r2);
		r2.connectNorthTo(r1);
		r2.connectSouthTo(r3);
		r3.connectNorthTo(r2);
		r3.connectEastTo(r4);
		r4.connectEastTo(r5);
		r5.connectWestTo(r1);
		Level l1 = new Level();
		l1.place(r1, 200, 10);
		l1.place(r2, 150, 110);
		l1.place(r3, 100, 210);
		l1.place(r4, 160, 170);
		l1.place(r5, 350, 40);
		l1.firstLocation(r1);
		LevelGUI gui = new LevelGUI(l1, "Portalis \"Skyrim with portals, 10/10 - IGN\"");
	}

}