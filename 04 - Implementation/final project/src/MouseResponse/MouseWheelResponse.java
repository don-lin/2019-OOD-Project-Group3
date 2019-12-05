package MouseResponse;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import UIDataManager.PageManage;

public class MouseWheelResponse implements MouseWheelListener{
    /**
     * this class will response the mose wheel events
     */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	    /**
	     * page up if wheel up
	     * page down if wheel down
	     */
		if(e.getWheelRotation()==1) {
			PageManage.performUp();
		}
		if(e.getWheelRotation()==-1) {
			PageManage.performDown();
		}
		
	}

}
