
public class List {
	protected Node head;
	protected Node tail;
	protected Map map;
	protected State snake_body;
	protected State snake_head;

	public List(Position headPos, Position... pos) {
		map = Map.getMap();
		tail = new Node(headPos);
		head = tail;
		Node pre;
		for (Position p : pos) {
			pre = new Node(p);
			pre.linkFollow(head);
			head = pre;
		}
	}

	public void moveOneNode(Position p, boolean dic) {
		if (dic)
			delSnakeTail();
		map.changeState(tail.getPos().getX(), tail.getPos().getY(), snake_body);
		Node cur = new Node(p);
		tail.linkFollow(cur);
		tail = cur;
		map.changeState(tail.getPos().getX(), tail.getPos().getY(), snake_head);
	}

	public void delSnakeTail() {
		map.resetState(head.getPos().getX(), head.getPos().getY());
		head = head.getNext();
	}

	public Node getSnakeHead() {
		return tail;
	}

	public Node getSnakeTail() {
		return head;
	}
}
