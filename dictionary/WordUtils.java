package dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 工具类，帮助读取文件中的数据以及写入文件中的数据方法
 * 
 * @author 郭瑞彪
 *
 */
public class WordUtils {

	/**
	 * 向文件中写入单词
	 * 
	 * @param word
	 *            要写入的单词的信息
	 */
	public static void write(Word word) {
		try {
			// 打开输入流，读取文件中的数据
			FileInputStream fis = new FileInputStream(new File("src/databases.properties"));
			// Properties很适合按行读取文件流，在内存中将可以通过key-value的方式查询信息
			Properties p = new Properties();
			p.load(fis);

			p.setProperty(word.getName(), word.getValue());
			// 因为Properties存在于内存中，所以要想把修改过的单词写回文件，就得使用输出流才行
			FileOutputStream fos = new FileOutputStream(new File("src/databases.properties"));
			// 调用properties的API将内存中的文件写回到硬盘中
			p.store(fos, "Store item:" + word.toString());
			// 用完文件流记得要关闭
			fos.close();
			fis.close();
		} catch (Exception e) {
			throw new RuntimeException("向文件中写入单词时失败！\n" + e);
		}
	}

	/**
	 * 根据所给的单词的名称，查找其真实的释义
	 * 
	 * @param name
	 *            所要查找的单词的名称
	 * @return 若存在这个单词则返回这个单词的释义，否则返回null
	 */
	public static String read(String name) {
		try {
			// 使用文件输入流将硬盘中的文件读取到内存中，方便我们操作
			FileInputStream fis = new FileInputStream(new File("src/databases.properties"));
			Properties p = new Properties();
			p.load(fis);
			fis.close();
			// 所所查找的单词的名称存在，则返回该单词的释义，否则返回null
			return p.getProperty(name) != null ? p.getProperty(name) : null;
		} catch (Exception e) {
			throw new RuntimeException("读取单词信息时失败！\n" + e);
		}
	}

	/**
	 * 提供修改单词的方法
	 * 
	 * @param word
	 *            从外边传过来的封装好的单词Bean来进行修改操作
	 */
	public static void modify(Word word) {
		try {
			write(word);
		} catch (Exception e) {
			throw new RuntimeException("修改单词含义的时候出错了！ :\n" + e);
		}
	}

}
