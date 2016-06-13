package EnUtil;

/**
 * @author Seven
 * @date 2014.6.7
 * 保存所画的图片
 * BufferedImage图片缓冲
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import UI.MainJanle;

public class SaveImg {

	public static void createImage(MainJanle mainJanle) {
		String name = JOptionPane.showInputDialog(null, "请输入图片名：", "提示Seven", 3);
		if (name == null || name.equals("")) {
			JOptionPane.showMessageDialog(null, "保存失败", "提示", 2);
			return;
		}
		int totalWidth = 945;
		int totalHeight = 450;
		BufferedImage panelImage = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2D = (Graphics2D) panelImage.createGraphics();
		g2D.setColor(Color.WHITE);
		g2D.fillRect(61, 0, totalWidth, totalHeight);
		g2D.translate(0, 0);
		mainJanle.paint(g2D);
		g2D.dispose();
		try {
			ImageIO.write(panelImage, "png", new File("d:/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		JOptionPane.showMessageDialog(null, "已经保存到D：\\" + name + ".png", "提示", 1);
	}
}
