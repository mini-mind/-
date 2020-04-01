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
		//����Ϸ��ʼ������ڽ�����Ϸ����
		area=new gameArea();
		//ʹ��GridLayout���ֽ����������а�ť�����
		anniu=new JPanel(new GridLayout(8, 1, 50, 30));
		a.add(area);
		area.setVisible(false);
		one=new JButton("����ģʽ");
		two=new JButton("˫��ģʽ");
		setting=new JButton("��Ϸ����");
		order=new JButton("��Ϸ��¼");
		how=new JButton("����");
		about=new JButton("����");
		map=new JComboBox();
		//Ϊ�����б�����б��ڵ�����
		map.addItem("һ");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("��");
		map.addItem("ʮ");
		//����������б���������Ϊ���ͺ�ʽ���֣�ʹ��ӵı�ǩ�������б�ͬ��һ��
		mapPanel=Box.createHorizontalBox();
		mapPanel.add(new JLabel("ѡ���ͼ��"));
		mapPanel.add(map);
		map.addActionListener(this);//Ϊ�����б���Ӽ���
		listener = new actionListener(a);
		one.addActionListener(listener);//Ϊ������ģʽ����ť��Ӽ���
		two.addActionListener(listener);//Ϊ��˫��ģʽ����ť��Ӽ���
		setting.addActionListener(this);//Ϊ����Ϸ���á���ť��Ӽ���
		order.addActionListener(this);//Ϊ����Ϸ��¼����ť��Ӽ���
		how.addActionListener(this);//Ϊ����������ť��Ӽ���
		about.addActionListener(this);//Ϊ�����ڡ���ť��Ӽ���
		//�ڰ�ť��������Ϸ�����ض��������Ϸ��
		gameName=new JLabel(" ̰����");
		gameName.setFont(new Font("��������", Font.BOLD, 28));
		//�ڰ�ť��������Ӹ����������
		anniu.add(gameName);
		anniu.add(one);
		anniu.add(two);
		anniu.add(setting);
		anniu.add(order);
		anniu.add(how);
		anniu.add(about);
		anniu.add(mapPanel);
	}
	/*�ڴ���Ϸ��ʼ�����Ĺ��췽�������WindowMenu��int�������Ͳ�����
	 * �ֱ��뽨������Ϸ����ʹ���˵���ѡ��Ĺؿ�*/
	public FirstWin(WindowMenu a,int g) {
		firstWin=this;
		p=g;
		init(a);
		anniu.setOpaque(false);//��������а�ť���������Ϊ͸������ʾ����ͼƬ
		add(anniu,BorderLayout.SOUTH);
		setSize(800+20,800+40);
		setVisible(true);
	}
	
	class actionListener implements ActionListener{
		WindowMenu b;//�����ڼ����ڱ��洫��Ĵ�������ִ�жԴ���Ĳ���
		public  actionListener(WindowMenu a) {
			// TODO Auto-generated constructor stub
			b=a;
		}
		
		@Override
		public void actionPerformed(ActionEvent t) {
			// TODO Auto-generated method stub
			//������ģʽ������
				if(t.getSource().equals(one)) {
				anniu.setVisible(false);//�ȹرհ�ť���
				area.setVisible(true);//������Ϸ����
				Map.setMap(p, area, true,m);//��ͼ��š���Ϸ����ģʽ
				area.start();//��Ϸ��ʼ
				firstWin.requestFocus();//������Ϸ��Ϸ���ȡ����
			}
			//��˫��ģʽ������������ͬ������ģʽ����
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
		//������������
		if(e.getSource().equals(how))
			new How();//��How����
		//�����ڡ�����
		if(e.getSource().equals(about))
			new AboutSnake();//��AboutSnake����
		//����Ϸ���á�����
		if(e.getSource().equals(setting))
			new gameSetting(area,firstWin);
			/*��gameSetting���岢�����ѽ�������Ϸ������Ϸ��ʼ�����*/
		//����Ϸ��¼������
		if(e.getSource().equals(order)){
			JavaFile fil = new JavaFile();// �ļ��������
			fil.ReadFile();// ��ȡ�ļ�
			League_tableWindow le = new League_tableWindow();// �������а񴰿�
			le.setBounds(600, 150, 240, 500);// ���ô��ڴ�С
		}
		//��ѡ���ͼ�������б����
		if(e.getSource().equals(map)) {
			this.p=map.getSelectedIndex()+1;//������Ϸ��ͼ����
		}
	}
	//�ⲿ��ȡ��ǰ����ڽ�������Ϸ����ķ���
	public static gameArea getArea() {
		return area;
	}
	//�ⲿ��ȡ��ǰ����ڽ����İ�ť�������ķ���
	public static JPanel getAnniu() {
		return anniu;
	}
	//�ⲿ��ȡ�ѽ����ĵ�ǰ��Ϸ��ʼ�����ķ���
	public static FirstWin getWin() {
		// TODO Auto-generated method stub
		return firstWin;
	}
	//����������õ�ʳ�������ķ���
	public void setFoodNum(int foodNum) {
		this.m=foodNum;
	}
	//�ⲿ��ȡ�����б�����ѡ��ĵ�ͼ�ķ���
	public JComboBox getJCombBox() {
		return map;
	}
}