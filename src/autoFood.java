
public class autoFood {
	private Position pos;
	private Position []movable=new Position[4];
	private int len;
	public autoFood(Position pos) {
		this.pos=pos;
	}
	public void move() {
		int x,y;
		x=pos.getX();
		y=pos.getY();
		len=0;
		if(Map.getMap().getState(x, y+1)==State.road) {
			movable[len++]=new Position(x,y+1,Direction.right);
		}
		if(Map.getMap().getState(x-1, y)==State.road) {
			movable[len++]=new Position(x-1,y,Direction.up);
		}
		if(Map.getMap().getState(x, y-1)==State.road) {
			movable[len++]=new Position(x,y-1,Direction.left);
		}
		if(Map.getMap().getState(x+1, y)==State.road) {
			movable[len++]=new Position(x+1,y,Direction.down);
		}
		if(len==0) {
			return;
		}else {
			double k=Math.random();
			int i=(int) Math.floor(Math.random()*len);
			if(k<0.5) return;
			else if(k<0.7){
				switch(pos.getDir()) {
				case right:i=0;break;
				case up:i=1;break;
				case left:i=2;break;
				case down:i=3;break;
				}
			}
			if(i>=len)
				i = (int) Math.floor(Math.random()*len);
			Map.getMap().resetState(pos.getX(), pos.getY());
			Map.getMap().changeState(movable[i].getX(), movable[i].getY(), State.food);
			pos=movable[i];
		}
	}
	public int getX() {
		// TODO Auto-generated method stub
		return pos.getX();
	}
	public int getY() {
		// TODO Auto-generated method stub
		return pos.getY();
	}
	public void setPos(Position randomFood) {
		// TODO Auto-generated method stub
		pos=randomFood;
	}
}
