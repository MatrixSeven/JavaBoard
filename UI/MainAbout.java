package UI;
/**
 * @author Seven
 * 仅仅是一个info界面。
 * 这个后来加的~
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import EnUtil.MyColors;

public class MainAbout extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainAbout(String load) {
		this();
		this.setVisible(true);
		try {
			Thread.sleep(2000);
			this.setVisible(false);
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public MainAbout() {
		this.setTitle("关于");
		this.setIconImage(MyColors.IMG_ABOUT.getImage());
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0f));
		this.setResizable(false);
		this.setSize(new Dimension(430, 400));
		this.setVisible(false);
		this.setLayout(new GridLayout(4, 1));
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(MyColors.IMG_ABOUT.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}

}
