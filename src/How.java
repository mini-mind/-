import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class How extends JFrame implements ActionListener{
	private JLabel text;
	private JButton check;
	private JPanel bt;
	//���췽��
	public How(){
		init();
		setSize(350,250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("�淨˵��");//���ô�������
		text=new JLabel();
		bt=new JPanel();
		check=new JButton("ȷ��");
		//ʹ��setText������ʹ��html���Ʊ�ǩ��ʽ
		text.setText("<html><body>&nbsp;&nbsp;&nbsp;&nbsp;�淨˵����<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;Ϊ�����ӿ����ԣ�����Ϸ������ʮ���ؿ���<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;��Ϊʮ����ͬ�ĵ��Σ��͵�˫����Ϸģʽ��ͨ��<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;�������ҷ������wasd����̰���ߵ��ƶ��Ե�ʳ<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;���ͬʱ��Ҫ�ܿ���Ӳ��ǽ�塣��Ϸ��¼����ʾ<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;����ģʽ��������Ϸ��¼�е�ǰʮ������Ϸ����<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;����ʾ�����ֵĻ��֡�<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;������ʾ��<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;�Ե���˸��ʳ����ö���ӷ֣�<br>"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;�Ե�ʳ��Խ�̰࣬��������Խ������Ҫҧ���Լ�Ŷ��</body></html>");
		add(text,BorderLayout.CENTER);
		check.addActionListener(this);//Ϊ��ȷ������ť��Ӽ���
		bt.add(check);
		add(bt,BorderLayout.SOUTH);
	}
	
/****************************************************************************************/
	@Override
	//��ȷ������ť����
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);//�رյ�ǰ���淨˵��������
	}
	
}
