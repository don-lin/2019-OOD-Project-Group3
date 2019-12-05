package UIDataManager;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;

import com.sun.org.apache.xml.internal.security.Init;

import Database.Booking.Booking;
import Database.Query.Booking.BookingQuery;
import Database.Query.Room.RoomQuery;
import Database.Room.Room;
import DateManager.GetCurrentDate;

public class RoomMapper {
    	public static HashMap<String, LinkedList<Room>> allRoomsStatus;
    
	public static LinkedList<Room> l=null;
	public static int date=5;
	
	public static boolean firstCreate=false;
	
	public static void Modify(Room r) {
		
		for(int i=0;i<l.size();i++) {
			if(l.get(i).number==r.number) {
				if(r.statusType<0||r.statusType>2)
					l.remove(i);
				else
					l.set(i, r);
				return;
			}
		}
		l.add(r);
		
		allRoomsStatus.put(GetCurrentDate.currentDate, l);
	}
	/**
	 * @param number room number
	 * @return a room object match the room number
	 */
	public static Room get(int number) {
		if(l==null)
			return null;
		for(int i=0;i<l.size();i++)
			if(l.get(i).number==number)
				return l.get(i);
		return null;
	}
	/**
	 * get the needed room from the database
	 * @return rooms list from the database
	 */
	public static LinkedList<Room> getFromDatabase(){
	    RoomQuery roomQuery=new RoomQuery();
		l=roomQuery.queryAllRooms();
		
		BookingQuery bookingQuery=new BookingQuery();
		LinkedList<Booking> bookings=bookingQuery.queryAllBookings();
		for(Booking booking : bookings) {
		    if(booking.Date==date) {
			get(booking.roomId).statusType=booking.checkIn;
		    }
		}
		return l;
	}
	
	public static void dealBooking() {
	    //get all bookings and put the needed into a list
	}
	
	public static void init(String startDate) {
	    createList();
	    allRoomsStatus=new HashMap<String, LinkedList<Room>>();
	    allRoomsStatus.put(startDate, l);
	}
	
	public static void createNewDate(String date) {
	    createList();
	    emptyList();
	    allRoomsStatus.put(date, l);
	}
	
	/**
	 * get a list of the date
	 * @param date the that will get
	 * @return a rooms list with status in the date
	 */
	
	public static LinkedList<Room> getList(String date) {
	    if(allRoomsStatus==null) {
		init(date);
	    }
	    if(allRoomsStatus.containsKey(date)) {
		l=allRoomsStatus.get(date);
		return l;
	    }
	    else {
		createNewDate(date);
		return getList(date);
	    }
	}
	/**
	 * get a rooms list of the current date
	 * @return rooms list
	 */
	public static LinkedList<Room> get(){
	    return getList(GetCurrentDate.currentDate);
	}
	
	/**
	 * create a new rooms list
	 */
	public static void createList(){
		l=new LinkedList<Room>();
		l.add(new Room(0,101,1,200));
		l.add(new Room(1,102,2,350));
		l.add(new Room(1,103,1,250));
		l.add(new Room(0,104,1,200));
		l.add(new Room(1,105,2,350));
		l.add(new Room(0,106,1,250));
		l.add(new Room(0,107,2,200));
		l.add(new Room(1,108,2,350));
		l.add(new Room(1,109,1,250));
		l.add(new Room(0,201,2,300));
		l.add(new Room(1,202,1,200));
		l.add(new Room(0,203,2,300));
		l.add(new Room(0,204,2,300));
		l.add(new Room(0,205,1,200));
		l.add(new Room(0,206,2,300));
		l.add(new Room(0,207,2,300));
		l.add(new Room(1,208,1,200));
		l.add(new Room(0,209,2,300));
		l.add(new Room(2,301,1,250));
		l.add(new Room(0,302,2,300));
		l.add(new Room(2,303,1,250));
	}
	/**
	 * set all rooms status in the list to empty
	 */
	public static void emptyList() {
	    for(int i=0;i<l.size();i++) {
		l.get(i).statusType=0;
	    }
	}
}
