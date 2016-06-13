package UI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import EnUtil.ListButton;
import UI.MyButton.MyButton;

public class MainJanleLeft extends JPanel {
	/**
	 * 面板左界面
	 */
	private static final long serialVersionUID = 1L;

	public MainJanleLeft(MainJanle janle) {
		initGUI(janle);
		this.setName("left");
	}

	private void initGUI(MainJanle janle) {
		this.setLayout(new GridLayout(13, 0, 15, 15));
		ListButton lister = new ListButton(janle);
		MyButton button[] = new MyButton[] { new MyButton("画块"), new MyButton("画圆"), new MyButton("直线"),
				new MyButton("铅笔"), new MyButton("拖动"), new MyButton("清屏"), new MyButton("改色"), new MyButton("保存"),
				new MyButton("关于"), };
		for (MyButton bu : button) {
			bu.addActionListener(lister);
			add(bu);
		}
	}

}
