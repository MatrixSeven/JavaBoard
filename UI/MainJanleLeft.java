package UI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import EnUtil.ListButton;
import UI.MyButton.MyButton;

public class MainJanleLeft extends JPanel {
	/**
	 * ��������
	 */
	private static final long serialVersionUID = 1L;

	public MainJanleLeft(MainJanle janle) {
		initGUI(janle);
		this.setName("left");
	}

	private void initGUI(MainJanle janle) {
		this.setLayout(new GridLayout(13, 0, 15, 15));
		ListButton lister = new ListButton(janle);
		MyButton button[] = new MyButton[] { new MyButton("����"), new MyButton("��Բ"), new MyButton("ֱ��"),
				new MyButton("Ǧ��"), new MyButton("�϶�"), new MyButton("����"), new MyButton("��ɫ"), new MyButton("����"),
				new MyButton("����"), };
		for (MyButton bu : button) {
			bu.addActionListener(lister);
			add(bu);
		}
	}

}
