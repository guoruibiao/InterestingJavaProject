/**
 * @Date 2016年7月25日
 *
 * @author Administrator
 */
package webserverspeedtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author 郭瑞彪
 *
 */
public class TestThread implements Runnable {
private Parameter params;
	public TestThread(Parameter params) {
		this.params = params;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long time1 = new Date().getTime();
		try {
			URL target = params.url;
			HttpURLConnection conn = (HttpURLConnection) target.openConnection();
			conn.setRequestMethod(params.method);
			for(int i = 0; i<params.length;i++) {
				conn.setRequestProperty(params.key[i], params.value[i]);
			}
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputline = "";
			while((inputline =reader.readLine())!=null) {
			}
			
		} catch (Exception e) {
			throw new RuntimeException("TestThread run方法出错 :\n" + e);
		}
		long time2 = new Date().getTime();
		System.out.println("一次测速的响应时间为:" + (time2-time1)+"毫秒！");
	}

}
