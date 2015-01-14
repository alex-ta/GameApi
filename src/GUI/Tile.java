package GUI;
import java.awt.Image;


public class Tile {
	/**
	 * Alex's
	 * 
	 * This class Represents a Picture that is drawn to a Filed.
	 * It has a Id, which is not used yet.
	 * Width and Height are the Image size.
	 * img is the Image. 
	 */
	
	private static int id = 0;
	private String path;
	private int width,height,tileid;
	private Image img;
	

	private Tile(Image img){
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		tileid = id++;
		
	}
	
	public Tile(String path){
		/**Loads an Image from a Path and creates the Tile*/
		this(Loader.loadImage(path));
		this.path = path;
	}
	public int getId(){
		/**Returnes the Tile Id*/
		return tileid;
	}

	public Image getImg() {
		/**Returns the Iamge*/
		return img;
	}
	
	public int getWidth() {
		/**Returns the Width*/
		return width;
	}

	public int getHeight() {
		/**Returns the Height*/
		return height;
	}

	public void setImg(Image img) {
		/**changes the Image of a Tile*/
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public void resize (int width, int height){
		/**Scales a Tile*/
		this.width = width;
		this.height = height;
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	@Override
	public String toString() {
		return path;
	}
}