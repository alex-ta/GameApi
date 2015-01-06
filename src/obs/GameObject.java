package obs;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;



public interface GameObject {
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
	 *Highlevel Gameobject interface
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
