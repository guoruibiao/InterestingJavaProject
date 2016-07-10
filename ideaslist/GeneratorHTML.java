package ideaslist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * <p>
 * 日期： 2016年5月5日13:01:53<br>
 * 
 * 需求描述：制作一个可以自动生成一个HTML模板文件的小程序<br>
 * 
 * 思路： 借助于StringBuilder来实现相关选项的添加和修改<br>
 * 
 * @author Administrator
 *         </p>
 */
public class GeneratorHTML {

	private FileOutputStream fos;

	public File parseToFile(String title, String path, String filename) {
		try {
			String data = setData(title);
			File file = new File(path, filename);
			fos = new FileOutputStream(file);
			byte[] buffer = data.getBytes();
			fos.write(buffer, 0, buffer.length);
			fos.flush();
			fos.close();
			return file;

		} catch (Exception e) {
			throw new RuntimeException("错误信息： " + e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	/**
	 * <html> <head> <meta http-equiv="Content-Type" content=
	 * "text/html; charset=utf-8" /> <title>无标题</title> </head> <body>
	 * 
	 * </body> </html>
	 * 
	 * @param title
	 * @return
	 */
	public String setData(String title) {

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("<html>" + "<br>");
			sb.append("<head>" + "<br>");
			sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" + "<br>");
			sb.append("<title>" + title + "</title>" + "<br>");
			sb.append("</head>" + "<br>");
			sb.append("<body>" + "<br>");
			sb.append("<br>" + "</body>" + "<br>");
			sb.append("</html>" + "<br>");

			String result = new String(sb);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("错误信息： " + e);
		}
	}

	public static void main(String[] args) {
		String title = "这里是一个网页的标题部分";
		GeneratorHTML generator = new GeneratorHTML();
		String data = generator.setData(title);
		String filepath = "F:\\";
		generator.parseToFile(data, filepath, "mytest.html");
		JOptionPane.showMessageDialog(null, "您的HTML模板文件已生成，请到" + filepath + "下进行查看");
	}

}
