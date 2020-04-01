import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AboutSnake extends JFrame implements ActionListener{
	private JLabel t1;
	private JButton check;
	private JPanel bt;
	//构造方法
	public AboutSnake(){
		init();
		setSize(300,200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("关于贪吃蛇");//设置窗体名称
		t1=new JLabel();
		//使用setText方法，使用html控制标签格式
		t1.setText("<html><body>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贪吃蛇<br>"
				+"版本：1.0.1<br>"
				+"设计及开发人员：<br>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杨平安、赵永杰、张海亮<br>"
				+"版权所有：YanTai University<br>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;盗版必究，如有雷同，是你抄袭</body></html>");
		add(t1,BorderLayout.CENTER);
		check=new JButton("确定");
		bt=new JPanel();
		bt.add(check);
		check.addActionListener(this);//为“确定”按钮添加监听
		add(bt,BorderLayout.SOUTH);
	}
	//“确定”按钮监听
	public void actionPerformed(ActionEvent e) {
		setVisible(false);//关闭当前“关于”窗体
	}
}