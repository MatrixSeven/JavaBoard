/**
 * 	��ť���࣬������ֻ��Ϣ
 * 		@author Seven
 * 			2014.5.12
 * @date 2014.6.7
 * ��ǰд��~����������~���Ծ�copy������
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
	 * @return ���ذ�ť��������
	 */
	public String getText() {
		return text;
	}

	/**
	 * @author Seven
	 * @param ���ð�ť�ϵ����֣�����String
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @author Seven
	 * @param �������ִ�С
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
