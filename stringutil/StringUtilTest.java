/**
 * @Date 2016年7月29日
 *
 * @author Administrator
 */
package stringutil;

import org.junit.Test;

/**
 * @author 郭瑞彪
 *
 */
public class StringUtilTest {


	@Test
	public void subFirstChar() throws Exception {
		String result = StringUtils.subFirstChar("StringUtilTest");
		System.out.println("StringUtilTest--->>>" + result);
	}
	
	@Test
	public void getFileName() throws Exception {
		String filename = StringUtils.getFileName("E://Code//Java//StringUtils.java");
		System.out.println("The file name is:" + filename);
	}
	
}
