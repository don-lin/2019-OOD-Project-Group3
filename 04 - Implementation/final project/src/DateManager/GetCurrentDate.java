package DateManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetCurrentDate {
    public static String currentDate="2019-12-06";
    
    public static void addOne() {
	modify(1);
    }
    
    public static void minusOne() {
	modify(-1);
    }
    
    private static void modify(int date) {
	String dt = currentDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	try {
	    c.setTime(sdf.parse(dt));
	} catch (Exception e) {
	    System.err.println("parse error!!");
	}
	c.add(Calendar.DATE, date);  // number of days to add
	dt = sdf.format(c.getTime());  // dt is now the new date
	currentDate=dt;
	System.out.println(currentDate);
    }
}
