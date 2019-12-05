package Database.Query.Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Database.Booking.Booking;

public class BookingQuery {
    
    /**
     * @return all bookings query from the database in a LinkedList data type
     */
    public LinkedList<Booking> queryAllBookings() {
	LinkedList<Booking> bookings=new LinkedList<Booking>();
	    try {
		String url = "jdbc:sqlite:./bs.db";
		Connection con = DriverManager.getConnection(url);
	      Statement stmt = con.createStatement();

	      ResultSet rset = stmt.executeQuery("SELECT * FROM Booking");
	      while (rset.next()) {
		  Booking booking=new Booking();
		  booking.bookingId=rset.getInt(1);
		  booking.roomId=rset.getInt(2);
		  booking.checkIn=rset.getInt(3);
		  booking.paid=rset.getInt(4);
		  booking.customerId=rset.getInt(5);
		  booking.Date=rset.getInt(6);
		  bookings.add(booking);
	      }
	      rset.close();
	      stmt.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return bookings;
	  }
    /**
     * insert one booking into the database
     * @param booking the booking that will be inserted into the database
     */
    public void InsertBooking(Booking booking) {
        String sql = "INSERT INTO Booking VALUES (null,"+booking.roomId+","+booking.checkIn+","+booking.paid+","+booking.customerId+","+booking.Date+") ;";
        executeStatement(sql);
    }

    /**
     * execute a single sql query
     * @param sql the sql query that will be executed
     */
    public void executeStatement(String sql) {
	      System.out.println(sql);
	      String url = "jdbc:sqlite:./bs.db";
	      try (Connection conn = DriverManager.getConnection(url)) {
	        if (conn != null) {
	          Statement stmt = conn.createStatement();
	          stmt.execute(sql);
	        }
	      } catch (SQLException e) {
	        System.err.println("fail to execute "+sql);
	        e.printStackTrace();
	      }
	  }

}
