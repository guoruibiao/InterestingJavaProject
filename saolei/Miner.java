package saolei;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * �����һ���򵥵�ɨ�����ӣ��սӴ�swing��д�ģ��ʺ�������ϰ �ó���ʹ��setBounds��x,y,w,h���Կؼ����� �����ο�win
 * xp�Դ���ɨ�ף���Ȼ��д����û�������� �����������Ĺ�����Щ������bug
 * 
 * @author Ping_QC
 */
public class Miner extends JFrame implements ActionListener, Runnable, MouseListener {

	private static final long serialVersionUID = -2417758397965039613L;
	private final int EMPTY = 0;
	private final int MINE = 1;
	private final int CHECKED = 2;
	private final int MINE_COUNT = 10; // �׵ĸ���
	private final int BUTTON_BORDER = 50; // ÿ����ĳߴ�
	private final int MINE_SIZE = 10; // ������, 20x20
	private final int START_X = 20; // ��ʼλ��x
	private final int START_Y = 50; // ��ʼλ��y

	private boolean flag;
	private JButton[][] jb;
	private JLabel jl;
	private JLabel showTime;
	private int[][] map;
	/**
	 * ���ĳ����Χ�Ƿ����ף���Χ���������ɸ��������õ�
	 */
	private int[][] mv = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	/**
	 * ��������趨��������
	 */
	public void makeMine() {
		int i = 0, tx, ty;
		for (; i < MINE_COUNT;) {
			tx = (int) (Math.random() * MINE_SIZE);
			ty = (int) (Math.random() * MINE_SIZE);
			if (map[tx][ty] == EMPTY) {
				map[tx][ty] = MINE;
				i++; // �����ظ���������
			}
		}
	}

	/**
	 * ��button����ŵ�frame�ϣ���map[][]�����Ӧ
	 */
	public void makeButton() {
		for (int i = 0; i < MINE_SIZE; i++) {
			for (int j = 0; j < MINE_SIZE; j++) {
				jb[i][j] = new JButton();
				// if (map[i][j] == MINE)
				// jb[i][j].setText(i+","+j);

				// listener add
				jb[i][j].addActionListener(this);
				jb[i][j].addMouseListener(this);

				jb[i][j].setName(i + "_" + j); // ���������ж��ǵ�����ĸ���ť
				// Font font = new Font(Font.SERIF, Font.BOLD, 10);
				// jb[i][j].setFont(font);
				// jb[i][j].setText(i+","+j);
				jb[i][j].setBounds(j * BUTTON_BORDER + START_X, i * BUTTON_BORDER + START_Y, BUTTON_BORDER,
						BUTTON_BORDER);
				this.add(jb[i][j]);
			}
		}
	}

	public void init() {

		flag = false;

		jl.setText("��ӭ���ԣ�һ����" + MINE_COUNT + "����");
		jl.setVisible(true);
		jl.setBounds(20, 20, 500, 30);
		this.add(jl);
		////////////////////////////////////////////////////////////////////////////////////////////// �޸Ĳ���2�����һ�����¿�ʼ�İ�ť
//		JButton restart = new JButton("���¿�ʼ");
//		restart.setBounds(280, 20, 120, 30);
//		this.add(restart);
//		restart.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "��������һ�����⣬�Ҳ������ˣ�");
//			}
//
//		});

		showTime.setText("����ʱ��0 ��");
		showTime.setBounds(400, 20, 100, 30);
		this.add(showTime);

		makeMine();
		makeButton();
		this.setSize(550, 600);
		this.setLocation(700, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Miner test = new Miner("Hello Miner!");
		
		test.init();
		test.run();
	}

	public Miner(String title) {
		super(title);

		this.setLayout(null); // ��ʹ�ò��ֹ�������ÿ���ؼ���λ����setBounds�趨

		jb = new JButton[MINE_SIZE][MINE_SIZE];
		jl = new JLabel();
		showTime = new JLabel();
		map = new int[MINE_SIZE][MINE_SIZE]; // ����ťӳ�䵽������
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		int x, y;
		if ((obj instanceof JButton) == false) {
			showMessage("����", "�ڲ�����");
			return;
		}
		String[] tmp_str = ((JButton) obj).getName().split("_");
		x = Integer.parseInt(tmp_str[0]);
		y = Integer.parseInt(tmp_str[1]);

		if (map[x][y] == MINE) {
			showMessage("����", "��ȵ�������~~~");
			flag = true;
			showMine();
			return;
		}
		dfs(x, y, 0);

		checkSuccess();
	}

	/**
	 * ÿ�ε������ж���û�а�ȫ���׶��ҵ� ͨ������״̬Ϊenable�İ�ť�ĸ������ж�
	 */
	private void checkSuccess() {
		int cnt = 0;
		for (int i = 0; i < MINE_SIZE; i++) {
			for (int j = 0; j < MINE_SIZE; j++) {
				if (jb[i][j].isEnabled()) {
					cnt++;
				}
			}
		}
		if (cnt == MINE_COUNT) {
			String tmp_str = showTime.getText();
			tmp_str = tmp_str.replaceAll("[^0-9]", "");
			showMessage("ʤ��", "����ɨ�׹���ʱ��" + tmp_str + "��");
			flag = true;
			showMine();
		}
	}

	private int dfs(int x, int y, int d) {
		map[x][y] = CHECKED;
		int i, tx, ty, cnt = 0;
		for (i = 0; i < 8; i++) {
			tx = x + mv[i][0];
			ty = y + mv[i][1];
			if (tx >= 0 && tx < MINE_SIZE && ty >= 0 && ty < MINE_SIZE) {
				if (map[tx][ty] == MINE) {
					cnt++;// �õ㸽������ͳ��
				} else if (map[tx][ty] == EMPTY) {
					;
				} else if (map[tx][ty] == CHECKED) {
					;
				}
			}
		}
		if (cnt == 0) {
			for (i = 0; i < 8; i++) {
				tx = x + mv[i][0];
				ty = y + mv[i][1];
				if (tx >= 0 && tx < MINE_SIZE && ty >= 0 && ty < MINE_SIZE && map[tx][ty] != CHECKED) {
					dfs(tx, ty, d + 1);
				}
			}
		} else {
			jb[x][y].setText(cnt + "");
		}
		jb[x][y].setEnabled(false);
		return cnt;
	}

	/**
	 * ��jl��ǩ����ʾһЩ��Ϣ
	 * 
	 * @param title
	 * @param info
	 */
	private void showMessage(String title, String info) {
		jl.setText(info);
		System.out.println("in functino showMessage()  :  " + info);
	}

	public void run() {
		int t = 0;
		while (true) {
			if (flag) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t++;
			showTime.setText("����ʱ��" + t + " ��");
		}
		// showMine();
	}

	private void showMine() {
		// Icon iconMine = new ImageIcon("e:/mine.jpg");
		for (int i = 0; i < MINE_SIZE; i++) {
			for (int j = 0; j < MINE_SIZE; j++) {
				if (map[i][j] == MINE) {
					jb[i][j].setText("#");
					// jb[i][j].setIcon(iconMine);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			Object obj = e.getSource();
			if ((obj instanceof JButton) == false) {
				showMessage("����", "�ڲ�����");
				return;
			}
			String[] tmp_str = ((JButton) obj).getName().split("_");
			int x = Integer.parseInt(tmp_str[0]);
			int y = Integer.parseInt(tmp_str[1]);
			if ("{1}quot;".equals(jb[x][y].getText())) {
				jb[x][y].setText("");
			} else {
				//////////////////////////////////////////////////////////////////////////////////// �޸Ĳ���
				jb[x][y].setIcon(new ImageIcon("flag.jpg"));
				// jb[x][y].setText("{1}quot;");
			}
			/*
			 * if(jb[x][y].getIcon() == null){ jb[x][y].setIcon(new
			 * ImageIcon("e:/flag.jpg")); }else{ jb[x][y].setIcon(null); }
			 */
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}