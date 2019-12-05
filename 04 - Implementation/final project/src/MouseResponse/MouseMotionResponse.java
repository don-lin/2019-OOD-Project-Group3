package MouseResponse;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import UI.UserInterface;

public class MouseMotionResponse implements MouseMotionListener{

    /**
     * this class will response the mose motion and dragged events
     */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		UserInterface.MouseX=arg0.getX();
		UserInterface.MouseY=arg0.getY();
		
		
	}

}
