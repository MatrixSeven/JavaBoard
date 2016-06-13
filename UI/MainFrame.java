/**
 * @author Seve007
 * @date 2014.5.25
 * ����һ��д�ĺܵ��۵�������
 */

package UI;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import EnUtil.MyColors;

public class MainFrame extends JFrame {
	MainJanleLeft janleLeft = null;
	private static final long serialVersionUID = 1L;

	public MainFrame(final MainJanle janle) {
		this.initMainGUI(janle);
	}

	/**
	 * ��ʼ�������档��Ӳ˵���������
	 * 
	 * @param janle
	 */
	private void initMainGUI(final MainJanle janle) {
		janleLeft = new MainJanleLeft(janle);
		this.setTitle("�򵥻��� By:Seven007");
		// this.setAlwaysOnTop(true);
		this.setSize(1000, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(janle);
		this.setLayout(new BorderLayout());
		this.add(janleLeft, BorderLayout.WEST);
		this.setIconImage(MyColors.IMG_ICON.getImage());
		MenuBar bar = new MenuBar();
		Menu menu = new Menu("�˵�");
		MenuItem item = new MenuItem("����");
		MenuItem item2 = new MenuItem("���������ɫ");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janle.Clearn();
			}
		});
		MenuItem item3 = new MenuItem("�滭����");
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janle.setDrawState(MainJanle.DRAW_STATE_RECT);
			}
		});
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janle.LineColor = MyColors.GetColor();
			}
		});
		Menu menu2 = new Menu("www.showheart.tk/By��Seven007");
		menu2.setEnabled(false);
		menu.add(item);
		menu.add(item2);
		menu.add(item3);
		bar.add(menu);
		bar.add(menu2);
		this.setMenuBar(bar);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);
		this.setVisible(true);
	}

}
