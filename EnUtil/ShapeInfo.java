package EnUtil;

/**
 * @author Seven007
 * @date 2014.5.25
 * һ����¼ͼ�ε��࣬������㣬���ڽ�����¼������Ϣ��
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
