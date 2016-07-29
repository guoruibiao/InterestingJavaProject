/**
 * @Date 2016年7月29日
 *
 * @author Administrator
 */
package stringutil;

/**
 * @author 郭瑞彪
 *
 */
public class StringUtils {

	/**
	 * 将给定的字符串的第一个字母小写化，做成property的形式
	 * 
	 * @param raw
	 *            给定的字符串
	 * @return 返回格式化好的自付处理结果
	 */
	public static String subFirstChar(String raw) {
		String prefix = raw.substring(0, 1);
		String affix = raw.substring(1, raw.length());
		System.out.println(prefix);
		System.out.println(affix);
		return prefix.toLowerCase() + affix;
	}

	/**
	 * 根据给定的文件路径，摘取出文件名
	 * 
	 * @param filepath
	 *            给定的文件的全路径
	 * @return 返回所需的纯文件名称
	 */
	public static String getFileName(String filepath) {
		int beginIndex = filepath.lastIndexOf("/");
		String filename = filepath.substring(beginIndex + 1, filepath.length());
		return filename;
	}

}
