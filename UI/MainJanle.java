/**
 * @author Seven007
 * @date 2014.5.25
 * ���沼�����塣
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
	 * ����״̬
	 */
	public static final int DRAW_STATE_LINE = 0;
	/**
	 * ������״̬
	 */
	public static final int DRAW_STATE_RECT = 1;
	/**
	 * ��Բ״̬
	 */
	public static final int DRAW_STATE_ORCL = 2;
	/**
	 * �ƶ��ؼ�״̬
	 */
	public static final int DRAW_STATE_MOVE = 3;
	/**
	 * ��ֱ��
	 */
	public static final int DRAW_STATE_FLINE = 4;

	public static HashMap<String, Integer> hashMap = new HashMap<>(32);
	static {
		try {
			hashMap.put("Ǧ��", MainJanle.DRAW_STATE_LINE);
			hashMap.put("ֱ��", MainJanle.DRAW_STATE_FLINE);
			hashMap.put("����", MainJanle.DRAW_STATE_RECT);
			hashMap.put("��Բ", MainJanle.DRAW_STATE_ORCL);
			hashMap.put("�϶�", MainJanle.DRAW_STATE_MOVE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int drawState = 0;
	private String titlePoint = "";
	private MainAbout about;
	private String drawStateShows[] = new String[] { "Ǧ��ing", "����ing", "��Բing", "�ؼ�ing", "ֱ��ing", };
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
	 * ��ȡ���ͼ��״̬
	 * 
	 * @param feel
	 */
	public void DrawMouse(int feel) {
		Image img = feel == 0 ? MyColors.GetImg(0) : MyColors.GetImg(1);
		Cursor cu = Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(5, 5), "stick");
		this.setCursor(cu);

	}

	/**
	 * @author Seven repain�Լ�����
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
		g.drawString("״̬:" + drawStateShow, 70, this.getSize().height - this.getSize().height + 35);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 18));
		g.drawString("С��ʾ:�����϶����ɵ�ͼ��Ŷ", 75, this.getSize().height - 5);
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
		draw.get(drawState == 4 ? 3 : drawState).setMyColor(JColorChooser.showDialog(null, "��ѡ����ϲ������ɫ", null));
	}
}
