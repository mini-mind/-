import java.awt.Color;

public class Snake extends List {
	protected Direction dir;
	protected Color bodyColor;
	protected Color headColor;
	private int lenth;
	private boolean state = true;
	private foodManeger maneger;
	protected int eatMusic = 0;

	public Snake(Position headPos, Position[] pos) {
		super(headPos, pos);
		lenth = pos.length + 1;
		// TODO Auto-generated constructor stub
		headColor = Color.YELLOW;
		bodyColor = Color.ORANGE;
		dir = getSnakeHead().getPos().getDir();
		maneger = Map.getMap().getManeger();
	}

	public int getLen() {
		return lenth;
	}

	public boolean getState() {
		return state;
	}

	public boolean move() {
		int x = this.getSnakeHead().getPos().getX(), y = this.getSnakeHead()
				.getPos().getY();
		switch (dir) {
		case up:
			x--;
			break;
		case down:
			x++;
			break;
		case left:
			y--;
			break;
		case right:
			y++;
			break;
		}
		Position p = new Position(x, y, dir);
		State st = map.getState(p.getX(), p.getY());
		if (moveAble(p, st)) {
			this.moveOneNode(p, st != State.food);
			return true;
		}
		return false;
	}

	private boolean moveAble(Position p, State st) {
		// TODO Auto-generated method stub
		if (st == State.road) {
			return true;
		} else if (st == State.food) {
			maneger.newFood(p);
			PlayMusic.play(PlayMusic.eat0, false);
			lenth++;
			return true;
		}
		die();
		return false;
	}

	public Color getBodyColor() {
		return bodyColor;
	}

	public Color getHeadColor() {
		return headColor;
	}

	public void die() {
		for (Node node = head; node != null; node = node.getNext()) {
			map.changeState(node.getPos().getX(), node.getPos().getY(),
					State.death);
		}
		state = false;
		PlayMusic.play(PlayMusic.over, false);
		gameArea.getArea().end();
	}
}
