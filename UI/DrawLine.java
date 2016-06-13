/**
 *@author Seven007
 *@date 2014.5.25
 *�̳г�����DrawsBase��ʵ�ֳ��󷽷�������ˢ�½��棬�Ժ�jpanle�ĸ��º��߼�����
 *	�ֱ𴴽�DrawsBase�����࣬��ʵ��draw��ʹ�����߼����룬�����Ժ���£�����
 */
package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawLine extends DrawsBase {
	private List<Point> points = new ArrayList<Point>();

	public DrawLine(MainJanle janle) {
		this.janle = janle;
	}

	@Override
	public void draw(Graphics g) {
		if (janle.getDrawState() == MainJanle.DRAW_STATE_LINE)
			showColor(g);
		Graphics2D graphics2d = (Graphics2D) g;
		ArrayList<Point> points = (ArrayList<Point>) this.points;

		/**
		 * ����ʵ���˼ٻ��档 ��ʵ���ﲢû�л��档����ʹ�����껭����һ��������л��ߡ�˼��������ȡ����
		 * ��x����y���볬��30px��ʱ�򣬻�һ���µ����� ������ôд��ȫ��Ϊ���ܹ��϶����ɵ�ͼ��
		 * ����ÿһ��repaint��Ҫ���һ�½��棬����ֻ�ܷŵ�list����
		 */
		g.setColor(color);
		for (int i = 0; i < points.size(); i++) {
			if (i + 2 < points.size()) {
				if (Math.abs((points.get(i).x - points.get(i + 1).x)) > 30
						|| Math.abs(points.get(i).y - points.get(1 + i).y) > 30)
					graphics2d.drawLine(points.get(i + 1).x, points.get(i + 1).y + 18, points.get(i + 2).x,
							points.get(i + 2).y + 18);
				else
					graphics2d.drawLine(points.get(i).x, points.get(i).y + 18, points.get(i + 1).x,
							points.get(i + 1).y + 18);
			}
		}

	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public void clearn() {
		points.clear();
	}

	@Override
	public void setMyColor(Color color) {
		this.color = color;

	}

	@Override
	public void drawPoint(MouseEvent e, int state) {
		// TODO Auto-generated method stub

	}

}
