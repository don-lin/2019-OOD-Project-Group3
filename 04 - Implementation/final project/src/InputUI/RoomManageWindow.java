package InputUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database.Room.Room;
import SystemController.SystemController;
import UIDataManager.RoomMapper;

public class RoomManageWindow{
	public int RoomNumber = 0;
	public static final int RoomManageWidth=350;
	
	/**
	 * the modify button show on the dialog
	 */
	class ManageButton implements ActionListener {
		JTextField number;
		JTextField type;
		JTextField bed;
		JTextField price;
		public ManageButton(JTextField number,JTextField type,JTextField bed,JTextField price) {
			this.number=number;
			this.type=type;
			this.bed=bed;
			this.price=price;
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				Room r=new Room(Integer.parseInt(type.getText()), Integer.parseInt(number.getText()), Integer.parseInt(bed.getText()), Integer.parseInt(price.getText()));
				RoomMapper.Modify(r);
				SystemController.refreshRoomButton();
			}
			catch(Exception e) {
				return;
			}
		}
	}

	/**
	 * if no room rumber is assigned, the default value is -1
	 */
	public RoomManageWindow() {
		RoomNumber = -1;
	}

	/**
	 * 
	 * @param number the room number of the room manage dialog
	 */
	public RoomManageWindow(int number) {
		RoomNumber = number;
	}
	
	/**
	 * start the room manage window and show a dialog
	 */

	public void run() {
		JFrame frame1 = new JFrame("Modify A Room");
		
		frame1.getContentPane().setLayout(null);
		frame1.setLocation(RoomManageWidth/2,(int)( RoomManageWidth*1.7));
		
		frame1.setSize(RoomManageWidth, RoomManageWidth);
		JButton button2 = new JButton("Modify");
		button2.setSize(300, 25);
		button2.setBorderPainted(false);
		button2.setLocation(10, 150);
		
		Room r=RoomMapper.get(RoomNumber);

		JTextField text1 = new JTextField(""+r.number);
		text1.setBounds(210, 10, 100, 30);
		JLabel l1 = new JLabel("room number(add if not exist): ");
		l1.setBounds(10, 10, 200, 30);
		
		JTextField text2 = new JTextField(""+r.statusType);
		text2.setBounds(210, 40, 100, 30);
		JLabel l2 = new JLabel("room type(-1 is delete): ");
		l2.setBounds(10, 40, 200, 30);
		
		JTextField text3 = new JTextField(""+r.bedNumber);
		text3.setBounds(210, 70, 100, 30);
		JLabel l3 = new JLabel("bed number: ");
		l3.setBounds(10, 70, 200, 30);
		
		JTextField text4 = new JTextField(""+r.price);
		text4.setBounds(210, 100, 100, 30);
		JLabel l4 = new JLabel("room price: ");
		l4.setBounds(10, 100, 200, 30);

		button2.addActionListener(new ManageButton(text1,text2,text3,text4));

		frame1.add(text1);
		frame1.add(text2);
		frame1.add(text3);
		frame1.add(text4);
		frame1.add(l1);
		frame1.add(l2);
		frame1.add(l3);
		frame1.add(l4);
		frame1.add(button2);

		frame1.setVisible(true);

	}
}
