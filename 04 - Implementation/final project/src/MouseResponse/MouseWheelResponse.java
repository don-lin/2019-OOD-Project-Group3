package MouseResponse;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import UIDataManager.PageManage;

public class MouseWheelResponse implements MouseWheelListener{

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation()==1) {
			PageManage.performUp();
		}
		if(e.getWheelRotation()==-1) {
			PageManage.performDown();
		}
		
	}

}
