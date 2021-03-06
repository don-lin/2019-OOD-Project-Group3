package Database.Query.Room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Database.Room.Room;

public class RoomQuery {
    /**
     * @return all rooms query from the database in a LinkedList data type
     */
    public LinkedList<Room> queryAllRooms() {
	LinkedList<Room> rooms=new LinkedList<Room>();
	    try {
		String url = "jdbc:sqlite:./bs.db";
		Connection con = DriverManager.getConnection(url);
	      Statement stmt = con.createStatement();

	      ResultSet rset = stmt.executeQuery("SELECT * FROM Room");
	      while (rset.next()) {
		  Room room=new Room(0,rset.getInt(1),rset.getInt(2),rset.getInt(3));
//		  System.out.println(room);
		  rooms.add(room);
	      }
	      rset.close();
	      stmt.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return rooms;
	  }
    /**
     * insert one room into the database
     * @param room the room that will be inserted into the database
     */
    public void InsertRoom(Room room) {
        String sql = "INSERT INTO Room VALUES ("+room.number+","+room.bedNumber+","+room.price+") ;";
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
