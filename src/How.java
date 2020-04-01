import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class How extends JFrame implements ActionListener{
	private JLabel text;
	private JButton check;
	private JPanel bt;
	//构造方法
	public How(){
		init();
		setSize(350,250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("玩法说明");//设置窗体名称
		text=new JLabel();
		bt=new JPanel();
		check=new JButton("确定");
		//使用setText方法，使用html控制标签格式
		text.setText("<html><body>&nbsp;&nbsp;&nbsp;&nbsp;玩法说明：<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;为了增加可玩性，本游戏设置了十个关卡，<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;分为十个不同的地形，和单双人游戏模式，通过<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;上下左右方向键和wasd控制贪吃蛇的移动吃到食<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;物的同时，要避开坚硬的墙体。游戏记录内显示<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;单人模式下所有游戏记录中的前十名，游戏结束<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;会显示您本轮的积分。<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;友情提示：<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;吃到闪烁的食物会获得额外加分！<br>"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;吃的食物越多，贪吃蛇身体越长，不要咬到自己哦！</body></html>");
		add(text,BorderLayout.CENTER);
		check.addActionListener(this);//为“确定”按钮添加监听
		bt.add(check);
		add(bt,BorderLayout.SOUTH);
	}
	
/****************************************************************************************/
	@Override
	//“确定”按钮监听
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);//关闭当前“玩法说明”窗体
	}
	
}
