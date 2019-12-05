package UI;

import SystemController.SystemController;

public class AnimationThread extends Thread{
    /**
     * refresh the main window in a certain rate
     */
	public void run() {
		while(true) {
			SystemController.jjf.repaint();
			try {
			    /**
			     * sleep 10 ms until next refresh the main window
			     */
				super.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
