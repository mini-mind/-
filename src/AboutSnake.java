import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AboutSnake extends JFrame implements ActionListener{
	private JLabel t1;
	private JButton check;
	private JPanel bt;
	//���췽��
	public AboutSnake(){
		init();
		setSize(300,200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("����̰����");//���ô�������
		t1=new JLabel();
		//ʹ��setText������ʹ��html���Ʊ�ǩ��ʽ
		t1.setText("<html><body>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;̰����<br>"
				+"�汾��1.0.1<br>"
				+"��Ƽ�������Ա��<br>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ƽ���������ܡ��ź���<br>"
				+"��Ȩ���У�YanTai University<br>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ؾ���������ͬ�����㳭Ϯ</body></html>");
		add(t1,BorderLayout.CENTER);
		check=new JButton("ȷ��");
		bt=new JPanel();
		bt.add(check);
		check.addActionListener(this);//Ϊ��ȷ������ť��Ӽ���
		add(bt,BorderLayout.SOUTH);
	}
	//��ȷ������ť����
	public void actionPerformed(ActionEvent e) {
		setVisible(false);//�رյ�ǰ�����ڡ�����
	}
}