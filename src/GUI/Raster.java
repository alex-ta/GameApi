package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Raster {
	
		/**
		 * Alex's
		 * -*Game Libary*______*~~~~~____~~~~~~~~~~~~~_______~~~~~~~~___++++++___~~~~
		 * ~~~~~~~~~~~~##____~____~~~____~~~~~~~~~~~~____*____~~~~~~~~___~~~~___~~~~~
		 *~~~~~~~~~~~~~~~____+____~~~____~~~~~~~~~~~____***____~~~~~~~~________~~~~~~
		 * ~~~~~~~~~~~~~~_______~~~~~____~~~~~~~~~~_____________~~~~~~~~~____~~~~~~~~
		 * ~~~~~~~~~~~~~~____~~~~~~~~____~~~~~~~~~_______________~~~~~~~~____~~~~~~~~
		 * ~~~~~~~~~~~~~~____~~~~~~~~_________~~~____*********____~~~~~~~____~~~~~~~~
		 * ~~~~~~~~~~~~~~____~~~~~~~~_________~~____***********____~~~~~~____~~~~~~~~
		 *
		 *The Raster Wrapps the Frame in different Parts/Fields, each can be filled with
		 *a Image called Tile
		 */
	
	private int width,height,timesx,timesy;
	private float sizex, sizey;
	private List<Position> list;
	private Color bgcolor;
	
	public Raster (int width, int height, int timesx, int timesy, float sizex, float sizey,Color bgcolor)
	{
		
		/**
		 * width and height of the Raster
		 * Fields on the x-Axis => timesx
		 * Fileds on the y-Axis => timesy
		 * Size of a Field x => sizex
		 * Size of a Field y => sizey
		 * bgcolor = default color
		 * list => contains all possible visible Positions
		 * */
			
		this.width = width;
		this.height = height;
		this.timesx = timesx;
		this.timesy = timesy;
		this.sizex = sizex;
		this.sizey = sizey;
		this.bgcolor = bgcolor;
	
		list = new ArrayList<Position>();
		for(int x = 0; x< timesx+1; x++){
			for(int y =0; y< timesy+1; y++){
				list.add(new Position(y,x));
			}
		}
	}
	
	public Raster (int width, int height, int timesx, int timesy,Color bgcolor){
		this(width,height,timesx,timesy,width/timesx,height/timesy,bgcolor);
	}

	public int getWidth() {/**returns the Raster width*/
		return width;
	}

	public void setWidth(int width) {/**sets the Raster width*/
		this.width = width;
	}

	public int getHeight() {/**returns the Raster height*/
		return height;
	}

	public void setHeight(int height) {/**sets the Raster height*/
		this.height = height;
	}

	public int getTimesx() {/**returns the Rastercounts on x-Axis*/
		return timesx;
	}

	public void setTimesx(int timesx) {/**sets the Rastercounts on x-Axis*/
		this.timesx = timesx;
	}

	public int getTimesy() {/**returns the Rastercounts on y-Axis*/
		return timesy;
	}

	public void setTimesy(int timesy) {/**sets the Rastercounts on y-Axis*/
		this.timesy = timesy;
	}

	public float getSizex() {/**returns the size of a Field */
		return sizex;
	}

	public void setSizex(float sizex) { /**sets the size of a Field */
		this.sizex = sizex;
	}

	public float getSizey() {/**returns the size of a Field */
		return sizey;
	}

	public void setSizey(float sizey) {/**sets the size of a Field */
		this.sizey = sizey;
	}
	
	public List<Tile> getListfromMap(HashMap<Position,Tile> map){
		/**
		 * creates a ArrayList out of a HashMap with Tiles, all Tiles get 
		 * sorted into theRaster flow
		 * */
		List<Tile> l = new LinkedList<Tile>();
		for(Position p: list){
		l.add(map.get(p));
		}
		return l;
	}
	 
	public Image getImageformRaster(HashMap<Position,Tile> map){
		/**
		 * Creates a Image from a Hashmap with Tiles, first it sets the all
		 * to the Rasterflow, as ArrayList. Then all Images get set on the start
		 * of their Filedposition. The Raster gets converted to Real Coordinates.
		 * 
		 * */
		
		Image img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		int posx =0;
		int posy =0;
		
		
		for(Tile t: getListfromMap(map)){
			if(t != null){
			g.drawImage(t.getImg(), (int)(posx*sizex), (int)(posy*sizey), bgcolor, null);
			System.out.println(posx +" "+posy);
			}
			posx++;
			if(posx>timesx){
			posx =0;	
			posy++;
			}
		}
		
		return img;
	}

	public Image getImageformScaledRaster(HashMap<Position,Tile> map){
		/**
		 * Creates a Image from a Hashmap with Tiles, first it sets the all
		 * to the Rasterflow, as ArrayList. Then all Images get set on the start
		 * of their Filedposition. The Raster gets converted to Real Coordinates.
		 * all Images get scaled on the Fieldsize.
		 * */
		
		Image img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		int posx =0;
		int posy =0;
		
		
		for(Tile t: getListfromMap(map)){
			if(t != null){
			t.resize((int)sizex,(int) sizey);
			g.drawImage(t.getImg(), (int)(posx*sizex), (int)(posy*sizey), bgcolor, null);
			}
			posx++;
			if(posx>timesx){
			posx =0;	
			posy++;
			}
		}
		
		return img;
	}
}
