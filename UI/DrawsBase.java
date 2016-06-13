/**
 * @author Seven
 * @date 2014.5.25
 * 基类，用于统一代码规范
 */

package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class DrawsBase {
	MainJanle janle = null;
	Color color = Color.BLACK;
	public static int COUSE_STATE = 0;

	abstract public void draw(Graphics g);;

	abstract public void clearn();

	abstract public void setMyColor(Color color);

	abstract public void drawPoint(MouseEvent e, int state);

	public void showColor(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 13));
		g.setColor(this.color);
		g.drawString("当前颜色:" + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue(), 70, 55);

	}

}
