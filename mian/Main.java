package mian;
/**
 * @author Seven007
 * @date 2014.5.25
 * ------------��������࣬����SwingС����
 */

import UI.MainAbout;
import UI.MainFrame;
import UI.MainJanle;
public class Main {
	
	public static void main(String[] args) {
		new MainAbout("load");
		new MainFrame(new MainJanle());
	}

}
