/**
 * @Date 2016年7月25日
 *
 * @author Administrator
 */
package webserverspeedtest;

import java.lang.reflect.Array;
import java.net.URL;

/**
 * @author 郭瑞彪
 *
 */
public class Parameter {
	
	URL url ;
	String[] key;
	String[] value;
	String method;
	int length = 0;
	public void addPair(String k, String v) {
		Array.set(key, length, k);
		Array.set(value, length, v);
		length++;
	}

}
