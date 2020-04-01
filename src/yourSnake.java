import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class yourSnake extends Snake implements KeyListener{

	private boolean speedState=false;
	public yourSnake(Position headPos, Position[] pos) {
		super(headPos, pos);
		// TODO Auto-generated constructor stub
		super.bodyColor=Color.GREEN;
		super.headColor=Color.CYAN;
		super.snake_body=State.your_snake_body;
		super.snake_head=State.your_snake_head;
		eatMusic=2;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Direction d=this.getSnakeHead().getPos().getDir();
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_W:
			if(d==Direction.down)
				break;
			else if(d==Direction.up)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.up;
			break;
		case KeyEvent.VK_S:
			if(d==Direction.up)
				break;
			else if(d==Direction.down)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.down;
			break;
		case KeyEvent.VK_A:
			if(d==Direction.right)
				break;
			else if(d==Direction.left)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.left;
			break;
		case KeyEvent.VK_D:
			if(d==Direction.left)
				break;
			else if(d==Direction.right)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.right;
			break;
		}
	}

	public boolean getSpeedState() {
		// TODO Auto-generated method stub
		return speedState;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Direction d=this.getSnakeHead().getPos().getDir();
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_W:
			if(d==Direction.up)
				speedState=false;
			break;
		case KeyEvent.VK_S:
			if(d==Direction.down)
				speedState=false;
			break;
		case KeyEvent.VK_A:
			if(d==Direction.left)
				speedState=false;
			break;
		case KeyEvent.VK_D:
			if(d==Direction.right)
				speedState=false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


}
