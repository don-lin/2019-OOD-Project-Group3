package Database.Room;

public class Room implements Comparable<Room>{
	public static int compareType=0;
	public int statusType;
	public int number;
	public int bedNumber;
	public int price;
	
	public Room(int statusType,int number,int bedNumber,int price) {
		this.statusType=statusType;
		this.number=number;
		this.bedNumber=bedNumber;
		this.price=price;
	}
	
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
