package UI;

import SystemController.SystemController;

public class AnimationThread extends Thread{
	public void run() {
		while(true) {
			SystemController.jjf.repaint();
			try {
				super.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
