package GUI;
import java.awt.Image;
import java.util.HashMap;


public class Map {
	
	/**
	 * Alex's
	 * 
	 *This Map Class mapps a Picture to a spezific Position on the Frame, the Position
	 *is later defined through a Raster.
	 *
	 */
	
	private HashMap<Position,Tile> tilemap = new HashMap<Position,Tile>();
	private Raster raster;
	
	public Map(Raster raster){
		/**creates a Map and sets the Raster */
		this.raster = raster;
	}
	
	public Image render(){
		/**Renderes the Images on the Raster*/
		return raster.getImageformRaster(tilemap);
	}
	public Image renderScaled(){
		/**Renderes the scaled Images on the Raster*/
		return raster.getImageformScaledRaster(tilemap);
	}
	
	public void move(int x, int y){
		/**Moves all Images x,y Rasterfields*/
		for(Position p : tilemap.keySet()){
			p.move(x, y);
		}
	}

	public void add(Position p,Tile t) {
		/**Adds a Tile on a Position of the Raster*/
		tilemap.put(p,t);
	}

	public void remove(Position p) {
		/**Removes the Tile from a Position*/
		tilemap.remove(p);
	}

	public void remove() {
		/**Removes all Tiles*/
		tilemap.clear();
	}

	public String toString(String sepVal, String sepTil) {
		/**returns a saveable String*/
		StringBuffer buff = new StringBuffer();
		for(Position p: tilemap.keySet()){
			buff.append(tilemap.get(p)+sepVal+p+sepTil);			
		}
	
		return buff.toString();
	}

	@Override
	public String toString() {
		/**returns the Readable Map*/
		return toString(" "," \n");
	}
	
	
	
}
