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

			me.put("����", cls.getDeclaredMethod("Clearn", new Class[] {}));
			me.put("��ɫ", cls.getDeclaredMethod("setDrowColor", new Class[] {}));
			me.put("����", cls.getDeclaredMethod("saveImg", new Class[] {}));
			me.put("����", cls.getDeclaredMethod("showAbout", new Class[] {}));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ťʱ�����
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
		// if(comm.equals("����"))
		// janle.Clearn();
		// if(comm.equals("��ɫ"))
		// janle.setDrowColor();
		// if(comm.equals("��ɫ"))
		// for(DrawsBase drs:janle.getDraw())
		// drs.setMyColor(MyColors.GetColor());
		// if(comm.equals("����"))
		// janle.saveImg();
		// if(comm.equals("����"))
		// janle.showAbout();

	}

}
