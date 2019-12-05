package Database.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    /**
     * create three databases and insert some values to test it.
     */
  public static void createAll() {
        String sql = "CREATE TABLE  IF NOT EXISTS Room (\r\n" + 
            "       RoomID      INT PRIMARY KEY,\r\n" + 
            "       Type      INT NOT NULL,\r\n" + 
            "       Price      INT NOT NULL\r\n" + 
            ") ;";
        executeStatement(sql);
        sql = "INSERT INTO Room VALUES (202,1,350) ;";
        executeStatement(sql);
        
        sql = "CREATE TABLE  IF NOT EXISTS Customer (\r\n" + 
            "       CustomerId    AUTO_INCREMENT  INT PRIMARY KEY,\r\n" + 
            "       Name      Varchar(100),\r\n" + 
            "       Telphone      Varchar(100),\r\n" + 
            "       VIPLevel      INT,\r\n" + 
            "       Description      Varchar(100)\r\n" + 
            ") ;";
        executeStatement(sql);
        sql = "INSERT INTO Customer VALUES (null,'donglin','13888888888',2,'student') ;";
        executeStatement(sql);
        
        sql = "CREATE TABLE  IF NOT EXISTS Booking (\r\n" + 
                "       BookingId    AUTO_INCREMENT  INT PRIMARY KEY,\r\n" + 
                "       RoomId      INT,\r\n" + 
                "       CheckIn      INT NOT NULL,\r\n" + 
                "       Paid      INT NOT NULL,\r\n" + 
                "       CustomerId      INT,\r\n" + 
                "       Date      INT NOT NULL,\r\n" +
                "	FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId),\r\n"+
                "	FOREIGN KEY (RoomID) REFERENCES Room(RoomID)\r\n"+
                ") ;";
            executeStatement(sql);
            sql = "INSERT INTO Booking VALUES (null,202,2,3,4,5) ;";
            executeStatement(sql);
  }
  /**
   * execute a single sql query
   * @param sql the sql query that will be executed
   */
  public static void executeStatement(String sql) {
      System.out.println(sql);
      String url = "jdbc:sqlite:./bs.db";
      try (Connection conn = DriverManager.getConnection(url)) {
        if (conn != null) {
          Statement stmt = conn.createStatement();
          stmt.execute(sql);
        }
      } catch (SQLException e) {
        //System.err.println("fail to execute "+sql);
        //e.printStackTrace();
      }
  }
  /**
   * not implemented
   * @param RoomId
   * @param RoomType
   * @param RoomPrice
   */
  public static void insertRoom(int RoomId,int RoomType,int RoomPrice) {
      
  }
}
