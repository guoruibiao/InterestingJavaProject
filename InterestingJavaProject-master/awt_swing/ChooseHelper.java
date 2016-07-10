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
 * 日期： 2016年5月6日9:36:53
 * 
 * 功能描述：一个简单的Java AWT小程序，可以手动的添加可选项，随机的帮助自己做出选择
 * 
 * 算法：利用了Java自带的随机算法实现的对于列表List中元素的随机选择
 * 
 * @author Administrator
 *
 */
public class ChooseHelper {

	/**
	 * 实现的思路： 首先是一个展示的主界面，用于展示结果以及用户的交互操作，当点击添加按钮的时候会自动的弹出一个添加界面
	 * 在添加界面中，用户既可以浏览到原有的选项，也可以实时的看到新添加的选项（这里把新添加的选项置顶了，方便用户观察）
	 * 在点击“完成”按钮后即可回到原主界面，进行新的随机事件的结果获取。
	 * 
	 * 注意： 这里没有采用分层的设计是因为，程序太小，分层的话显得过于的繁琐。
	 * 对于布局和各种侦听事件的设置也没有一个详细的步骤，应该尽量的减少冗余代码的存在。
	 */
	public ChooseHelper() {
		Frame frame = new Frame();
		frame.setTitle("帮我做选择");
		List<String> list = new ArrayList<String>();
		list.add("打一小会CS！");
		list.add("开始复习吧！");
		Label label = new Label("", Label.CENTER);
		label.setFont(new Font("Arial Bold", Font.ITALIC, 32));
		label.setForeground(Color.decode("#00FFFF"));
		frame.setLayout(new BorderLayout());
		frame.add(label, BorderLayout.CENTER);
		Panel panel = new Panel(new FlowLayout());
		Button addItem = new Button("添加项");
		Button doItem = new Button("随机一下");
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
		 * 点击这个按钮弹出一个添加备选项的界面
		 */
		addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame addFrame = new Frame();
				addFrame.setTitle("添加备选项");
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
				Button addTf = new Button("添加这个内容");
				Button complete = new Button("完成");
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
							JOptionPane.showMessageDialog(null, "请输入您要进行的活动！");
						}
					}
				});
			}

			/**
			 * 将刷新list的任务抽取出来，便于每一次的结果的刷新显示。
			 * 
			 * @param ta
			 *            用于显示刷新后的结果
			 * @param list
			 *            将list中的内容刷新到上面的容器TextArea中
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
	 * 主程序的入口，测试一下程序的运行结果
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ChooseHelper helper = new ChooseHelper();

	}

}
