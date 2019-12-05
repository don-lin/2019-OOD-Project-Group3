package MouseResponse;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Database.Room.Room;
import InputUI.RoomManageWindow;
import SystemController.SystemController;
import UI.UserInterface;

/**
 * 
 * @author donlin
 * response when mouse click one room
 */
public class RoomButtonActionListener implements ActionListener{
	public int id;
	public RoomButtonActionListener(int i) {
		id=i;
	}
	/**
	 * when mouse click a room, show a window to edit the room information
	 */
    public void actionPerformed(ActionEvent arg0) {

		int listID=SystemController.page*9+id;
		
		LinkedList<Room> rl=UserInterface.getList();
		if(rl.size()>listID) {
			//rl.get(listID).type=rl.get(listID).type==0?1:0;
			
			
		RoomManageWindow rmw=new RoomManageWindow(rl.get(listID).number);
		rmw.run();
		
			System.out.print("change");
		}
    	SystemController.refreshRoomButton();
    }

}
