import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class League_tableWindow extends JFrame implements ActionListener {
	JLabel jl[] = new JLabel[10];
	JLabel jl2,jl3 = new JLabel();
	JavaFile fil = new JavaFile();
	JButton jb=new JButton();
	int a[] = new int[100];
	String b[] = new String[100];
	int q=100;
	public League_tableWindow() {
		a = fil.geta();
		JPanel p = new JPanel();
		jb=new JButton("清空排行榜");
		p.setLayout(null);
		add(p);
		jl2=new JLabel("贪吃蛇积分");
		jl3=new JLabel("排行榜");
		p.add(jl2);
		p.add(jl3);
		p.add(jb);
		jl2.setBounds(55,15, 150, 50);
		jl2.setFont(new   java.awt.Font("楷体", 1, 25));   
		jl2.setForeground(Color.red);
		jl3.setBounds(70,45, 125, 50);
		jl3.setFont(new   java.awt.Font("楷体", 1, 30));   
		jl3.setForeground(Color.red);
		jb.setBounds(40,400, 150,50);
		jb.setFont(new   java.awt.Font("黑体", 1, 15)); 
		jb.addActionListener(this);
		for (int i = 0; i < fil.geti(); i++) {
			b[i] = a[i] + "";
			jl[i] = new JLabel(b[i]);
			p.add(jl[i]);
			jl[i].setBounds(100, q, 50, 20);
			jl[i].setFont(new   java.awt.Font("宋体", 1, 15)); 
			q=q+30;
			
		}
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		fil.qingkong();	
		for (int i = 0; i < fil.geti(); i++) {
			b[i] = a[i] + "";
			jl[i] = new JLabel(b[i]);		
		}
		this.dispose();
	}
}
