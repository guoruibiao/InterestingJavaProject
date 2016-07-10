package ideaslist;

import javax.swing.text.ChangedCharSetException;

/**
 * 日期：2016年5月2日23:18:33
 * 
 * 描述：这是一个英语语言游戏。基本规则是将一个英语单词的第一个辅音音素的字母移动到词尾并且加上后缀-ay
 * （譬如“banana”会变成“anana-bay”）。可以在维基百科上了解更多内容。
 * 
 * 算法：这里很简单了，就不多说咯
 * 
 * @author Administrator
 *
 */
public class LatinaPig {

	/**
	 * 利用StringBuilder来添加需要的数据
	 * 
	 * String类的一些常用的API是很有用的，使得我们对于字符串的额操作更加的方便
	 * 
	 * @param target
	 * @return
	 */
	public static String change(String target) {

		try {

			StringBuilder sb = new StringBuilder();
			char temp = target.charAt(0);
			sb.append(target.substring(1));
			sb.append(temp);
			sb.append("-bay");

			String result = new String(sb);

			return result;
		} catch (Exception e) {
			throw new RuntimeException("错误出自： " + e);
		}

	}

	public static void main(String[] args) {
		String testStr = "banana";
		String result = change(testStr);
		System.out.println(result);
	}

}
