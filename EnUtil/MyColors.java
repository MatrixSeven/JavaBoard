/***
 * @author Seven007
 * @date 2014.5.25
 * 一个记录颜色，图片等各类资源的final类。
 * 全部为静态变量，资源索引类
 */
package EnUtil;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

public final class MyColors {

	public final static Color[] COLORS;
	public static Image IMAGE[] = null;
	public static ImageIcon IMG_BUTTON = new ImageIcon(MyColors.class.getResource("/img/b1.jpg"));
	public static ImageIcon IMG_BUTTON_DOWN = new ImageIcon(MyColors.class.getResource("/img/b2.jpg"));
	public static ImageIcon IMG_ICON = new ImageIcon(MyColors.class.getResource("/img/icon.png"));
	public static ImageIcon IMG_ABOUT = new ImageIcon(MyColors.class.getResource("/img/about.png"));

	static {
		COLORS = new Color[] { Color.black, Color.blue, Color.cyan, Color.DARK_GRAY, Color.gray, Color.green,
				Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow, };
		IMAGE = new Image[] { Toolkit.getDefaultToolkit().getImage(MyColors.class.getResource("/img/0.png")),
				Toolkit.getDefaultToolkit().getImage(MyColors.class.getResource("/img/1.png")) };
	};

	public static Color GetColor() {
		return COLORS[new Random().nextInt(COLORS.length)];

	}

	public static Image GetImg(int index) {
		return IMAGE[index];
	}
}
