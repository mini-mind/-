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
	//�ڹ��췽���м���gameArea��FirstWin���Ͳ����������ѽ�������Ϸ�������Ϸ��ʼ�����
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
		setTitle("��Ϸ����");
		text1=new JLabel("ʳ������(0-5000):");
		text2=new JLabel("�ƶ��ٶ�(1-100) :");
		//�����Ϊ������Ϸ����ʳ���������ƶ��ٶȣ��򸳳�ʼֵ�������ȡ�û�����Ĳ�����������Ϸ��ʼʱ������
		foodNum=new JTextField(new Integer((Map.getMap()==null?4:Map.getMap().getManeger().getFoodNum())).toString());
		moveSpeed=new JTextField(new Integer(100-a.getSpeed()).toString());
		//�����������ͺ�ʽ������壬�������������ʳ���������ƶ��ٶȵ�������
		box1=Box.createHorizontalBox();
		box1.add(text1);
		box1.add(foodNum);
		box2=Box.createHorizontalBox();
		box2.add(text2);
		box2.add(moveSpeed);
		//��������ѡ��ť�ֱ�������֡���Ч��ʳ����������ʵ�ָ��ı������֡���Ч��ʳ���Ƿ������Ĺ���
		check1=new JCheckBox("����");
		check2=new JCheckBox("��Ч");
		check3=new JCheckBox("ʳ������");
		//��ȡ�û���ѡ�����ã�δ������Ϸ���ø��Ĳ����򸳳�ʼֵ
		check1.setSelected(PlayMusic.getBackGroundSound());
		check2.setSelected(PlayMusic.getSpecialSound());
		check3.setSelected(Map.getMap()==null?moveSound:Map.getMap().getManeger().getSwing());
		box3=Box.createHorizontalBox();
		box3.add(new JLabel("������Ч���ã�"));
		box3.add(check1);
		box3.add(check2);
		box3.add(check3);
		baseBox=Box.createVerticalBox();
		baseBox.add(box1);
		baseBox.add(box2);
		baseBox.add(box3);
		//�ڴ����ڼ���ȷ����ȡ����ť�������ؼ���
		check=new JButton("ȷ��");
		cancel=new JButton("ȡ��");
		panel=new JPanel();
		panel.add(check);
		check.addActionListener(this);
		panel.add(cancel);
		cancel.addActionListener(this);
		add(baseBox,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
	}
	//���ű�����������
	public void backAround() {
		if(check1.isSelected()==true)
			backSound=true;
		else
			backSound=false;
		PlayMusic.setBackGroundSound(check1.isSelected());
	}
	//������Ч����
	public void eatMusic() {
		if(check2.isSelected()==true)
			specialSound=true;
		else
			specialSound=false;
		PlayMusic.setSpecialSound(check2.isSelected());
	}
	//ʳ���Ƿ���������
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
		//��ȷ������ť����
		if(e.getSource().equals(check)) {
			int n=Integer.parseInt(moveSpeed.getText());
			int m=Integer.parseInt(foodNum.getText());
			//������ҿ�����Ĳ�����Χ���ж�
			if(n<1||n>100||m<0||m>5000)
				JOptionPane.showMessageDialog(this, "��������ַ����������Ʒ�Χ��","������ʾ",JOptionPane.WARNING_MESSAGE);
			else {
			//���������Ĳ������뽨������Ϸ������Ϸ��ʼ�����
				a.setSpeed(100-n);
				first.setFoodNum(m);
				setVisible(false);
				first.setVisible(true);
			}
			//���±������֡���Ч��ʳ���Ƿ�����������
			backAround();
			eatMusic();
			foodMove();
		}
		//��ȡ������ť����
		if(e.getSource().equals(cancel))
			setVisible(false);//����ǰ����Ϸ���á�����ر�
	}
}
