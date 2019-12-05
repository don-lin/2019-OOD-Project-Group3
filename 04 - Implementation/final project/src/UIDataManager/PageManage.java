package UIDataManager;

import SystemController.SystemController;
import UI.UserInterface;

public class PageManage {
    /**
     * manage the rooms page that should be shown on the screen
     */
    /**
     * page up and notify the observer
     */
	public static void performUp() {
    	if(SystemController.page<UserInterface.getList().size()/9)
    		SystemController.page++;
    	System.out.println("page="+SystemController.page);
    	SystemController.refreshRoomButton();
	}
	/**
	 * page down and notify the observer
	 */
	public static void performDown() {
    	if(SystemController.page>0)
    		SystemController.page--;
    	System.out.println("page="+SystemController.page);
    	SystemController.refreshRoomButton();
	}
}
