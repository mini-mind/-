import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

public class mainWin {
	private static WindowMenu win;
	public static WindowMenu getWin(){
		return win;
	}
	public static void main(String[] args) {
		WindowMenu win=new WindowMenu();
	}
}
//设置一个窗体类WindowMenu实现游戏窗体的显示及内部功能
class WindowMenu extends JFrame implements ActionListener{
	private JMenuBar menubar;
	private JMenu menu,help,level;
	private JMenuItem [] lev=new JMenuItem[10];
	private String [] num= {"一","二","三","四","五","六","七","八","九","十"};
	private JMenuItem start,end,about,how,order;
	private int i;
	int p=1;
	private FirstWin firstWin;
	public WindowMenu(){
		init();
		setSize(818,872);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void init(){
		setTitle("贪吃蛇");//设置窗体标题
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		menu=new JMenu("游戏");
		help=new JMenu("帮助");
		start=new JMenuItem("新游戏");
		order=new JMenuItem("游戏记录");
		end=new JMenuItem("结束游戏");
		level=new JMenu("选择关卡");
		about=new JMenuItem("关于");
		how=new JMenuItem("玩法说明");
		//使用for循环添加十个地图的子菜单选项，并循环添加监听
		for(i=0;i<10;i++) {
			lev[i]=new JMenuItem("地图"+num[i]);
			lev[i].addActionListener(this);
			level.add(lev[i]);
		}
		start.addActionListener(this);//为“开始游戏”添加监听
		about.addActionListener(this);//为“关于”添加监听
		order.addActionListener(this);//为“游戏记录”添加监听
		how.addActionListener(this);//为“玩法说明”添加监听
		end.addActionListener(this);//为“结束游戏”添加监听
		//在“菜单”中逐个添加各个功能的子菜单
		menu.add(start);
		menu.add(level);
		menu.add(order);
		menu.add(end);
		//把“菜单”加入窗体的菜单栏中
		menubar.add(menu);
		//在“帮助”中逐个添加各个功能的子菜单
		help.add(how);
		help.add(about);
		//把“帮助”加入窗体的菜单栏中
		menubar.add(help);
		//创建窗体内的游戏初始界面，并为其添加背景图片
		firstWin=new FirstWin(this,p){
			protected void paintComponent(Graphics g){
				ImageIcon icon=new ImageIcon("1.jpg");
				Image img=icon.getImage();
				g.drawImage(img,0,0,firstWin.getWidth(),firstWin.getHeight(),icon.getImageObserver());
			}
		};
		//以BorderLayout布局将游戏初始界面添加进窗体
		add(firstWin,BorderLayout.CENTER);
	}
	
/******************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//“开始游戏”监听
		if(e.getSource().equals(start)) {
			FirstWin.getArea().end();//把正在运行的游戏调整为终止
			FirstWin.getArea().setVisible(false);//运行中的游戏区域关闭
			firstWin.setVisible(true);//恢复游戏初始界面的面板
			firstWin.getAnniu().setVisible(true);//显示游戏初始界面面板上的所有按钮
		}
		//“关于”监听
		if(e.getSource().equals(about))
			new AboutSnake();//显示AboutSnake的窗体
		//“玩法说明”监听
		if(e.getSource().equals(how))
			new How();//显示How的窗体
		//“游戏记录”监听
		if(e.getSource().equals(order)){
			JavaFile fil = new JavaFile();// 文件处理对象
			fil.ReadFile();// 读取文件
			League_tableWindow le = new League_tableWindow();// 积分排行榜窗口
			le.setBounds(600, 150, 240, 500);// 设置窗口大小
		}
		//“结束游戏”监听
		if(e.getSource().equals(end)) {
			firstWin.getArea().end();//把正在运行的游戏调整为终止
			firstWin.setVisible(false);//关闭游戏初始界面的面板
			this.setVisible(false);//关闭当前游戏的窗体
		}
		/*为每一个关卡菜单添加的监听，其中属性p为关卡值，将其传递进游戏
		初始窗体的选择地图下拉列表中，保证菜单中的选择关卡与游戏初始界面
		的下拉列表地图选择对游戏设置同步更新。*/
		if(e.getSource().equals(lev[0])) {
			this.p=1;
			firstWin.getJCombBox().setSelectedIndex(0);
		}
			
		if(e.getSource().equals(lev[1])) {
			this.p=2;
			firstWin.getJCombBox().setSelectedIndex(1);
		}
		if(e.getSource().equals(lev[2])) {
			this.p=3;
			firstWin.getJCombBox().setSelectedIndex(2);
		}
		if(e.getSource().equals(lev[3])) {
			this.p=4;
			firstWin.getJCombBox().setSelectedIndex(3);
		}
		if(e.getSource().equals(lev[4])) {
			this.p=5;
			firstWin.getJCombBox().setSelectedIndex(4);
		}
		if(e.getSource().equals(lev[5])) {
			this.p=6;
			firstWin.getJCombBox().setSelectedIndex(5);
		}
		if(e.getSource().equals(lev[6])) {
			this.p=7;
			firstWin.getJCombBox().setSelectedIndex(6);
		}
		if(e.getSource().equals(lev[7])) {
			this.p=8;
			firstWin.getJCombBox().setSelectedIndex(7);
		}
		if(e.getSource().equals(lev[8])) {
			this.p=9;
			firstWin.getJCombBox().setSelectedIndex(8);
		}
		if(e.getSource().equals(lev[9])) {
			this.p=10;
			firstWin.getJCombBox().setSelectedIndex(9);
		}
	}
	
}
