import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mySnake extends Snake implements KeyListener {

	private boolean speedState=false;
	public mySnake(Position headPos, Position[] pos) {
		super(headPos, pos);
		// TODO Auto-generated constructor stub
		super.bodyColor=Color.RED;
		super.headColor=Color.PINK;
		super.snake_body=State.my_snake_body;
		super.snake_head=State.my_snake_head;
		eatMusic=1;
	}

	public boolean getSpeedState() {
		return speedState;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Direction d=this.getSnakeHead().getPos().getDir();
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_UP:
			if(d==Direction.down)
				break;
			else if(d==Direction.up)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.up;
			break;
		case KeyEvent.VK_DOWN:
			if(d==Direction.up)
				break;
			else if(d==Direction.down)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.down;
			break;
		case KeyEvent.VK_LEFT:
			if(d==Direction.right)
				break;
			else if(d==Direction.left)
			{
				speedState=true;
				break;
			}
			super.dir=Direction.left;
			break;
		case KeyEvent.VK_RIGHT:
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

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		Direction d=this.getSnakeHead().getPos().getDir();
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_UP:
			if(d==Direction.up)
				speedState=false;
			break;
		case KeyEvent.VK_DOWN:
			if(d==Direction.down)
				speedState=false;
			break;
		case KeyEvent.VK_LEFT:
			if(d==Direction.left)
				speedState=false;
			break;
		case KeyEvent.VK_RIGHT:
			if(d==Direction.right)
				speedState=false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar()=='p') {
			if(Map.getArea().getState()==gameState.working)
				Map.getArea().setState(gameState.stop);
			else if(Map.getArea().getState()==gameState.stop)
				Map.getArea().setState(gameState.working);
		}
	}

}
