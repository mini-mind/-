import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FirstWin extends JPanel implements ActionListener{
	private static gameArea area;
	private JButton one,two,setting,how,about,order;
	private JComboBox map;
	private actionListener listener;
	private static FirstWin firstWin;
	private Box mapPanel;
	private int index;
	private JLabel gameName;
	private static JPanel anniu;
	int m=5,p;
	private void init(WindowMenu a) {
		//在游戏初始化面板内建立游戏区域
		area=new gameArea();
		//使用GridLayout布局建立放置所有按钮的面板
		anniu=new JPanel(new GridLayout(8, 1, 50, 30));
		a.add(area);
		area.setVisible(false);
		one=new JButton("单人模式");
		two=new JButton("双人模式");
		setting=new JButton("游戏设置");
		order=new JButton("游戏记录");
		how=new JButton("帮助");
		about=new JButton("关于");
		map=new JComboBox();
		//为下拉列表添加列表内的内容
		map.addItem("一");
		map.addItem("二");
		map.addItem("三");
		map.addItem("四");
		map.addItem("五");
		map.addItem("六");
		map.addItem("七");
		map.addItem("八");
		map.addItem("九");
		map.addItem("十");
		//将存放下拉列表的面板设置为行型盒式布局，使添加的标签与下拉列表同在一行
		mapPanel=Box.createHorizontalBox();
		mapPanel.add(new JLabel("选择地图："));
		mapPanel.add(map);
		map.addActionListener(this);//为下拉列表添加监听
		listener = new actionListener(a);
		one.addActionListener(listener);//为“单人模式”按钮添加监听
		two.addActionListener(listener);//为“双人模式”按钮添加监听
		setting.addActionListener(this);//为“游戏设置”按钮添加监听
		order.addActionListener(this);//为“游戏记录”按钮添加监听
		how.addActionListener(this);//为“帮助”按钮添加监听
		about.addActionListener(this);//为“关于”按钮添加监听
		//在按钮功能面板上方添加特定字体的游戏名
		gameName=new JLabel(" 贪吃蛇");
		gameName.setFont(new Font("华文隶书", Font.BOLD, 28));
		//在按钮功能面添加各个功能组件
		anniu.add(gameName);
		anniu.add(one);
		anniu.add(two);
		anniu.add(setting);
		anniu.add(order);
		anniu.add(how);
		anniu.add(about);
		anniu.add(mapPanel);
	}
	/*在此游戏初始化面板的构造方法里添加WindowMenu和int两种类型参数，
	 * 分别传入建立的游戏窗体和窗体菜单栏选择的关卡*/
	public FirstWin(WindowMenu a,int g) {
		firstWin=this;
		p=g;
		init(a);
		anniu.setOpaque(false);//将添加所有按钮的面板设置为透明以显示背景图片
		add(anniu,BorderLayout.SOUTH);
		setSize(800+20,800+40);
		setVisible(true);
	}
	
	class actionListener implements ActionListener{
		WindowMenu b;//用来在监听内保存传入的窗体类以执行对窗体的操作
		public  actionListener(WindowMenu a) {
			// TODO Auto-generated constructor stub
			b=a;
		}
		
		@Override
		public void actionPerformed(ActionEvent t) {
			// TODO Auto-generated method stub
			//“单人模式”监听
				if(t.getSource().equals(one)) {
				anniu.setVisible(false);//先关闭按钮面板
				area.setVisible(true);//进入游戏区域
				Map.setMap(p, area, true,m);//地图编号、游戏区、模式
				area.start();//游戏开始
				firstWin.requestFocus();//进入游戏游戏后获取焦点
			}
			//“双人模式”监听（功能同“单人模式”）
			else if(t.getSource().equals(two)) {
				anniu.setVisible(false);
				area.setVisible(true);
				Map.setMap(p, area, false,m);
				area.start();
				firstWin.requestFocus();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//“帮助”监听
		if(e.getSource().equals(how))
			new How();//打开How窗体
		//“关于”监听
		if(e.getSource().equals(about))
			new AboutSnake();//打开AboutSnake窗体
		//“游戏设置”监听
		if(e.getSource().equals(setting))
			new gameSetting(area,firstWin);
			/*打开gameSetting窗体并传入已建立的游戏区和游戏初始化面板*/
		//“游戏记录”监听
		if(e.getSource().equals(order)){
			JavaFile fil = new JavaFile();// 文件处理对象
			fil.ReadFile();// 读取文件
			League_tableWindow le = new League_tableWindow();// 积分排行榜窗口
			le.setBounds(600, 150, 240, 500);// 设置窗口大小
		}
		//“选择地图”下拉列表监听
		if(e.getSource().equals(map)) {
			this.p=map.getSelectedIndex()+1;//更改游戏地图参数
		}
	}
	//外部获取当前面板内建立的游戏区域的方法
	public static gameArea getArea() {
		return area;
	}
	//外部获取当前面板内建立的按钮功能面板的方法
	public static JPanel getAnniu() {
		return anniu;
	}
	//外部获取已建立的当前游戏初始化面板的方法
	public static FirstWin getWin() {
		// TODO Auto-generated method stub
		return firstWin;
	}
	//传入玩家设置的食物数量的方法
	public void setFoodNum(int foodNum) {
		this.m=foodNum;
	}
	//外部获取下拉列表内所选择的地图的方法
	public JComboBox getJCombBox() {
		return map;
	}
}