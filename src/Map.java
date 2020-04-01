
public class Map {
	private State[][] state;
	private int[] roadx, roady;
	private static int width = 80;
	private static int height = 80;
	private State[][] land;
	private Position mySnakeHeadPos;
	private Position[] mySnakeBodyPos;
	private Position yourSnakeHeadPos;
	private Position[] yourSnakeBodyPos;
	private static int k;
	private int i, j, l;
	/************************* plus1 ***********************/
	private foodManeger maneger;
	private static Map map;
	private static int pix = 10;
	private static gameArea area;
	private static boolean single = false;

	public static void setSingle(boolean s) {
		single = s;
	}

	public static boolean isSingle() {
		return single;
	}

	public static gameArea getArea() {
		return area;
	}

	public static Map getMap() {
		return map;
	}

	public static Map setMap(int no, gameArea area, boolean sflag, int foodNum) {
		k = no;
		map = new Map(k);
		single = sflag;
		map.pix = 10;
		width = height = 80;
		map.area = area;
		map.setManeger(foodNum);
		return map;
	}

	private void setManeger(int num) {
		this.maneger = new foodManeger(num);
	}

	public foodManeger getManeger() {
		return maneger;
	}

	public static int getPix() {
		return pix;
	}

	/************************* plus2 ***********************/
	public void setMySnake(Direction d, int... p) {
		mySnakeHeadPos = new Position(p[0], p[1], d);
		mySnakeBodyPos = new Position[p.length / 2 - 1];
		state[p[0]][p[1]] = State.my_snake_head;
		for (int i = 2; i < p.length; i += 2) {
			mySnakeBodyPos[i / 2 - 1] = new Position(p[i], p[i + 1], d);
			state[p[i]][p[i + 1]] = State.my_snake_body;
		}

	}

	public void setYourSnake(Direction d, int... p) {
		yourSnakeHeadPos = new Position(p[0], p[1], d);
		yourSnakeBodyPos = new Position[p.length / 2 - 1];
		state[p[0]][p[1]] = State.your_snake_head;
		for (int i = 2; i < p.length; i += 2) {
			yourSnakeBodyPos[i / 2 - 1] = new Position(p[i], p[i + 1], d);
			state[p[i]][p[i + 1]] = State.your_snake_body;
		}
	}

	/************************ plus3 ************************/

	public Position getMySnakeHeadPos() {
		return mySnakeHeadPos;
	}

	public Position[] getMySnakeBodyPos() {
		return mySnakeBodyPos;
	}

	public Position getYourSnakeHeadPos() {
		return yourSnakeHeadPos;
	}

	public Position[] getYourSnakeBodyPos() {
		return yourSnakeBodyPos;
	}

	public static int getMapNum() {
		return k;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public State getState(int x, int y) {
		return state[x][y];
	}

	public State getLand(int x, int y) {
		return land[x][y];
	}

	public void changeState(int x, int y, State s) {
		state[x][y] = s;
	}

	public void resetState(int x, int y) {
		state[x][y] = land[x][y];
	}

	/************************ plus *************************/
	public Map(int k) {
		int i, j;
		state = new State[height][width];
		land = new State[height][width];

		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				if (i == 0 || j == 0 || i == height - 1 || j == width - 1)
					land[i][j] = State.wall;
				else
					land[i][j] = State.road;
			}
		}

		// 十种地图
		if (k == 1) {
			setMySnake(Direction.left, 8, 72, 8, 73, 8, 74);
			setYourSnake(Direction.right, 8, 8, 8, 7, 8, 6);
		} // 只有四周的墙

		if (k == 2) {
			setMySnake(Direction.left, 8, 72, 8, 73, 8, 74);
			setYourSnake(Direction.right, 8, 8, 8, 7, 8, 6);
			for (i = 20; i < 60; i++) {
				for (j = 20; j < 60; j++) {
					land[i][j] = State.wall;
				}
			}
		}

		if (k == 3) {
			setMySnake(Direction.left, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.right, 40, 20, 20, 19, 20, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 10; i < 45; i++) {
				for (j = 5; j < 50; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 35; i < 70; i++) {
				for (j = 30; j < 75; j++) {
					land[i][j] = State.road;
				}
			}
		}

		if (k == 4) {
			setMySnake(Direction.left, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.right, 40, 20, 20, 19, 20, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 6; i < 70; i++) {
				for (j = 30; j < 50; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 30; i < 50; i++) {
				for (j = 6; j < 74; j++) {
					land[i][j] = State.road;
				}
			}
		}
		if (k == 5) {
			setMySnake(Direction.left, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.right, 40, 20, 20, 19, 20, 18);
			for (i = 10; i < 35; i++) {
				for (j = 10; j < 35; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 45; i < 65; i++) {
				for (j = 10; j < 35; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 10; i < 35; i++) {
				for (j = 45; j < 65; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 45; i < 65; i++) {
				for (j = 45; j < 65; j++) {
					land[i][j] = State.wall;
				}
			}
		}

		if (k == 6) {
			setMySnake(Direction.left, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.right, 40, 20, 20, 19, 20, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 10; i < 20; i++) {
				for (j = 20; j < 60; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 60; i < 70; i++) {
				for (j = 20; j < 60; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 30; i < 50; i++) {
				for (j = 15; j < 65; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 15; i < 65; i++) {
				for (j = 15; j < 30; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 15; i < 65; i++) {
				for (j = 50; j < 65; j++) {
					land[i][j] = State.road;
				}
			}

		}

		if (k == 7) {
			setMySnake(Direction.left, 50, 60, 50, 61, 50, 62);
			setYourSnake(Direction.right, 50, 20, 50, 19, 50, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					if (i >= 7 && i <= 15 && j >= 10 && j <= 70)
						land[i][j] = State.road;
					if (i >= 27 && i <= 35 && j >= 10 && j <= 70)
						land[i][j] = State.road;
					if (i >= 47 && i <= 55 && j >= 10 && j <= 70)
						land[i][j] = State.road;
					if (i >= 67 && i <= 75 && j >= 10 && j <= 70)
						land[i][j] = State.road;
				}
			}
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					if (j >= 60 && j <= 70 && i >= 15 && i <= 27)
						land[i][j] = State.road;
					if (j >= 60 && j <= 70 && i >= 55 && i <= 67)
						land[i][j] = State.road;
				}
			}
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					if (j >= 10 && j <= 20 && i >= 35 && i <= 47)
						land[i][j] = State.road;

				}
			}

		}

		if (k == 8) {
			setMySnake(Direction.left, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.right, 40, 20, 20, 19, 20, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 5; i < 20; i++) {
				for (j = 45 - i; j <= 35 + i; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 15; i < 30; i++) {
				for (j = 70 - 2 * i; j <= 10 + 2 * i; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 25; i < 40; i++) {
				for (j = 90 - 2 * i; j <= -10 + 2 * i; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 40; i < 60; i++) {
				for (j = 15; j <= 65; j++) {
					land[i][j] = State.road;
				}
			}
		}

		if (k == 9) {
			setMySnake(Direction.up, 40, 60, 40, 61, 40, 62);
			setYourSnake(Direction.down, 40, 20, 20, 19, 20, 18);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					if ((Math.abs(i - 40) * Math.abs(i - 40) + Math.abs(j - 40) * Math.abs(j - 40)) <= 900)
						land[i][j] = State.road;

				}
			}
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					if ((Math.abs(i - 40) * Math.abs(i - 40) + Math.abs(j - 40) * Math.abs(j - 40)) <= 225)
						land[i][j] = State.wall;

				}
			}

		}
		if (k == 10) {
			setMySnake(Direction.left, 65, 60, 65, 61, 65, 62);
			setYourSnake(Direction.right, 10, 17, 10, 16, 10, 15);
			for (i = 0; i < 80; i++) {
				for (j = 0; j < 80; j++) {
					land[i][j] = State.wall;
				}
			}
			for (i = 5; i < 15; i++) {
				for (j = 10; j < 70; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 60; i < 70; i++) {
				for (j = 10; j < 70; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 10; i < 70; i++) {
				for (j = 5; j < 15; j++) {
					land[i][j] = State.road;
				}
			}
			for (i = 10; i < 70; i++) {
				for (j = 60; j < 70; j++) {
					land[i][j] = State.road;
				}
			}

			for (i = 5; i < 65; i++) {
				for (j = 5; j < 65; j++) {
					if (Math.abs(i - j) <= 6 || Math.abs(i + j - 79) <= 6)
						land[i][j] = State.road;
				}
			}

		}

		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				state[i][j] = land[i][j];
			}
		}
	}

	public Position randomFood() {
		l = 0;
		roadx = new int[6400];
		roady = new int[6400];
		for (i = 0; i < 80; i++) {
			for (j = 0; j < 80; j++) {
				if (state[i][j] == State.road) {
					roadx[l] = i;
					roady[l] = j;
					l++;
				}
			}
		}
		if (l == 0)
			return null;
		i = (int) (Math.random() * l);
		state[roadx[i]][roady[i]] = State.food;
		return new Position(roadx[i], roady[i], Direction.up);

	}// 随机位置产生食物
}
