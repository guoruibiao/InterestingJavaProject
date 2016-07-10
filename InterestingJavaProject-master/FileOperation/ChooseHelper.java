package tools;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * ���ڣ� 2016��5��6��9:36:53
 * 
 * ����������һ���򵥵�Java AWTС���򣬿����ֶ�����ӿ�ѡ�����İ����Լ�����ѡ��
 * 
 * �㷨��������Java�Դ�������㷨ʵ�ֵĶ����б�List��Ԫ�ص����ѡ��
 * 
 * @author Administrator
 *
 */
public class ChooseHelper {

	/**
	 * ʵ�ֵ�˼·�� ������һ��չʾ�������棬����չʾ����Լ��û��Ľ����������������Ӱ�ť��ʱ����Զ��ĵ���һ����ӽ���
	 * ����ӽ����У��û��ȿ��������ԭ�е�ѡ�Ҳ����ʵʱ�Ŀ�������ӵ�ѡ����������ӵ�ѡ���ö��ˣ������û��۲죩
	 * �ڵ������ɡ���ť�󼴿ɻص�ԭ�����棬�����µ�����¼��Ľ����ȡ��
	 * 
	 * ע�⣺ ����û�в��÷ֲ���������Ϊ������̫С���ֲ�Ļ��Եù��ڵķ�����
	 * ���ڲ��ֺ͸��������¼�������Ҳû��һ����ϸ�Ĳ��裬Ӧ�þ����ļ����������Ĵ��ڡ�
	 */
	public ChooseHelper() {
		Frame frame = new Frame();
		frame.setTitle("������ѡ��");
		List<String> list = new ArrayList<String>();
		list.add("��һС��CS��");
		list.add("��ʼ��ϰ�ɣ�");
		Label label = new Label("", Label.CENTER);
		label.setFont(new Font("Arial Bold", Font.ITALIC, 32));
		label.setForeground(Color.decode("#00FFFF"));
		frame.setLayout(new BorderLayout());
		frame.add(label, BorderLayout.CENTER);
		Panel panel = new Panel(new FlowLayout());
		Button addItem = new Button("�����");
		Button doItem = new Button("���һ��");
		panel.add(addItem);
		panel.add(doItem);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		/**
		 * ��������ť����һ����ӱ�ѡ��Ľ���
		 */
		addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame addFrame = new Frame();
				addFrame.setTitle("��ӱ�ѡ��");
				addFrame.setVisible(true);
				addFrame.setSize(400, 300);
				addFrame.setLocationRelativeTo(null);
				addFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						addFrame.setVisible(false);
						addFrame.dispose();
					};
				});

				TextArea ta = new TextArea();
				ta.setEditable(false);
				ta.setFocusable(false);
				refreshList(ta, list);

				addFrame.add(ta, BorderLayout.CENTER);
				Panel bottom = new Panel(new FlowLayout());
				TextField tf = new TextField(28);
				Button addTf = new Button("����������");
				Button complete = new Button("���");
				bottom.add(tf);
				bottom.add(addTf);
				bottom.add(complete);
				addFrame.add(bottom, BorderLayout.SOUTH);
				complete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addFrame.setVisible(false);
						addFrame.dispose();
					}
				});
				addTf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String item = tf.getText().toString();
						if (item != null && !item.equals("")) {
							list.add(0, item);
							tf.setText("");
							refreshList(ta, list);
						} else {
							JOptionPane.showMessageDialog(null, "��������Ҫ���еĻ��");
						}
					}
				});
			}

			/**
			 * ��ˢ��list�������ȡ����������ÿһ�εĽ����ˢ����ʾ��
			 * 
			 * @param ta
			 *            ������ʾˢ�º�Ľ��
			 * @param list
			 *            ��list�е�����ˢ�µ����������TextArea��
			 */
			private void refreshList(TextArea ta, List<String> list) {
				ta.setText("");
				for (int i = 0; i < list.size(); i++) {
					ta.append(list.get(i) + "\n");
				}
			}
		});

		doItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int length = list.size();
				label.setText(list.get((int) (Math.random() * length)));
			}
		});
	}

	/**
	 * ���������ڣ�����һ�³�������н��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ChooseHelper helper = new ChooseHelper();

	}

}
