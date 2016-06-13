/**
 * 	按钮基类，储存各种活动信息
 * 		@author Seven
 * 			2014.5.12
 * @date 2014.6.7
 * 以前写的~正好用上了~索性就copy过来了
 */
package UI.MyButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import EnUtil.MyColors;

public abstract class ButtonBase extends JButton {
	protected String text;
	protected String press1 = "/img/b1.jpg";
	protected String press2 = "/img/b2.jpg";
	protected int fontSize = 20;
	protected ImageIcon enter = MyColors.IMG_BUTTON;
	protected ImageIcon enter_down = MyColors.IMG_BUTTON_DOWN;
	protected static final long serialVersionUID = 1L;

	/**
	 * @seven
	 * @return 返回按钮上面文字
	 */
	public String getText() {
		return text;
	}

	/**
	 * @author Seven
	 * @param 设置按钮上的文字，参数String
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @author Seven
	 * @param 设置文字大小
	 *            int
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getPress1() {
		return press1;
	}

	public void setPress1(String press1) {
		this.press1 = press1;
	}

	public String getPress2() {
		return press2;
	}

	public void setPress2(String press2) {
		this.press2 = press2;
	}

}
