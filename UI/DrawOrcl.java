package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import EnUtil.ShapeInfo;

public class DrawOrcl extends DrawsBase {
	public List<ShapeInfo> shapeInfos = new ArrayList<>();

	public DrawOrcl(MainJanle janle) {
		this.janle = janle;
	}

	@Override
	public void draw(Graphics g) {
		if (janle.getDrawState() == MainJanle.DRAW_STATE_ORCL)
			showColor(g);
		g.setColor(this.color);
		for (ShapeInfo info : shapeInfos)
			g.drawOval(info.point.x, info.point.y, info.lens[1], info.lens[0]);
	}

	@Override
	public void clearn() {
		this.shapeInfos.clear();

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
