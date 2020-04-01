import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gameSetting extends JFrame implements ActionListener{
	private JLabel text1,text2;
	private JTextField foodNum,moveSpeed;
	private Box baseBox,box1,box2,box3;
	private JCheckBox check1,check2,check3;
	private JPanel panel;
	private JButton check,cancel;
	private gameArea a;
	private boolean backSound=true,specialSound=true,moveSound=true;
	private FirstWin first;
	//在构造方法中加入gameArea和FirstWin类型参数，传入已建立的游戏区域和游戏初始化面板
	public gameSetting(gameArea area,FirstWin firstWin) {
		a=area;
		first=firstWin;
		init();
		setSize(300,150);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void init() {
		setTitle("游戏设置");
		text1=new JLabel("食物数量(0-5000):");
		text2=new JLabel("移动速度(1-100) :");
		//若玩家为进入游戏设置食物数量和移动速度，则赋初始值，否则读取用户输入的参数并更改游戏开始时的设置
		foodNum=new JTextField(new Integer((Map.getMap()==null?4:Map.getMap().getManeger().getFoodNum())).toString());
		moveSpeed=new JTextField(new Integer(100-a.getSpeed()).toString());
		//定义两个行型盒式布局面板，在其中添加设置食物数量和移动速度的相关组件
		box1=Box.createHorizontalBox();
		box1.add(text1);
		box1.add(foodNum);
		box2=Box.createHorizontalBox();
		box2.add(text2);
		box2.add(moveSpeed);
		//设置三个选择按钮分别添加音乐、音效、食物跳动，以实现更改背景音乐、音效和食物是否跳动的功能
		check1=new JCheckBox("音乐");
		check2=new JCheckBox("音效");
		check3=new JCheckBox("食物跳动");
		//获取用户勾选的设置，未进入游戏设置更改参数则赋初始值
		check1.setSelected(PlayMusic.getBackGroundSound());
		check2.setSelected(PlayMusic.getSpecialSound());
		check3.setSelected(Map.getMap()==null?moveSound:Map.getMap().getManeger().getSwing());
		box3=Box.createHorizontalBox();
		box3.add(new JLabel("音乐音效设置："));
		box3.add(check1);
		box3.add(check2);
		box3.add(check3);
		baseBox=Box.createVerticalBox();
		baseBox.add(box1);
		baseBox.add(box2);
		baseBox.add(box3);
		//在窗体内加入确定和取消按钮并添加相关监听
		check=new JButton("确定");
		cancel=new JButton("取消");
		panel=new JPanel();
		panel.add(check);
		check.addActionListener(this);
		panel.add(cancel);
		cancel.addActionListener(this);
		add(baseBox,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
	}
	//播放背景音乐设置
	public void backAround() {
		if(check1.isSelected()==true)
			backSound=true;
		else
			backSound=false;
		PlayMusic.setBackGroundSound(check1.isSelected());
	}
	//播放音效设置
	public void eatMusic() {
		if(check2.isSelected()==true)
			specialSound=true;
		else
			specialSound=false;
		PlayMusic.setSpecialSound(check2.isSelected());
	}
	//食物是否跳动设置
	public void foodMove() {
		if(check3.isSelected()==true)
			moveSound=true;
		else
			moveSound=false;
		foodManeger.setSwing(check3.isSelected());
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//“确定”按钮监听
		if(e.getSource().equals(check)) {
			int n=Integer.parseInt(moveSpeed.getText());
			int m=Integer.parseInt(foodNum.getText());
			//设置玩家可输入的参数范围并判断
			if(n<1||n>100||m<0||m>5000)
				JOptionPane.showMessageDialog(this, "您输入的字符超过了限制范围！","错误提示",JOptionPane.WARNING_MESSAGE);
			else {
			//将玩家输入的参数传入建立的游戏区和游戏初始化面板
				a.setSpeed(100-n);
				first.setFoodNum(m);
				setVisible(false);
				first.setVisible(true);
			}
			//更新背景音乐、音效、食物是否跳动的设置
			backAround();
			eatMusic();
			foodMove();
		}
		//“取消”按钮监听
		if(e.getSource().equals(cancel))
			setVisible(false);//将当前“游戏设置”窗体关闭
	}
}
