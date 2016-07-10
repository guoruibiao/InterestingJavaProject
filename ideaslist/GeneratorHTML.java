package ideaslist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * <p>
 * ���ڣ� 2016��5��5��13:01:53<br>
 * 
 * ��������������һ�������Զ�����һ��HTMLģ���ļ���С����<br>
 * 
 * ˼·�� ������StringBuilder��ʵ�����ѡ�����Ӻ��޸�<br>
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
			throw new RuntimeException("������Ϣ�� " + e);
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
	 * "text/html; charset=utf-8" /> <title>�ޱ���</title> </head> <body>
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
			throw new RuntimeException("������Ϣ�� " + e);
		}
	}

	public static void main(String[] args) {
		String title = "������һ����ҳ�ı��ⲿ��";
		GeneratorHTML generator = new GeneratorHTML();
		String data = generator.setData(title);
		String filepath = "F:\\";
		generator.parseToFile(data, filepath, "mytest.html");
		JOptionPane.showMessageDialog(null, "����HTMLģ���ļ������ɣ��뵽" + filepath + "�½��в鿴");
	}

}
