package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;



public abstract class Gui extends JFrame{

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
	 *This GUI class is a Frame that consists out of a number of images, called Map,
	 *One Image is called Tile and ordered in the Way the Raster is set up.
	 *
	 */
	
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * width and hight are the width and hight of the Frame with border
	 * the Image img gets painted, the Image rendered is a buffer for Threading,
	 * this class is not threaded
	 * the color is the default background behind the image
	 * */
	
	private int width , height;
	private Map map;
	private Image img;
	private Image rendered;
	private Color bgcolor;

	public Gui(String title, Raster raster){
		this.setLocationRelativeTo(null);
		this.add(new Canvas());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle(title);
		Insets inset = this.getInsets();
		this.width = raster.getWidth()+ inset.right+inset.left;
		this.height = raster.getHeight()+ inset.bottom+inset.top;
		this.setSize(width, height);
		this.map = new Map(raster);
	}

	public void addTile(Position p,Tile t){
		/**Adds a Image to the Frame on a spezific Position*/
		map.add(p,t);
	}
	
	public void removeTile(Position p){
		/**Removes a Image from the Frame on a spezific Position*/
		map.remove(p);
	}
	
	public void removeTiles(){
		/**Removes all Images*/
		map.remove();
	}
	
	public Color getBgcolor() {
		/**returns backgroundcolor*/
		return bgcolor;
	}
	
	public void setBgcolor(Color bgcolor) {
		/**sets backgroundcolor*/
		this.bgcolor = bgcolor;
	}
	
	public void render(){
		/**sets the map to the rendered Image */
		rendered = map.render();
	}
	
	public void renderScaled(){
		/**sets the map to the rendered Image, small Tiles get scaled */
		rendered = map.renderScaled();
	}
	
	public void draw(){
		/**sets the img to the created Image rendered and repaints the JPanel*/
		img = rendered;
		this.repaint();
	}
	private class Canvas extends JPanel{

		/**
		 * Draws the background to the Frame, without flickering
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, bgcolor, null);
		}
		
	}
	
	public Map getMap(){
		/**returns the Map to write it*/
		return map;
	}
	
}
