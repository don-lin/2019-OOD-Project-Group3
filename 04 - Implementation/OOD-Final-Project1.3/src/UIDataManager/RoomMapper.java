package UIDataManager;
import java.util.LinkedList;

import Database.Booking.Booking;
import Database.Query.Booking.BookingQuery;
import Database.Query.Room.RoomQuery;
import Database.Room.Room;

public class RoomMapper {
	public static LinkedList<Room> l=null;
	public static int date=5;
	
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
	}
	
	public static Room get(int number) {
		if(l==null)
			return null;
		for(int i=0;i<l.size();i++)
			if(l.get(i).number==number)
				return l.get(i);
		return null;
	}
	
	public static LinkedList<Room> get(){
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
	    //拿到所有的booking然后把有用的放到list里面
	}
	
	public static LinkedList<Room> getorigin(){
		if(l!=null)
			return l;
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
		return l;
	}
}
