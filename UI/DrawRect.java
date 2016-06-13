package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import EnUtil.ShapeInfo;

public class DrawRect extends DrawsBase {
	// ������¼ͼ�Σ����顣Բ�ε����ݣ�Ϊ�϶���Щͼ��������
	public ArrayList<ShapeInfo> shapeInfos = new ArrayList<ShapeInfo>();

	public DrawRect(MainJanle janle) {
		this.janle = janle;
	}

	@Override
	public void draw(Graphics g) {
		if (janle.getDrawState() == MainJanle.DRAW_STATE_RECT)
			showColor(g);
		g.setColor(color);
		for (ShapeInfo s : shapeInfos) {
			g.drawRect(s.point.x, s.point.y, s.lens[1], s.lens[0]);
		}

	}

	@Override
	public void clearn() {
		// TODO Auto-generated method stub
		shapeInfos.clear();

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
