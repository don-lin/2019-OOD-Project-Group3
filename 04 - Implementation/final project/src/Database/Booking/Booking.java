package Database.Booking;


public class Booking{
	public int bookingId;
	public int roomId;
	public int checkIn;
	public int paid;
	public int customerId;
	public int Date;
	
	/**
	 * convert the booking to string
	 * @return a string
	 */
	@Override
	public String toString() {
		String result=new String();
		
		result="Booking Id: "+bookingId+", roomId:"+roomId+" checkIn:"+checkIn+" paid: "+paid+" customerId:"+customerId+" Date:"+Date;
		
		return result;
	}

}
