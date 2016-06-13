/**
 * @author Seven007
 * @date 2014.5.25
 * 画面布局主体。
 */
package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

import EnUtil.ListMouse;
import EnUtil.MyColors;
import EnUtil.SaveImg;

public class MainJanle extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * 画线状态
	 */
	public static final int DRAW_STATE_LINE = 0;
	/**
	 * 画方块状态
	 */
	public static final int DRAW_STATE_RECT = 1;
	/**
	 * 画圆状态
	 */
	public static final int DRAW_STATE_ORCL = 2;
	/**
	 * 移动控件状态
	 */
	public static final int DRAW_STATE_MOVE = 3;
	/**
	 * 画直线
	 */
	public static final int DRAW_STATE_FLINE = 4;

	public static HashMap<String, Integer> hashMap = new HashMap<>(32);
	static {
		try {
			hashMap.put("铅笔", MainJanle.DRAW_STATE_LINE);
			hashMap.put("直线", MainJanle.DRAW_STATE_FLINE);
			hashMap.put("画块", MainJanle.DRAW_STATE_RECT);
			hashMap.put("画圆", MainJanle.DRAW_STATE_ORCL);
			hashMap.put("拖动", MainJanle.DRAW_STATE_MOVE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int drawState = 0;
	private String titlePoint = "";
	private MainAbout about;
	private String drawStateShows[] = new String[] { "铅笔ing", "画块ing", "画圆ing", "控件ing", "直线ing", };
	public String drawStateShow = drawStateShows[drawState];

	private DrawLine drawLine = null;
	private DrawRect drawRect = null;
	private DrawOrcl drawOrcl = null;
	private DrawALine drawALine = null;
	public Color LineColor = MyColors.GetColor();
	protected boolean clearn = true;
	private ArrayList<DrawsBase> draw = new ArrayList<DrawsBase>();

	public MainJanle() {
		this.about = new MainAbout();
		this.setName("main");
		this.addMouseListener(new ListMouse(this));
		this.addMouseMotionListener(new ListMouse(this));
		draw.add(drawLine = new DrawLine(this));
		draw.add(drawRect = new DrawRect(this));
		draw.add(drawOrcl = new DrawOrcl(this));
		draw.add(drawALine = new DrawALine(this));
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(50);
					} catch (Exception e) {
					}
					repaint();
				}
			}
		}).start();

	}

	public void Clearn() {
		this.clearn = true;
	}

	/**
	 * 获取鼠标图标状态
	 * 
	 * @param feel
	 */
	public void DrawMouse(int feel) {
		Image img = feel == 0 ? MyColors.GetImg(0) : MyColors.GetImg(1);
		Cursor cu = Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(5, 5), "stick");
		this.setCursor(cu);

	}

	/**
	 * @author Seven repain自己调动
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.clearRect(0, 0, this.getSize().width, this.getSize().height);
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);

		for (DrawsBase drs : draw)
			drs.draw(g);
		if (clearn) {
			g.clearRect(0, 0, 1000, 1000);
			for (DrawsBase drs : draw) {
				drs.clearn();
			}
			clearn = false;
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		g.drawString(titlePoint, 70, this.getSize().height - this.getSize().height + 15);
		g.setColor(Color.darkGray);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		g.drawString("状态:" + drawStateShow, 70, this.getSize().height - this.getSize().height + 35);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 18));
		g.drawString("小提示:可以拖动生成的图形哦", 75, this.getSize().height - 5);
		this.requestFocus();

	}

	public DrawLine getDrawLine() {
		return drawLine;
	}

	public DrawRect getDrawRect() {
		return drawRect;
	}

	public int getDrawState() {
		return drawState;
	}

	public void setDrawState(int drawState) {
		this.drawState = drawState;
		SetDrawState(drawState);

	}

	public ArrayList<DrawsBase> getDraw() {
		return draw;
	}

	public DrawOrcl getDrawOrcl() {
		return drawOrcl;
	}

	public void setDrawOrcl(DrawOrcl drawOrcl) {
		this.drawOrcl = drawOrcl;
		SetDrawState(drawState);
	}

	public DrawALine getDrawALine() {
		return drawALine;
	}

	public void setDrawALine(DrawALine drawALine) {
		this.drawALine = drawALine;
		SetDrawState(drawState);
	}

	public String getTitlePoint() {
		return titlePoint;
	}

	public void setTitlePoint(String titlePoint) {
		this.titlePoint = titlePoint;
	}

	public void saveImg() {
		SaveImg.createImage(this);
		;

	}

	public void showAbout() {
		this.about.setVisible(true);

	}

	public void SetDrawState(int index) {
		this.drawStateShow = this.drawStateShows[index];
	}

	public void setDrowColor() {
		draw.get(drawState == 4 ? 3 : drawState).setMyColor(JColorChooser.showDialog(null, "请选择你喜欢的颜色", null));
	}
}
