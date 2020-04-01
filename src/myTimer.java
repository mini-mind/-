import java.util.Timer;
import java.util.TimerTask;

public class myTimer extends TimerTask {

	private gameArea painter;
	private yourSnake yours;
	private mySnake mine;
	private boolean single;
	private boolean myTurn = true;
	private boolean yourTurn = false;
	private int gap;
	private Timer timer;
	private foodManeger maneger;

	public myTimer(gameArea p, Timer t) {
		painter = p;
		mine = p.getMySnake();
		yours = p.getYourSnake();
		gap = p.getSpeed();
		single = Map.isSingle();
		maneger = Map.getMap().getManeger();
		timer = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (painter.getState() == gameState.stop)
			try {
				Thread.sleep(gap);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (myTurn || mine.getSpeedState()) {
			mine.move();
		}
		myTurn = !myTurn;
		if (!single) {
			if (yourTurn || yours.getSpeedState()) {
				yours.move();
			}
			yourTurn = !yourTurn;
		}
		maneger.moveAllFood();
		painter.repaint();
		try {
			Thread.sleep(gap);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
