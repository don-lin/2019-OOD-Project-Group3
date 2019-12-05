import Database.Base.DatabaseCreator;
import Database.Query.Booking.BookingQuery;
import Database.Query.Customer.CustomerQuery;
import Database.Query.Room.RoomQuery;
import SystemController.SystemController;

public class Main {
    /**
     * @param args the arguments input from the system
     */
    public static void main(String[] args) {
	createDatabaseAll();
	SystemController.run();
    }
    /**
     * create three databases and insert some values to test it.
     */
    public static void createDatabaseAll() {
	DatabaseCreator.createAll();
	RoomQuery roomQuery=new RoomQuery();
	roomQuery.queryAllRooms();
	CustomerQuery customerQuery=new CustomerQuery();
	customerQuery.queryAllCustomers();
	BookingQuery bookingQuery=new BookingQuery();
	bookingQuery.queryAllBookings();
    }
}
