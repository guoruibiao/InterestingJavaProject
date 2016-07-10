package date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  Class Date is not helpful for i18n, we often use Class Calendar instead of.
 *  
 *  And here is my date helper.
 *  
 *  If you want to lighter in your project , why not use it? 
 *  
 *  Hope you find it useful.
 * @author mark
 *
 */
public class DateUtil {
	
	/**
	 *  type in string , output the date type data
	 *  
	 * @param dateString   dateString must be the format like '2016-4-22'
	 * @return    
	 */
	public static Date parseToDate(String dateString) {
		
		String[] temp = dateString.split("\\-");
		int[] details = new int[temp.length];
		for(int i = 0  ; i< temp.length ;i++){
			details[i] = Integer.parseInt(temp[i]);
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(details[0], details[1], details[2]);
		return calendar.getTime();
	}

	
	/**
	 * the method to parse the currentMillions for get Date
	 * 
	 * useful for System.currentMillions()
	 * 
	 * @param millions
	 * @return
	 */
	public static String parseCurrentTimeMillions(Long millis) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sdf.format(new Date(millis));
		
		return date;
	}
	
	
	/**
	 * the method to parse the currentMillions for get Date
	 * 
	 * useful for System.currentMillions()
	 * 
	 * @param millions
	 * @return
	 */
	public static String parseCurrentTimeMillionsToChinese(Long millis) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sdf.format(new Date(millis));
		
		String[] temp = date.split("\\-");
		
		String result = temp[0] + "Äê  " + temp[1] + "ÔÂ  " + temp[2] + "ÈÕ  " ;
		
		return result;
	}
	
	
	

}
