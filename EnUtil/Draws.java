package EnUtil;
/**
 * @author Seven
 * @date 2014.6.7
 * 代码重构，这里写得好臃肿、
 * 但是已经想到了一种重构的方法，可以用一个方法来完成
 * 画圆，直线，方块的方法
 * 但是觉得好无聊，留给以后把。
 * 
 *2014.6.9再次重构。本类所有方法都将由DrawBase子类实现
 *修改main~反射生成实例~读取xml
 *尝试实现插件模式
 */

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import UI.MainJanle;

public class Draws {

	private MainJanle janle;
	/**
	 * 鼠标状态
	 */
	public static int COUSE_STATE = 0;

	public Draws(MainJanle janle) {
		this.janle = janle;
	}

	/**
	 * @author Seven 名字为drawline，但是远不止 想不到合适的名字 里面完成了动态事实画图刷新坐标的效果
	 * @param e
	 */
	public void drawLine(MouseEvent e) {
		this.janle.setTitlePoint("坐标[" + e.getPoint().x + "," + e.getPoint().y + "]");
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
	 *            完成在画图的时候实时刷新各种坐标，动态画图
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
	 *            完成在画图的时候实时刷新各种坐标，动态画图
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
	 *            完成在画图的时候实时刷新各种坐标，动态画图
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
	 *            记录方块图形的开始坐标
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
	 * @author Seven 移动方块，以后添加图形都在这个方法里面判断
	 * @param e
	 */
	public void drawMove(MouseEvent e) {
		this.janle.setTitlePoint("坐标[" + e.getPoint().x + "," + e.getPoint().y + "]");
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
	 * @author seven 监听鼠标位置~刷新鼠标图标
	 */
	public void mouseMoved(MouseEvent e) {
		this.janle.setTitlePoint("坐标[" + e.getPoint().x + "," + e.getPoint().y + "]");
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
	 * 方法已废，由按钮完成已经
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
	 * 设置鼠标状态
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
	 *            记录方块圆形的开始坐标
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
	 *            记录方块直线的开始坐标
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
