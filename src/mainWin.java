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
//����һ��������WindowMenuʵ����Ϸ�������ʾ���ڲ�����
class WindowMenu extends JFrame implements ActionListener{
	private JMenuBar menubar;
	private JMenu menu,help,level;
	private JMenuItem [] lev=new JMenuItem[10];
	private String [] num= {"һ","��","��","��","��","��","��","��","��","ʮ"};
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
		setTitle("̰����");//���ô������
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		menu=new JMenu("��Ϸ");
		help=new JMenu("����");
		start=new JMenuItem("����Ϸ");
		order=new JMenuItem("��Ϸ��¼");
		end=new JMenuItem("������Ϸ");
		level=new JMenu("ѡ��ؿ�");
		about=new JMenuItem("����");
		how=new JMenuItem("�淨˵��");
		//ʹ��forѭ�����ʮ����ͼ���Ӳ˵�ѡ���ѭ����Ӽ���
		for(i=0;i<10;i++) {
			lev[i]=new JMenuItem("��ͼ"+num[i]);
			lev[i].addActionListener(this);
			level.add(lev[i]);
		}
		start.addActionListener(this);//Ϊ����ʼ��Ϸ����Ӽ���
		about.addActionListener(this);//Ϊ�����ڡ���Ӽ���
		order.addActionListener(this);//Ϊ����Ϸ��¼����Ӽ���
		how.addActionListener(this);//Ϊ���淨˵������Ӽ���
		end.addActionListener(this);//Ϊ��������Ϸ����Ӽ���
		//�ڡ��˵����������Ӹ������ܵ��Ӳ˵�
		menu.add(start);
		menu.add(level);
		menu.add(order);
		menu.add(end);
		//�ѡ��˵������봰��Ĳ˵�����
		menubar.add(menu);
		//�ڡ��������������Ӹ������ܵ��Ӳ˵�
		help.add(how);
		help.add(about);
		//�ѡ����������봰��Ĳ˵�����
		menubar.add(help);
		//���������ڵ���Ϸ��ʼ���棬��Ϊ����ӱ���ͼƬ
		firstWin=new FirstWin(this,p){
			protected void paintComponent(Graphics g){
				ImageIcon icon=new ImageIcon("1.jpg");
				Image img=icon.getImage();
				g.drawImage(img,0,0,firstWin.getWidth(),firstWin.getHeight(),icon.getImageObserver());
			}
		};
		//��BorderLayout���ֽ���Ϸ��ʼ������ӽ�����
		add(firstWin,BorderLayout.CENTER);
	}
	
/******************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//����ʼ��Ϸ������
		if(e.getSource().equals(start)) {
			FirstWin.getArea().end();//���������е���Ϸ����Ϊ��ֹ
			FirstWin.getArea().setVisible(false);//�����е���Ϸ����ر�
			firstWin.setVisible(true);//�ָ���Ϸ��ʼ��������
			firstWin.getAnniu().setVisible(true);//��ʾ��Ϸ��ʼ��������ϵ����а�ť
		}
		//�����ڡ�����
		if(e.getSource().equals(about))
			new AboutSnake();//��ʾAboutSnake�Ĵ���
		//���淨˵��������
		if(e.getSource().equals(how))
			new How();//��ʾHow�Ĵ���
		//����Ϸ��¼������
		if(e.getSource().equals(order)){
			JavaFile fil = new JavaFile();// �ļ��������
			fil.ReadFile();// ��ȡ�ļ�
			League_tableWindow le = new League_tableWindow();// �������а񴰿�
			le.setBounds(600, 150, 240, 500);// ���ô��ڴ�С
		}
		//��������Ϸ������
		if(e.getSource().equals(end)) {
			firstWin.getArea().end();//���������е���Ϸ����Ϊ��ֹ
			firstWin.setVisible(false);//�ر���Ϸ��ʼ��������
			this.setVisible(false);//�رյ�ǰ��Ϸ�Ĵ���
		}
		/*Ϊÿһ���ؿ��˵���ӵļ�������������pΪ�ؿ�ֵ�����䴫�ݽ���Ϸ
		��ʼ�����ѡ���ͼ�����б��У���֤�˵��е�ѡ��ؿ�����Ϸ��ʼ����
		�������б��ͼѡ�����Ϸ����ͬ�����¡�*/
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
