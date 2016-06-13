package EnUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.HashMap;

import UI.MainJanle;

public class ListButton implements ActionListener {

	private static HashMap<String, Method> me = new HashMap<>();

	static {
		Class<?> cls = MainJanle.class;
		try {

			me.put("清屏", cls.getDeclaredMethod("Clearn", new Class[] {}));
			me.put("改色", cls.getDeclaredMethod("setDrowColor", new Class[] {}));
			me.put("保存", cls.getDeclaredMethod("saveImg", new Class[] {}));
			me.put("关于", cls.getDeclaredMethod("showAbout", new Class[] {}));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按钮时间监听
	 */
	private MainJanle janle;

	public ListButton(MainJanle janle) {
		this.janle = janle;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		try {

			if (MainJanle.hashMap.containsKey(comm))
				janle.setDrawState(MainJanle.hashMap.get(comm));

			if (ListButton.me.containsKey(comm))
				ListButton.me.get(comm).invoke(janle, new Object[] {});

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// if(comm.equals("清屏"))
		// janle.Clearn();
		// if(comm.equals("改色"))
		// janle.setDrowColor();
		// if(comm.equals("改色"))
		// for(DrawsBase drs:janle.getDraw())
		// drs.setMyColor(MyColors.GetColor());
		// if(comm.equals("保存"))
		// janle.saveImg();
		// if(comm.equals("关于"))
		// janle.showAbout();

	}

}
