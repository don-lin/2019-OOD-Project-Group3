package SystemController;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import Database.Room.Room;
import DateManager.GetCurrentDate;
import MainButtons.ShowAllRooms;
import MainButtons.ShowAvailableRooms;
import MainButtons.ShowBookedRooms;
import MainButtons.ShowPaidRooms;
import MainButtons.SortByNumber;
import MainButtons.SortByPrice;
import MainButtons.SortByType;
import MouseResponse.MouseMotionResponse;
import MouseResponse.MouseWheelResponse;
import MouseResponse.RoomButtonActionListener;
import UI.AnimationThread;
import UI.UserInterface;
import UIDataManager.PageManage;

public class SystemController {
	public static final int ScreenWidth=1000;
	public static final int ScreenHeight=800;
	public static UserInterface UI;
	public static JFrame jjf;
	public static JProgressBar bar;
	public static int page=0;
	public static JButton[] rooms;
	public static JButton dateButton;
	
	public static int[] roomStatues;
	
	/**
	 * 
	 * @param b button that will be set location
	 * @param x location x
	 * @param y location y
	 */
	public static void setButtonLocation(JButton b,double x,double y) {
		
		b.setBounds((int)(x*ScreenWidth), (int)(y*ScreenHeight), ScreenWidth/6, ScreenHeight/10);
		b.setBorderPainted(true);
	}
	/**
	 * notify the button's information shold be updated
	 */
	public static void refreshRoomButton() {
		LinkedList<Room> rl=UserInterface.getList();
    	for(int i=0;i<9;i++) {
    		int id=page*9+i;
    		if(id>=rl.size()) {
    			rooms[i].setBackground(new Color(1,(float)0.949,(float)0.8));
    			rooms[i].setText("NO ROOM");
    			rooms[i].setVisible(false);
    			continue;
    		}
    		rooms[i].setVisible(true);
    		String text=new String();
    		//text="<html>Room "+(100+i+page*9)+"<br>"+(roomStatues[100+i+page*9]==0?"Empty":"Booked"+"</html>");
    		text=rl.get(id).toHTMLString();
    		rooms[i].setText(text);
    		if(rl.get(id).statusType==0) {
    			rooms[i].setBackground(new Color((float)0.835,(float)0.9,(float)0.835));
    		}else
    			rooms[i].setBackground(new Color((float)0.972,(float)0.80,(float)0.80));
    	}
		bar.setValue((int)(page*1.0/(UserInterface.getList().size()/9)*100));
    	//jjf.repaint();
	}
	/**
	 * notify the sort type is changed
	 */
	public static void refreshSort() {
		Color y=new Color(1,(float)0.949,(float)0.8);
		Color b=new Color((float)0.854,(float)0.90,(float)0.98);
		SortByType.button.setBackground(y);
		SortByPrice.button.setBackground(y);
		SortByNumber.button.setBackground(y);
		switch (Room.compareType) {
		case 1:SortByType.button.setBackground(b);break;
		case 2:SortByPrice.button.setBackground(b);break;
		case 0:SortByNumber.button.setBackground(b);break;
		}
	}
	/**
	 * notify the show type is changed
	 */
	public static void refreshShow() {
		Color y=new Color(1,(float)0.949,(float)0.8);
		Color b=new Color((float)0.854,(float)0.90,(float)0.98);
		
		ShowAllRooms.button.setBackground(y);
		ShowAvailableRooms.button.setBackground(y);
		ShowBookedRooms.button.setBackground(y);
		ShowPaidRooms.button.setBackground(y);
		switch (UserInterface.showLevel) {
		case -1:ShowAllRooms.button.setBackground(b);break;
		case 0:ShowAvailableRooms.button.setBackground(b);break;
		case 1:ShowBookedRooms.button.setBackground(b);break;
		case 2:ShowPaidRooms.button.setBackground(b);break;
		}
	}
	/**
	 * show the main window
	 */
	public static void run() {

		JFrame jf = new JFrame("OOD");
		jjf=jf;
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(10, 10);
		jf.setSize(ScreenWidth, ScreenHeight);
		
		
		Container conn = jf.getContentPane();
		conn.setLayout(null);
		JLabel L1 = new JLabel("Hotel Management System");
		L1.setLocation(50,0);
		L1.setSize(300, 50);
		L1.setForeground(Color.white);
		conn.add(L1);

		bar = new JProgressBar();

		bar.setBounds((int)(1.0/12+1.0/6*1*ScreenWidth), (int)(1.0/12+1.0/10*3.5*ScreenHeight), ScreenWidth/2, ScreenHeight/40);
		conn.add(bar);

		SortByType.button = new JButton("Sort By Type");
		SortByType.button.setBackground(new Color(1,(float)0.949,(float)0.8));
		SortByType.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Sort By Type");
                Room.compareType=1;
                refreshSort();
                page=0;
                refreshRoomButton();
               // jjf.repaint();
            }           
        });
		setButtonLocation(SortByType.button,1.0/12,1.0/12);
		conn.add(SortByType.button);
		
		SortByPrice.button = new JButton("Sort By Price");
		SortByPrice.button.setBackground(new Color((float)0.854,(float)0.90,(float)0.98));
		SortByPrice.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Sort By Price");
                Room.compareType=2;
                refreshSort();
                page=0;
                refreshRoomButton();
                jjf.repaint();
            }           
        });
		setButtonLocation(SortByPrice.button,1.0/12+1.0/6,1.0/12);
		conn.add(SortByPrice.button);

		SortByNumber.button = new JButton("Sort By Room Number");
		SortByNumber.button.setBackground(new Color(1,(float)0.949,(float)0.8));
		SortByNumber.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Sort By Room Number");
                Room.compareType=0;
                refreshSort();
                page=0;
                refreshRoomButton();
                //jjf.repaint();
            }           
        });
		setButtonLocation(SortByNumber.button,1.0/12+1.0/6*2,1.0/12);
		conn.add(SortByNumber.button);


		JButton B4 = new JButton("Log In As Boss");
		B4.setBackground(new Color((float)0.972,(float)0.80,(float)0.80));
		B4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	JFrame frame1 = new JFrame("Input Your Password");
        		frame1.getContentPane().setLayout(null);
			frame1.setLocation(100,50);
			frame1.setSize(400,200);
			JButton button2 = new JButton("Log-in");
			button2.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent arg0) {
	            	UserInterface.showDebug=!UserInterface.showDebug;
	            	//Main.jjf.repaint();
	            }
				
			});
			button2.setSize(100, 25);
			button2.setBorderPainted(false);
			button2.setLocation(50,80 );
			
			JTextField text1=new JTextField();
			text1.setBounds(10, 10, 100, 30);

			frame1.add(button2);

			frame1.add(text1);
			frame1.setVisible(true);
            }           
        });
		setButtonLocation(B4,1.0/12+1.0/6*3,1.0/12);
		conn.add(B4);
		
		ShowAllRooms.button = new JButton("Show All Rooms");
		ShowAllRooms.button.setBackground(new Color((float)0.854,(float)0.90,(float)0.98));
		ShowAllRooms.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Show All Rooms");
                UserInterface.showLevel=-1;
                refreshShow();
                page=0;
                refreshRoomButton();
                //jjf.repaint();
            }           
        });
		setButtonLocation(ShowAllRooms.button,1.0/12+1.0/6*3,1.0/12+1.0/10*1.5);
		conn.add(ShowAllRooms.button);
		

		ShowPaidRooms.button = new JButton("Show Paid Rooms");
		ShowPaidRooms.button.setBackground(new Color(1,(float)0.949,(float)0.8));
		ShowPaidRooms.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Show Paid Rooms");
                UserInterface.showLevel=2;
                refreshShow();
                page=0;
                refreshRoomButton();
                //jjf.repaint();
            }           
        });
		setButtonLocation(ShowPaidRooms.button,1.0/12+1.0/6*2,1.0/12+1.0/10*1.5);
		conn.add(ShowPaidRooms.button);
		

		ShowBookedRooms.button = new JButton("Show Booked Rooms");
		ShowBookedRooms.button.setBackground(new Color(1,(float)0.949,(float)0.8));
		ShowBookedRooms.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Show Booked Rooms");
                UserInterface.showLevel=1;
                refreshShow();
                page=0;
                refreshRoomButton();
                //jjf.repaint();
            }           
        });
		setButtonLocation(ShowBookedRooms.button,1.0/12+1.0/6*1,1.0/12+1.0/10*1.5);
		conn.add(ShowBookedRooms.button);
		

		ShowAvailableRooms.button = new JButton("Show Available Rooms");
		ShowAvailableRooms.button.setBackground(new Color(1,(float)0.949,(float)0.8));
		ShowAvailableRooms.button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Show Available Rooms");
                UserInterface.showLevel=0;
                refreshShow();
                page=0;
                refreshRoomButton();
                //jjf.repaint();
            }           
        });
		setButtonLocation(ShowAvailableRooms.button,1.0/12+1.0/6*0,1.0/12+1.0/10*1.5);
		conn.add(ShowAvailableRooms.button);
	
		rooms=new JButton[9];
		roomStatues=new int[1000];
		for(int i=0;i<roomStatues.length;i++) {
			roomStatues[i]=0;
		}
		for(int i=0;i<9;i++) {

		rooms[i] = new JButton("Room "+(100+i+page*9));
		rooms[i].setBackground(new Color((float)0.835,(float)0.9,(float)0.835));
		rooms[i].addActionListener(new RoomButtonActionListener(i));
		setButtonLocation(rooms[i],1.0/6+1.0/6*(i%3),1.0/12+1.0/10*(3+i/3));
		conn.add(rooms[i]);
		}
    	refreshRoomButton();
		


		JButton B9 = new JButton("UP");
		B9.setBackground(new Color(1,(float)0.949,(float)0.8));
		B9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	PageManage.performUp();
            }
        });
		setButtonLocation(B9,1.0/6+1.0/6*3.5,1.0/12+1.0/10*3.5);
		conn.add(B9);
		

		JButton B10 = new JButton("DOWN");
		B10.setBackground(new Color(1,(float)0.949,(float)0.8));
		B10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	PageManage.performDown();
            }           
        });
		setButtonLocation(B10,1.0/6+1.0/6*3.5,1.0/12+1.0/10*4.5);
		conn.add(B10);
		
		JButton B11 = new JButton("Previous Day");
		B11.setBackground(new Color(1,(float)0.949,(float)0.8));
		
		B11.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	GetCurrentDate.minusOne();
	            	dateButton.setText(GetCurrentDate.currentDate);
	                refreshSort();
	                page=0;
	                refreshRoomButton();
	                jjf.repaint();
	            }
	        });
		setButtonLocation(B11, 1.0/12+1.0/12, 1.0/12+1.0/10*5+1.0/10*1.5);
		conn.add(B11);
		
		JButton B12 = new JButton("Next Day");
		B12.setBackground(new Color(1,(float)0.949,(float)0.8));
		B12.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	GetCurrentDate.addOne();
	            	dateButton.setText(GetCurrentDate.currentDate);
	                refreshSort();
	                page=0;
	                refreshRoomButton();
	                jjf.repaint();
	            }
	        });
		setButtonLocation(B12, 1.0/12+1.0/12+1.0/6*2, 1.0/12+1.0/10*5+1.0/10*1.5);
		//B12.setPreferredSize(new Dimension(20,20)); 
		conn.add(B12);
	
		
		dateButton = new JButton(GetCurrentDate.currentDate);
		dateButton.setBackground(new Color((float)0.854,(float)0.90,(float)0.98));
		setButtonLocation(dateButton, 1.0/12+1.0/12+1.0/6, 1.0/12+1.0/10*5+1.0/10*1.5);
		conn.add(dateButton);
		

		UI = new UserInterface();
		UI.setBounds(0, 0, ScreenWidth, ScreenHeight);
		
		conn.add(UI);
		AnimationThread a=new AnimationThread();
		a.start();
		
		jf.setVisible(true);//set window visible
		jf.addMouseWheelListener(new MouseWheelResponse());
		conn.addMouseMotionListener(new MouseMotionResponse());
		conn.setBackground(Color.white);
		jf.setBackground(Color.white);
	}

}
