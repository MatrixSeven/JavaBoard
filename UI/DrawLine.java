/**
 *@author Seven007
 *@date 2014.5.25
 *继承抽象类DrawsBase并实现抽象方法。方便刷新界面，以后jpanle的更新和逻辑可以
 *	分别创建DrawsBase的子类，来实现draw，使界面逻辑分离，便于以后更新，管理
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
		 * 这里实现了假缓存。 其实这里并没有缓存。而是使用坐标画和下一个坐标进行画线。思想类似于取极限
		 * 当x或者y距离超过30px的时候，画一个新的线条 这里这么写完全是为了能够拖动生成的图像。
		 * 由于每一次repaint都要清空一下界面，所以只能放到list里面
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
