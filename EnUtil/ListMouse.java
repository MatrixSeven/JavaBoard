/****
 * @author Seven007
 * @date 2014.5.25
 * 实现了MouseMotionListener和MouseListener接口
 * 监听全局鼠标坐标移动，点击等动作
 * 
 * ----------如果程序比较大，那么请把监听里面的逻辑单独写成类，或者在
 * ----------DrawBase的子类里面实现相应的逻辑判断
 * 
 * @date2014.6.7
 * 今天无聊~又修改了下
 * 这个类和Draws可以在精简大约百分之40的代码，这次我觉得重构的代码很失败
 * 越写越臃肿，但是功能都实现了，不想再完善这个无聊的小东西了
 */

package EnUtil;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.MainJanle;

public class ListMouse implements MouseMotionListener, MouseListener {

	private Draws draws = null;
	private MainJanle janle;
	private int drawStateStart = 1;
	private int drawStateEnd = 2;

	public ListMouse(MainJanle janle) {
		draws = new Draws(this.janle = janle);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (janle.getDrawState()) {
		case MainJanle.DRAW_STATE_LINE:
			draws.drawLine(e);
			break;
		case MainJanle.DRAW_STATE_RECT:
			draws.drawLine(e);
			break;
		case MainJanle.DRAW_STATE_ORCL:
			draws.drawLine(e);
		case MainJanle.DRAW_STATE_MOVE:
			draws.drawMove(e);
			break;
		case MainJanle.DRAW_STATE_FLINE:
			draws.drawLine(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		draws.mouseMoved(e);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		draws.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getPoint().x < 65)
			return;
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_RECT)
			draws.drawRect(e, drawStateStart);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_ORCL)
			draws.drawORCL(e, drawStateStart);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_FLINE)
			draws.drawALine(e, drawStateStart);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getPoint().x < 65)
			return;
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_RECT)
			draws.drawRect(e, drawStateEnd);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_ORCL)
			draws.drawORCL(e, drawStateEnd);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_FLINE)
			draws.drawALine(e, drawStateEnd);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
