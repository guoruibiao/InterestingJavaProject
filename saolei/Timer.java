package saolei;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Timer extends Frame implements Runnable {

	private Frame frame;
	private Label label;

	public Timer() {
		frame = new Frame("Timer");
		frame.setSize(400, 300);
		frame.setVisible(true);
		label = new Label();
		label.setText("Here is the hint text");
		frame.add(label, BorderLayout.CENTER);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void run() {
		int count = 0;
		try {
			while (true) {
				Thread.sleep(1000);
				count += 1;
				label.setText("You have spent +   " + count + "   Seconds!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Thread thread = new Thread(new Timer());
		thread.start();
	}

}
