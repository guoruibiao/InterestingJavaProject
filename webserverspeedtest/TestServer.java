/**
 * @Date 2016年7月25日
 *
 * @author Administrator
 */
package webserverspeedtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;

/**
 * @author 郭瑞彪
 *
 */
public class TestServer {

	private static int looptime = 500;

	public Parameter readFromArgFile(String str) {
		FileInputStream fis;
		BufferedReader reader;
		Parameter params = new Parameter();
		try {
			fis = new FileInputStream(new File(str));
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = "";
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("URL") == true && line.indexOf("=") >= 3) {
					int f = line.indexOf("=");
					String urlstring = line.substring(f + 1);
					urlstring.trim();
					params.url = new URL(urlstring);
				} else if (line.startsWith("METHOD") == true && line.indexOf("=") >= 3) {
					int f = line.indexOf("=");
					String method = line.substring(f + 1);
					method.trim();
					params.method = method;
				} else if (line.indexOf("=") != -1) {
					int f = line.indexOf("=");
					String key = line.substring(0, f - 1);
					String value = line.substring(f + 1);
					params.addPair(key, value);
				}
			}
			reader.close();
			fis.close();
			return params != null ? params : null;
		} catch (Exception e) {
			throw new RuntimeException(" :\n" + e);
		}
	}

	public static void main(String[] args) {
		int i ,j;
		Parameter params ;
		TestServer tester = new TestServer();
		for(i = 0 ; i< Array.getLength(args);i++) {
			params = tester.readFromArgFile(args[i]);
			for(j = 0 ; j<looptime ;j++) {
				Thread thread = new Thread(new TestThread(params));
				thread.start();
			}
		}
	}
	
}
