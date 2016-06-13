package EnUtil;

/**
 * @author Seven007
 * @date 2014.5.25
 * 一个记录图形的类，方便计算，现在仅仅记录矩形信息。
 * 
 */
import java.awt.Point;

public class ShapeInfo {
	private String ShapName;
	public Point point = null;
	public int[] lens = new int[2];

	public ShapeInfo(Point point) {
		this.point = point;
	}

	public String getShapName() {
		return ShapName;
	}
}
