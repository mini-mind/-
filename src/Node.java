
public class Node {
	private Position pos;
	private Node next;
	public Node(Position pos)
	{
		this.pos=pos;
		next=null;
	}
	public void linkUpon(Node node) {
		node.next=this;
	}
	public void linkFollow(Node node) {
		this.next=node;
	}
	public Position getPos() {
		return pos;
	}
	public Node getNext() {
		return next;
	}
}
