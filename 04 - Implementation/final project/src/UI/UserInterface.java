package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import Database.Room.Room;
import SystemController.SystemController;
import UIDataManager.RoomMapper;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInterface extends JPanel{

	public static boolean showDebug=false;
	public static int MouseX,MouseY;
	
	public static Image[] backgrounds=new Image[11];
	public static int count=0;
	public static int order=1;
	
	/**
	 * initialize the userinterface and red the images from the local image files
	 */
	public UserInterface() {
		for(int i=0;i<backgrounds.length;i++) {
			try {
				backgrounds[i]=ImageIO.read(new File("img/background"+i+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param g graphics
	 * @param text string that will be drawn
	 * @param x location x of the drawn
	 * @param y lcoation y of the drawn
	 */
	
	private void drawString(Graphics g, String text, int x, int y) {
		if(!showDebug)
			return;
	    for (String line : text.split("\n"))
	      g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
	public static int showLevel=-1;
	
	/**
	 * @return rooms that should be drawn on the screen
	 */
	public static LinkedList<Room> getList(){
		LinkedList<Room> l1=RoomMapper.get();
		LinkedList<Room> l2=new LinkedList<Room>();
		String paintString=new String();
		for(Room r:l1) {
			if(showLevel==-1) {
				l2.add(r);
			}else {
				if(r.statusType==showLevel)
					l2.add(r);
			}
		}
		Collections.sort(l2);
		return l2;
	}
	
	/**
	 * paint the screen
	 */
	public void paintComponent(Graphics g) // draw graphics in the panel
	{
		count+=order;
			g.drawImage(backgrounds[count/5], 0, 0, SystemController.ScreenWidth, SystemController.ScreenHeight, this);
		if(count > (backgrounds.length-1)*5-2||count<=0)
			order=-order;
		//draw the position of the mouse
		g.setColor(Color.yellow);
		g.drawRect(MouseX-20, MouseY, 20, 20);
		g.drawOval(MouseX, MouseY+20, 20, 20);
		g.drawOval(MouseX, MouseY-20, 20, 20);
		g.drawRect(MouseX+20, MouseY, 20, 20);
		
		
		LinkedList<Room> l1=RoomMapper.get();
		LinkedList<Room> l2=new LinkedList<Room>();
		String paintString=new String();
		for(Room r:l1) {
			if(showLevel==-1) {
				l2.add(r);
			}else {
				if(r.statusType==showLevel)
					l2.add(r);
			}
		}

		Collections.sort(l2);
		for(Room r : l2) {
			paintString+=r.toString()+"\n";
		}
		drawString(g,paintString, 20, 550);
	}

}