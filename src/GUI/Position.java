package GUI;

public class Position {
	/**
	 * Alex's
	 * 
	 *This Class is a Wrapper for a Rasterposition
	 *
	 */
	
	public int x,y;
	
	public Position(int x, int y){
		/**defines a Position on the Raster*/
		this.x = x;
		this.y = y;
	}
	
	public Position(String pos){
		/**parses a Point String*/
		String[] vals = pos.split("[xy]:");
		this.x = Integer.parseInt(vals[1]);
		this.y = Integer.parseInt(vals[2]);
	}
	
	
	public void move(int x, int y){
		/**Moves the Postion about x,y Rasterfields*/
		this.x +=x;
		this.y +=y;
	}

	@Override
	public boolean equals(Object obj) {
		/**Checks the Equality of an Object*/
		return this.toString().equals(obj.toString());
	}

	@Override
	public int hashCode() {
		/**Creates a Hash of a Object out of its String*/
		return toString().hashCode();
	}

	@Override
	public String toString(){ 
		/**Creates a String that returns the Infromation about the Position*/
		return "x:"+x+"y:"+y;
	}
	
	
	
}
