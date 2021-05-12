package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
public static Date stringToDate(String s) {
	Date date = null;
	try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		date = formatter.parse(s);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return date;
}
public static String dateToString(Date date) {	
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	return formatter.format(date);

}

public static String timeToString(Date date) {	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
return formatter.format(date);

}
}
