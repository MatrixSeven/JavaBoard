/****
 * @author Seven007
 * @date 2014.5.25
 * ʵ����MouseMotionListener��MouseListener�ӿ�
 * ����ȫ����������ƶ�������ȶ���
 * 
 * ----------�������Ƚϴ���ô��Ѽ���������߼�����д���࣬������
 * ----------DrawBase����������ʵ����Ӧ���߼��ж�
 * 
 * @date2014.6.7
 * ��������~���޸�����
 * ������Draws�����ھ����Լ�ٷ�֮40�Ĵ��룬����Ҿ����ع��Ĵ����ʧ��
 * ԽдԽӷ�ף����ǹ��ܶ�ʵ���ˣ�����������������ĵ�С������
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
