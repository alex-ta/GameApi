package MAIN_EXAMPLE_WINDOW;

import java.awt.Color;
import GUI.Raster;
import IO.Mapper;
public class Main {
	
	public static void main (String[] args){
		
		Raster r = new Raster(500,500,10,10,Color.blue);
		Window w = new Window("Window",r);
		Mapper m = new Mapper();
		// read a map that is written
		m.readMap("firstmap.load", w);
		
		/*
		 * create a Map and write it
		w.addTile(new Position(1,0),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(1,1),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(2,2),new Tile("./res/tiles/tile.png"));
		
		w.addTile(new Position(3,3),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(4,4),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(5,5),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(6,6),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(7,7),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(8,8),new Tile("./res/tiles/tile.png"));
		w.addTile(new Position(9,9),new Tile("./res/tiles/tile.png"));
		Mapper mapper = new Mapper();
		mapper.writeMap("firstmap.load", w);
		*/
		w.renderScaled();
		w.draw();
		
		
	}
	

}
