package obs;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

public abstract class LifeObject implements GameObject{
	/**
	 * Alex's
	 *-No Solution not finished-
	 *object that is visible in the world and can interact
	 *
	 */
	
	private boolean real = true;
	private Image pic;
	private Point pos;
	protected static LinkedList<LifeObject> intOb = new LinkedList<LifeObject>();
	
	public LifeObject(int x, int y, Image i){
		pos = new Point(x,y);
		pic = i;
		intOb.add(this);
	}
	@Override
	public Point getPos() {
		return pos;
	}
	@Override
	public abstract Point getMovement();

	@Override
	public Image getPic() {
		return pic;
	}
	@Override
	public void delete(){
		real = false;
		pic = null;
		intOb.remove(this);
	}
	@Override
	public void draw(Graphics g){
		g.drawImage(pic, pos.x, pos.y, null);
	}
	@Override
	public abstract void update();
	@Override
	public boolean isReal() {
		return real;
	}
	@Override
	public String toString(){
	return " x: "+pos.x+" y: "+pos.y+" isreal ";
	}
	public abstract void interakt(LifeObject obj);
}
