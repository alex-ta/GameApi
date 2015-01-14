package obs;
import java.awt.Image;
import java.awt.Point;

public abstract class Monster extends LifeObject{
	/**
	 * Alex's
	 *-No Solution not finished-
	 *object that is visible and can interact z.b. fight
	 *
	 */

	private boolean fighting;
	private Point move;
	
	public Monster(int x, int y, Image i) {
		super(x, y, i);
		fighting = true;
		move = new Point(0,0);
	}

	@Override
	public boolean isFighting() {
		return fighting;
	}

	@Override
	public Point getMovement() {
		return move;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void addMovement(Point p) {
		for(LifeObject obj: intOb){
			if(obj.getPos().equals(p))
				this.interakt(obj);
			return;
		}
		move.setLocation(move.x+p.x,move.y+p.y);
	}


	@Override
	public abstract void interakt(LifeObject obj);
	
}
