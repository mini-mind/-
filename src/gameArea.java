import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gameArea extends JPanel {
	private int gap;
	private Map map;
	public gameState st;
	private int width, height;
	private mySnake mine;
	private yourSnake yours;
	private Timer timer;
	private myTimer runTimer;
	private static gameArea area;

	public gameArea() {
		init();
		area = this;
	}

	public void setState(gameState st) {
		this.st = st;
	}

	public static gameArea getArea() {
		return area;
	}

	public void end() {
		PlayMusic.stop(PlayMusic.back);
		try {
			timer.cancel();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		repaint();
		if (mine != null
				&& (mine.getState() == false || yours != null
						&& yours.getState() == false)) {
			int food = map.getManeger().getFoodNum()
					/ (map.getManeger().getSwing() ? 2 : 1);
			int score = (mine.getLen() - 3)
					* ((100 - gap) / (food * food + 1) + (100 - gap)
							/ (food + 1));
			if (st != gameState.end){
				JOptionPane.showMessageDialog(mainWin.getWin(),
						Map.isSingle() ? "本局得分：" + score : "红方长度："
								+ mine.getLen() + '\n' + "绿方长度：" + yours.getLen()
								+ '\n' + "胜方：" + (mine.getState() ? "红方" : "绿方"),
						"本局结束", JOptionPane.PLAIN_MESSAGE);
			}
			if (Map.isSingle()) {
				JavaFile fil = new JavaFile();
				fil.jiafen(score);
				fil.paixu();
			}
	}
		setState(gameState.end);
		this.setVisible(false);
		FirstWin.getAnniu().setVisible(true);
	}

	public void start() {
		setState(gameState.working);
		PlayMusic.play(PlayMusic.back, true);
		map = Map.getMap();
		mine = new mySnake(map.getMySnakeHeadPos(), map.getMySnakeBodyPos());
		FirstWin.getWin().addKeyListener(getMySnake());
		if (!(map.isSingle())) {
			yours = new yourSnake(map.getYourSnakeHeadPos(), map
					.getYourSnakeBodyPos());
			FirstWin.getWin().addKeyListener(getYourSnake());
		}
		timer = new Timer();
		timer.scheduleAtFixedRate(runTimer = new myTimer(this, timer), 0, 1);
	}

	public void init() {
		width = Map.getWidth();
		height = Map.getWidth();
		gap = 20;
		this.setSize(width * Map.getPix(), height * Map.getPix());
	}

	public gameState getState() {
		return st;
	}

	public mySnake getMySnake() {
		return mine;
	}

	public yourSnake getYourSnake() {
		return yours;
	}

	public int getWidth() {
		return width * Map.getPix();
	}

	public int getHeight() {
		return height * Map.getPix();
	}

	public void setSpeed(int speed) {
		this.gap = speed;
	}

	public int getSpeed() {
		return gap;
	}

	public void paint(Graphics g) {
		int i, j;
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				switch (map.getState(i, j)) {
				case food:
					g.setColor(Color.GRAY);
					g.fillRect(j * map.getPix(), i * map.getPix(),
							map.getPix(), map.getPix());
					g.setColor(Color.WHITE);
					g.fillOval(j * map.getPix(), i * map.getPix(),
							map.getPix(), map.getPix());
					continue;
				case wall:
					g.setColor(Color.LIGHT_GRAY);
					break;
				case my_snake_head:
					g.setColor(mine.getHeadColor());
					break;
				case your_snake_head:
					g.setColor(yours.getHeadColor());
					break;
				case my_snake_body:
					g.setColor(mine.getBodyColor());
					break;
				case your_snake_body:
					g.setColor(yours.getBodyColor());
					break;
				case death:
					g.setColor(Color.BLACK);
					g.fillOval(j * map.getPix(), i * map.getPix(),
							map.getPix(), map.getPix());
					continue;
				default:
					g.setColor(Color.GRAY);
				}
				g.fillRect(j * map.getPix(), i * map.getPix(), map.getPix(),
						map.getPix());
			}
		}
	}
}
