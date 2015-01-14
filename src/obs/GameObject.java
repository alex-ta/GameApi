package obs;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;



public interface GameObject {
	/**
	 * Alex's
	 * 
	 *Highlevel Gameobject interface
	 *-No Solution not finished-
	 *
	 */
	public Point getPos();
	public Point getMovement();
	public Image getPic();
	public void delete();
	public void draw(Graphics g);
	public void update();
	public boolean isReal();
	public boolean isFighting();
	public void addMovement(Point p);
}
