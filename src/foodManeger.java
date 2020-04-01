import java.util.Vector;

public class foodManeger {
	private Map map;
	private int foodNum;
	private Vector<autoFood> list;
	private static boolean swing=true;
	public foodManeger(int num) {
		map=Map.getMap();
		foodNum=num;
		list=new Vector(foodNum);
		for(int i=0;i<foodNum;i++)
		{
			list.addElement(new autoFood(map.randomFood()));
		}
	}
	public static void setSwing(boolean b) {
		swing=b;
	}
	public static boolean getSwing() {
		return swing;
	}
	public int getFoodNum(){
		return foodNum;
	}
	public void setFoodNum(int n) {
		foodNum=n;
	}
	public void newFood(Position pos) {
		int k=posToIndex(pos);
		if(k!=-1&&(pos=map.randomFood())!=null)
			list.elementAt(k).setPos(pos);
		else list.add(new autoFood(map.randomFood()));
	}
	public void moveAllFood() {
		// TODO Auto-generated method stub
		if(!swing)return;
		for(autoFood food:list) {
			food.move();
		}
	}
	private int posToIndex(Position pos) {
		for(int k=0;k<list.size();k++) {
			if(list.elementAt(k).getX()==pos.getX()&&list.elementAt(k).getY()==pos.getY()) {
				return k;
			}
		}
		return -1;
	}
}
