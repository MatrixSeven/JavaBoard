package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import EnUtil.ShapeInfo;

public class DrawALine extends DrawsBase {

	public List<ShapeInfo> shapeInfos = new ArrayList<>();

	public DrawALine(MainJanle janle) {
		this.janle = janle;
	}

	@Override
	public void draw(Graphics g) {
		if (janle.getDrawState() == MainJanle.DRAW_STATE_FLINE)
			showColor(g);
		for (ShapeInfo orcl : shapeInfos)
			g.drawLine(orcl.point.x, orcl.point.y, orcl.lens[1], orcl.lens[0]);

	}

	@Override
	public void clearn() {
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
