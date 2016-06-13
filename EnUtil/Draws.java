package EnUtil;
/**
 * @author Seven
 * @date 2014.6.7
 * �����ع�������д�ú�ӷ�ס�
 * �����Ѿ��뵽��һ���ع��ķ�����������һ�����������
 * ��Բ��ֱ�ߣ�����ķ���
 * ���Ǿ��ú����ģ������Ժ�ѡ�
 * 
 *2014.6.9�ٴ��ع����������з���������DrawBase����ʵ��
 *�޸�main~��������ʵ��~��ȡxml
 *����ʵ�ֲ��ģʽ
 */

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import UI.MainJanle;

public class Draws {

	private MainJanle janle;
	/**
	 * ���״̬
	 */
	public static int COUSE_STATE = 0;

	public Draws(MainJanle janle) {
		this.janle = janle;
	}

	/**
	 * @author Seven ����Ϊdrawline������Զ��ֹ �벻�����ʵ����� ��������˶�̬��ʵ��ͼˢ�������Ч��
	 * @param e
	 */
	public void drawLine(MouseEvent e) {
		this.janle.setTitlePoint("����[" + e.getPoint().x + "," + e.getPoint().y + "]");
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_LINE) {
			SetCouseState(1);
			this.janle.getDrawLine().getPoints().add(e.getPoint());
		}
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_RECT)
			IsLineDrawRect(e);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_ORCL)
			IsLineDrawOrcl(e);
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_FLINE)
			IsLineDrawAline(e);
	}

	/**
	 * @author Seven
	 * @param e
	 *            ����ڻ�ͼ��ʱ��ʵʱˢ�¸������꣬��̬��ͼ
	 */
	private void IsLineDrawRect(MouseEvent e) {
		this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).lens[1] = Math
				.abs(this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).point.x
						- e.getPoint().x);
		this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).lens[0] = Math
				.abs(this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).point.y
						- e.getPoint().y - 20);
	}

	/**
	 * @author Seven
	 * @param e
	 *            ����ڻ�ͼ��ʱ��ʵʱˢ�¸������꣬��̬��ͼ
	 */
	private void IsLineDrawOrcl(MouseEvent e) {
		this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).lens[1] = Math
				.abs(this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).point.x
						- e.getPoint().x);
		this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).lens[0] = Math
				.abs(this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).point.y
						- e.getPoint().y - 20);
	}

	/**
	 * @author Seven
	 * @param e
	 *            ����ڻ�ͼ��ʱ��ʵʱˢ�¸������꣬��̬��ͼ
	 */
	private void IsLineDrawAline(MouseEvent e) {
		this.janle.getDrawALine().shapeInfos.get(this.janle.getDrawALine().shapeInfos.size() - 1).lens[1] = Math
				.abs(e.getPoint().x);
		this.janle.getDrawALine().shapeInfos.get(this.janle.getDrawALine().shapeInfos.size() - 1).lens[0] = Math
				.abs(e.getPoint().y + 20);
	}

	/**
	 * @author Seven
	 * @param e
	 * @param state
	 *            ��¼����ͼ�εĿ�ʼ����
	 */
	public void drawRect(MouseEvent e, int state) {
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_RECT) {
			if (state == 1) {
				this.janle.getDrawRect().shapeInfos.add(new ShapeInfo(new Point(e.getPoint().x, e.getPoint().y + 20)));
				return;
			}
			if (state == 2) {
				int endY = this.janle.getDrawRect().shapeInfos
						.get(this.janle.getDrawRect().shapeInfos.size() - 1).point.y - e.getPoint().y - 20;
				int endX = this.janle.getDrawRect().shapeInfos
						.get(this.janle.getDrawRect().shapeInfos.size() - 1).point.x - e.getPoint().x;
				this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).lens[1] = Math
						.abs(endX);
				this.janle.getDrawRect().shapeInfos.get(this.janle.getDrawRect().shapeInfos.size() - 1).lens[0] = Math
						.abs(endY);
			}
		}
	}

	/**
	 * @author Seven �ƶ����飬�Ժ����ͼ�ζ���������������ж�
	 * @param e
	 */
	public void drawMove(MouseEvent e) {
		this.janle.setTitlePoint("����[" + e.getPoint().x + "," + e.getPoint().y + "]");
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_MOVE) {
			for (int i = 0; i < this.janle.getDrawRect().shapeInfos.size(); i++) {
				int x = e.getPoint().x - this.janle.getDrawRect().shapeInfos.get(i).point.x;
				int y = e.getPoint().y - this.janle.getDrawRect().shapeInfos.get(i).point.y;
				;
				if (x >= 0 && x < this.janle.getDrawRect().shapeInfos.get(i).lens[1] & y >= 0
						&& y <= this.janle.getDrawRect().shapeInfos.get(i).lens[0]) {
					SetCouseState(0);
					this.janle.getDrawRect().shapeInfos.get(i).point.x = e.getPoint().x
							- janle.getDrawRect().shapeInfos.get(i).lens[1] / 2;
					this.janle.getDrawRect().shapeInfos.get(i).point.y = e.getPoint().y
							- janle.getDrawRect().shapeInfos.get(i).lens[0] / 2;
					return;
				}
			}
		}
	}

	/**
	 * @author seven �������λ��~ˢ�����ͼ��
	 */
	public void mouseMoved(MouseEvent e) {
		this.janle.setTitlePoint("����[" + e.getPoint().x + "," + e.getPoint().y + "]");
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 0 && e.getPoint().y < janle.getHeight()) {
			SetCouseState(3);
			return;
		}
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_MOVE) {
			for (int i = 0; i < this.janle.getDrawRect().shapeInfos.size(); i++) {
				int x = e.getPoint().x - this.janle.getDrawRect().shapeInfos.get(i).point.x;
				int y = e.getPoint().y - this.janle.getDrawRect().shapeInfos.get(i).point.y;
				if (x >= 0 && x < this.janle.getDrawRect().shapeInfos.get(i).lens[1] & y >= 0
						&& y <= this.janle.getDrawRect().shapeInfos.get(i).lens[0]) {
					SetCouseState(0);
					return;
				}
			}
		}
		SetCouseState(1);
	}

	/**
	 * �����ѷϣ��ɰ�ť����Ѿ�
	 * 
	 * @param e
	 */
	@Deprecated
	public void mouseClicked(MouseEvent e) {
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 0 && e.getPoint().y < 40)
			janle.setDrawState(MainJanle.DRAW_STATE_RECT);
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 40 && e.getPoint().y < 82)
			janle.setDrawState(MainJanle.DRAW_STATE_ORCL);
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 84 && e.getPoint().y < 124)
			janle.setDrawState(MainJanle.DRAW_STATE_LINE);
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 126 && e.getPoint().y < 146)
			janle.setDrawState(MainJanle.DRAW_STATE_MOVE);
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 148 && e.getPoint().y < 188)
			janle.Clearn();
		if (e.getPoint().x > 0 && e.getPoint().x < 75 && e.getPoint().y > 190 && e.getPoint().y < 230)
			janle.LineColor = MyColors.GetColor();
	}

	/**
	 * �������״̬
	 * 
	 * @param index
	 */
	private void SetCouseState(int index) {
		if (index == 3 && COUSE_STATE != 3) {
			COUSE_STATE = 3;
			janle.setCursor(Cursor.getDefaultCursor());
			return;
		}
		if (COUSE_STATE != index) {
			COUSE_STATE = index;
			janle.DrawMouse(COUSE_STATE);
		}

	}

	/**
	 * @author Seven
	 * @param e
	 * @param state
	 *            ��¼����Բ�εĿ�ʼ����
	 */
	public void drawORCL(MouseEvent e, int state) {
		if (this.janle.getDrawState() == MainJanle.DRAW_STATE_ORCL) {
			if (state == 1) {
				this.janle.getDrawOrcl().shapeInfos.add(new ShapeInfo(new Point(e.getPoint().x, e.getPoint().y + 20)));
				return;
			}
			if (state == 2) {
				int endY = this.janle.getDrawOrcl().shapeInfos
						.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).point.y - e.getPoint().y - 20;
				int endX = this.janle.getDrawOrcl().shapeInfos
						.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).point.x - e.getPoint().x;
				this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).lens[1] = Math
						.abs(endX);
				this.janle.getDrawOrcl().shapeInfos.get(this.janle.getDrawOrcl().shapeInfos.size() - 1).lens[0] = Math
						.abs(endY);
			}
		}
	}

	/**
	 * @author Seven
	 * @param e
	 * @param state
	 *            ��¼����ֱ�ߵĿ�ʼ����
	 */
	public void drawALine(MouseEvent e, int state) {
		if (state == 1) {
			this.janle.getDrawALine().shapeInfos.add(new ShapeInfo(new Point(e.getPoint().x, e.getPoint().y + 20)));
			return;
		}
		if (state == 2) {
			this.janle.getDrawALine().shapeInfos.get(this.janle.getDrawALine().shapeInfos.size() - 1).lens[1] = Math
					.abs(e.getPoint().x);
			this.janle.getDrawALine().shapeInfos.get(this.janle.getDrawALine().shapeInfos.size() - 1).lens[0] = Math
					.abs(e.getPoint().y + 20);
		}
	}
}
