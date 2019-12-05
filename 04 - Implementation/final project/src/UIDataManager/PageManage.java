package UIDataManager;

import SystemController.SystemController;
import UI.UserInterface;

public class PageManage {
	public static void performUp() {
    	if(SystemController.page<UserInterface.getList().size()/9)
    		SystemController.page++;
    	System.out.println("page="+SystemController.page);
    	SystemController.refreshRoomButton();
	}
	public static void performDown() {
    	if(SystemController.page>0)
    		SystemController.page--;
    	System.out.println("page="+SystemController.page);
    	SystemController.refreshRoomButton();
	}
}
