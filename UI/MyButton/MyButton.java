package UI.MyButton;
/**
 *  * @date 2014.6.7
 * 以前写的~正好用上了~索性就copy过来了
 * 重写了button外形
 */

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import EnUtil.MyColors;

public class MyButton extends ButtonBase {

	public MyButton(String text) {
		this.text = text;
	}

	public MyButton(String text, String press1, String press2) {
		this(text);
		this.press1 = press1;
		this.press2 = press2;
	}

	private static final long serialVersionUID = 1L;

	protected void paintBorder(Graphics g) {
		super.paintBorder(g);
		// setBackground(new Color(0,0,0,0f));
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setSize(60, 34);
		Graphics2D g2 = (Graphics2D) g;
		ImageIcon icon = new ImageIcon(MyColors.class.getResource(press1));
		if (this.getModel().isRollover())
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (this.getModel().isPressed())
			icon.setImage(new ImageIcon(MyColors.class.getResource(press2)).getImage());
		g2.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getWidth(), null);
		g2.setFont(new Font("宋体", Font.BOLD, fontSize));
		g2.drawString(text, (this.getWidth() - (this.text.length() * 13)) / 2 - 8, this.getSize().height / 2 + 10);
	}

}
