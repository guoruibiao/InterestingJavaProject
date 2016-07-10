package python;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDRelative {

	public static void main(String[] args) {
//		Runtime r = Runtime.getRuntime();
//		System.out.println("Ready to carry CMD!");
//		try {
//			r.exec("cmd /k calc");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("End to carry CMD!");
		
		callPing();
		
	}

	public static void callPing() {
		try {
			Process p = Runtime.getRuntime().exec("ping www.douban.com");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			StringBuilder sb = new StringBuilder();
			while((line=br.readLine())!=null){
				sb.append(line);
				sb.append("\n");
			}
			line = new String(sb);
			System.out.println(line.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
