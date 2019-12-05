import Database.Base.DatabaseCreator;
import Database.Query.Booking.BookingQuery;
import Database.Query.Customer.CustomerQuery;
import Database.Query.Room.RoomQuery;
import SystemController.SystemController;

public class Main {
    public static void main(String[] args) {
	DatabaseCreator.createAll();
	RoomQuery roomQuery=new RoomQuery();
	roomQuery.queryAllRooms();
	CustomerQuery customerQuery=new CustomerQuery();
	customerQuery.queryAllCustomers();
	BookingQuery bookingQuery=new BookingQuery();
	bookingQuery.queryAllBookings();
	SystemController.run();
    }
}
