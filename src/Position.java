
public class Position extends Point {

	private Direction dir;
	public Position(int x, int y, Direction dir) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.dir=dir;
	}
	public Direction getDir() {
		return dir;
	}
}
