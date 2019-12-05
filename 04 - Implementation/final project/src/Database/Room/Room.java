package Database.Room;

public class Room implements Comparable<Room>{
	public static int compareType=0;
	public int statusType;
	public int number;
	public int bedNumber;
	public int price;
	
	/**
	 * 
	 * @param statusType room status
	 * @param number room number
	 * @param bedNumber how many bed the room have
	 * @param price the price of the room
	 */
	
	public Room(int statusType,int number,int bedNumber,int price) {
		this.statusType=statusType;
		this.number=number;
		this.bedNumber=bedNumber;
		this.price=price;
	}
	
	/**
	 * convert the room to string
	 * @return a string
	 */
	@Override
	public String toString() {
		String result=new String();
		switch(statusType) {
		case 0:result="Empty Room";break;
		case 1:result="Already Booked";break;
		case 2:result="Already paid";break;
		}
		
		result="Room Number: "+number+","+result+" have "+bedNumber+" bed, price is: "+price+" yuan";
		
		return result;
	}
	/**
	 * @return get a HTML string that could be shown on the JFrame Button
	 */
	public String toHTMLString() {
		String result=new String();
		switch(statusType) {
		case 0:result="Empty Room";break;
		case 1:result="Already Booked";break;
		case 2:result="Already paid";break;
		}
		
		result="<html>Room Number: "+number+"<br>"+result+"<br>"+bedNumber+" bed<br>price is: "+price+" yuan</html>";
		
		return result;
	}

	/**
	 * sort rooms by number, status or price
	 */
	@Override
	public int compareTo(Room r) {
		if (compareType==0)
			return number-r.number;
		if (compareType==1)
			return statusType-r.statusType;
		if (compareType==2)
			return price-r.price;		
		return 0;
	}

}
